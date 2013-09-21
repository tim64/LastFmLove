/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lastfmlove;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.*;

/**
 *
 * @author Тим
 */
public class Downloader {
    public String user_name = "";
    public int limit = 0;
    private ArrayList<Song> song_list = new ArrayList<>();
    
    
    public String get_request(String user_name, String limit)
    {
        String urlPath = "http://ws.audioscrobbler.com/2.0/?method=user.getlovedtracks&user=" + user_name + "&limit=" + limit + "&api_key=acb7e0b5d3b7084c491d8720340e43d5";
        return urlPath;
    }
    
    public ArrayList<Song> read_xml(String urlPath)
    {  
        Song s = new Song();
        try {
            System.out.println(urlPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(urlPath);
            create_song_list(doc,0);
            int back_idx = song_list.size() - 1;
            if(song_list.get(back_idx).artist.isEmpty() || song_list.get(back_idx).title.isEmpty())
                song_list.remove(back_idx);
            return song_list;      
        }
        catch (ParserConfigurationException | IOException | SAXException e) {
            return null;
        }
    }   
        
   public void create_song_list(Node node, int level) {
    NodeList nodes = node.getChildNodes();  
    int back_idx = song_list.size() - 1;
     if (song_list.isEmpty() || (!song_list.get(back_idx).artist.isEmpty() && !song_list.get(back_idx).title.isEmpty()))
     {
         Song s = new Song();
         song_list.add(s);
     }
   
    String txt, grandfather, father;
    for(int i=0, nodes_len=nodes.getLength(); i<nodes_len; i++) {   
    if (nodes.item(i).getNodeType()==Node.TEXT_NODE) { 
     
     father=nodes.item(i).getParentNode().getNodeName();
     grandfather=nodes.item(i).getParentNode().getParentNode().getNodeName();
     txt=nodes.item(i).getNodeValue();
     back_idx = song_list.size() - 1;
     if ("name".equals(father) && "artist".equals(grandfather))
     {
         Song tmp = song_list.get(back_idx);
         tmp.set_artist(txt);
         song_list.set(back_idx, tmp);
     }
     if ("name".equals(father) && "track".equals(grandfather))
     {
         Song tmp = song_list.get(back_idx);
         tmp.set_title(txt);
         song_list.set(back_idx, tmp);
     }
    } 
    create_song_list(nodes.item(i), level+1);
    }
   }
   }

     
    