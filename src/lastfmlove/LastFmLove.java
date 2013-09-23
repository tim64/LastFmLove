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
        final String default_root = "D:\\Music";
        final String default_list = "lastfmlove.m3u";
        final String default_type = "m3u";
        ArrayList<Song> song_list;
        Downloader d = new Downloader();
        Scaner s = new Scaner();
        PlaylistCreator p = new PlaylistCreator();
        System.out.println("Start!");
        String url = d.get_request_track("tim32", "0");
        song_list = d.read_tracks(url);
        System.out.println("Song list created! Size = "+song_list.size());
        d.add_albums(song_list);
        System.out.println("Albums added");
        s.scan_root(default_root, song_list);
        System.out.println("Paths added");
        p.create(song_list,default_type);
        System.out.println("Playlist created");
        System.out.println("Finish!");
        
    }
}

//Добавить проверку существующего плейлиста
//Решить поиск саундтреков
//Улучшить поиск по папкам