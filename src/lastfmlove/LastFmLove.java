package lastfmlove;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class LastFmLove {
    
    public static void main (String[] args) throws IOException, Exception
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter user name: ");
        String user = scan.nextLine();
        System.out.print("Enter root folder with music: ");
        String root = scan.nextLine();
        System.out.print("Enter limit playlist: ");
        String limit = scan.nextLine();
        
        ArrayList<Song> song_list;
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
