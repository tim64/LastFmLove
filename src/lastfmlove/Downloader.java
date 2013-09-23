package lastfmlove;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.*;
public class Downloader {
    public String user_name = "";
    public int limit = Integer.valueOf(0);
    private ArrayList<Song> song_list = new ArrayList<>();
    
    
    public String get_request_track(String user_name, String limit) {
        String url_path = "http://ws.audioscrobbler.com/2.0/?method=user.getlovedtracks&user=" + user_name + "&limit=" + limit + "&api_key=acb7e0b5d3b7084c491d8720340e43d5";
        return url_path;
    }
    
    public String get_request_album(String artist, String title) {
        String url_path = "http://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key=acb7e0b5d3b7084c491d8720340e43d5&artist=" + artist + "&track=" + title;
        return url_path;   
    }
    
    public ArrayList<Song> read_tracks(String urlPath) {  
        try {
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
            System.out.println(e.getMessage());
            return null;
        }
    }   
    
    public String get_info(Song s) throws ParserConfigurationException, SAXException {
        Node title;
        String url_path = get_request_album(s.get_artist(), s.get_title()).replace(" ", "%20");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc;
        try {
            doc = builder.parse(url_path);
        } 
        catch (IOException ex) {
            return "albumnotfound!!!!";
        }
        NodeList nl = doc.getElementsByTagName("title");
        Element section = (Element) nl.item(0);
        if (section != null) 
        {
            title = section.getFirstChild();
            return title.getTextContent();  
        }
        return "albumnotfound!!!!";
    }
    
    public void add_albums(ArrayList<Song> song_list) throws IOException, SAXException, ParserConfigurationException {
        String al;
        for (int i = 0; i < song_list.size(); i++)
        {
            Song tmp = song_list.get(i);
            al = get_info(tmp);
            tmp.set_album(al);
            song_list.set(i, tmp);
        }
    }
        
    public void create_song_list(Node node, int level) {
        NodeList nodes = node.getChildNodes();  
        String txt, grandfather, father;
        int back_idx = song_list.size() - 1;
        if (song_list.isEmpty() || (!song_list.get(back_idx).artist.isEmpty() && !song_list.get(back_idx).title.isEmpty())) {
           Song s = new Song();
           song_list.add(s);
        }
        for(int i=0, nodes_len=nodes.getLength(); i<nodes_len; i++) {   
        if (nodes.item(i).getNodeType()==Node.TEXT_NODE) { 
            father=nodes.item(i).getParentNode().getNodeName();
            grandfather=nodes.item(i).getParentNode().getParentNode().getNodeName();
            txt=nodes.item(i).getNodeValue(); 
            back_idx = song_list.size() - 1;
            if ("name".equals(father) && "artist".equals(grandfather)) {
                Song tmp = song_list.get(back_idx);
                tmp.set_artist(txt);
                song_list.set(back_idx, tmp);
            }
            if ("name".equals(father) && "track".equals(grandfather)) {
                Song tmp = song_list.get(back_idx);
                tmp.set_title(txt);
                song_list.set(back_idx, tmp);
            }
        } 
        create_song_list(nodes.item(i), level+1);
        }
   }
}

     
    