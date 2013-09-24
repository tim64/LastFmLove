package lastfmlove;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.audio.AudioFile;

public class Scaner {
    public void scan_root(String root_dir, ArrayList<Song> song_list) throws IOException, Exception {
        String artist;
        String album;
        int n = 0;
        FileFinder f = new FileFinder();
        boolean check_path = false;
        List dirs;
        String path, input;
        dirs = f.findDirectories(root_dir);
        for (int s = 0; s < song_list.size(); s++) {
            artist = song_list.get(s).get_artist().toLowerCase().replace(" ", "").replace("_","");
            album = song_list.get(s).get_album().toLowerCase().replace(" ", "").replace("_","");
            if (!"albumnotfound!!!!".equals(album)) {
                for (int d = 0; d < dirs.size(); d++)
                {
                    path = dirs.get(d).toString();
                    input = dirs.get(d).toString().toLowerCase().replace(" ", "");
                    if (input.indexOf(album) > -1) {
                        check_path = folder_path_creator(path, song_list, s);     
                    }
                 }   
            }
            if (check_path == false)  {
                for (int d = 0; d < dirs.size(); d++) {
                    path = dirs.get(d).toString();
                    input = dirs.get(d).toString().toLowerCase().replace(" ", "");
                    if (input.indexOf(artist) > -1) {
                        folder_path_creator(path, song_list, s);
                    }
                }  
            }
           check_path = false;
           n++;
        }
    }
    
    public boolean folder_path_creator(String root_dir, ArrayList<Song> song_list, int ind) throws IOException {
        List paths;
        String filename;
        FileFinder f = new FileFinder();
        try {
            paths = f.findFiles(root_dir, song_list.get(ind).title);
            for (int i = 0; i < paths.size(); i++) {
                filename = paths.get(i).toString();
                File source_file = new File(filename); 
                AudioFile af = AudioFileIO.read(source_file);
                Tag tag = af.getTag();
                AudioHeader head = af.getAudioHeader();
                if (tag.getFirst(FieldKey.TITLE).equals(song_list.get(ind).title)) {
                    Song tmp = song_list.get(ind);
                    tmp.set_len(head.getTrackLength());
                    tmp.set_path(paths.get(i).toString());
                    song_list.set(ind, tmp);
                     return true;
                }
            }
            return false;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public static String getFileExtention(String filename){
        int dotPos = filename.lastIndexOf(".") + 1;
        return filename.substring(dotPos);
    }
}
