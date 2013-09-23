/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lastfmlove;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Тим
 */
public class PlaylistCreator {
    
    public void create(ArrayList<Song> song_list, String type) throws FileNotFoundException { 
         int n = 0;
         switch(type) {
            case "pls":
            {
               PrintWriter pls;
               pls = new PrintWriter(new FileOutputStream("lastfmlove.pls"));
               pls.println("[playlist]");
               for (int i = 0; i < song_list.size(); i++)
               {
                   if (!song_list.get(i).path.isEmpty() && song_list.get(i).length != 0)
                   {
                      n++;
                      pls.println("File"+n+"="+song_list.get(i).path);
                      pls.println("Length"+n+"="+song_list.get(i).length);
                   }
               }
               pls.println("NumberOfEntries="+n);
               pls.println("Version=2");  
               pls.close();
               break;
            }
         
            case "m3u":
            {
                PrintWriter m3u;
                m3u = new PrintWriter(new FileOutputStream("lastfmlove.m3u"));
                m3u.println("#EXTM3U");
                for (int i = 0; i < song_list.size(); i++)
                {
                    if (!song_list.get(i).path.isEmpty() && song_list.get(i).length != 0)
                    {
                       n++;
                       m3u.println("#EXTINF:"+song_list.get(i).length+","+song_list.get(i).artist+" - "+song_list.get(i).title);
                       m3u.println(song_list.get(i).path);
                       System.out.println(song_list.get(i).artist+" - "+song_list.get(i).title+" found!");
                    }
                }
                System.out.println(n + " song found");
                m3u.close();
                break;
            }
         }
        
    }
    
}
