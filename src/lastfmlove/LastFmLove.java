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
        int sum = 0;
        ArrayList<Song> song_list;
        Downloader d = new Downloader();
        Scaner s = new Scaner();
        String url = d.get_request("tim32", "3000");
        song_list = d.read_xml(url); 
        s.scan_root("D:\\Music", song_list);
        System.out.println("Paths");
        for (int i  = 0; i < song_list.size(); i++)
        {
            if (!song_list.get(i).path.isEmpty())
            {
            sum++;   
            System.out.println(song_list.get(i).path);
            }
        }
        System.out.println("In all: "+song_list.size()+" Found: "+sum);
        
    }
}
