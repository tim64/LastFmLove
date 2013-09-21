/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lastfmlove;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Тим
 */
class LastFmLove {
    
    public static void main (String[] args) throws IOException, Exception
    {
        ArrayList<Song> song_list;
        Downloader d = new Downloader();
        Scaner s = new Scaner();
        PlaylistCreator p = new PlaylistCreator();
        String url = d.get_request("tim32", "3000");
        song_list = d.read_xml(url); 
        s.scan_root("D:\\Music", song_list);
        p.create(song_list,"m3u");
        
    }
}
