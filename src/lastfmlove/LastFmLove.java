package lastfmlove;
import java.io.IOException;
import java.util.ArrayList;

public class LastFmLove {
    public ArrayList<Song> song_list;
    
    public void run(String user, String root, String limit) throws IOException, Exception
    {
        
        Downloader d = new Downloader();
        Scaner s = new Scaner();
        PlaylistCreator p = new PlaylistCreator();
        String url = d.get_request_track(user, limit);
        song_list = d.read_tracks(url);
        d.add_albums(song_list);
        s.scan_root(root, song_list);
        p.create(song_list); 
    }
}
