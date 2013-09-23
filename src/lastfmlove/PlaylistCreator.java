package lastfmlove;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
public class PlaylistCreator {
    public void create(ArrayList<Song> song_list) throws FileNotFoundException { 
        PrintWriter m3u;
        m3u = new PrintWriter(new FileOutputStream("lastfmlove.m3u"));
        m3u.println("#EXTM3U");
        for (int i = 0; i < song_list.size(); i++) {
            if (!song_list.get(i).path.isEmpty() && song_list.get(i).length != 0) {
                m3u.println("#EXTINF:"+song_list.get(i).length+","+song_list.get(i).artist+" - "+song_list.get(i).title);
                m3u.println(song_list.get(i).path);
            }
        }
        m3u.close();
    }    
}