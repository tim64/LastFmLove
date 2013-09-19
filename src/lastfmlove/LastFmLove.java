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
        ArrayList<Song> song_list = new ArrayList<>();
        Downloader d = new Downloader();
        Scaner s = new Scaner();
        String url = d.get_request("tim32", "100");
        song_list = d.read_xml(url); 
        System.out.println(song_list);
        s.scan_root("D:\\Music", song_list);
        
    }
}


 