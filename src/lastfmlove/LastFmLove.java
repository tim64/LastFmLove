/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lastfmlove;

import java.io.IOException;
import java.util.ArrayList;
import org.farng.mp3.TagException;

/**
 *
 * @author Тим
 */
class LastFmLove {
    
    public static void main (String[] args) throws IOException, TagException, Exception
    {
        ArrayList<Song> song_list;
        Downloader d = new Downloader();
        Scaner s = new Scaner();
        String url = d.get_request("tim32", "20");
        song_list = d.read_xml(url); 
        s.scan_root("D:\\Music", song_list);
        for (int i  = 0; i < song_list.size(); i++)
        {
            System.out.println(song_list.get(i).path);
        }
        
    }
}


//Scaner добавляет одинаковые файлы