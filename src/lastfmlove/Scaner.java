/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author Тим
 */
public class Scaner {
    
    public void scan_root(String root_dir, ArrayList<Song> song_list) throws IOException, Exception {
        FileFinder f = new FileFinder();
        List dirs;
        String path, input;
        dirs = f.findDirectories(root_dir);
        for (int s = 0; s < song_list.size(); s++)
        {
            String artist = song_list.get(s).artist.toLowerCase().replace(" ", "");
                    for (int d = 0; d < dirs.size(); d++)
                    {
                        path = dirs.get(d).toString();
                        input = dirs.get(d).toString().toLowerCase().replace(" ", "");
                        if (input.indexOf(artist) > -1) {
                            folder_path_creator(path, song_list, s);
                        }
                    }
                 //}
        }   
    }
    
    public void folder_path_creator(String root_dir, ArrayList<Song> song_list, int ind) throws IOException {
        List paths;
        String filename;
        FileFinder f = new FileFinder();
            try {
                paths = f.findFiles(root_dir, song_list.get(ind).title);
                for (int i = 0; i < paths.size(); i++)
                {
                    filename = paths.get(i).toString();
                    File source_file = new File(filename); 
                    AudioFile af = AudioFileIO.read(source_file);
                    Tag tag = af.getTag();
                    AudioHeader head = af.getAudioHeader();
                    if (tag.getFirst(FieldKey.TITLE).equals(song_list.get(ind).title))
                            {
                                
                                Song tmp = song_list.get(ind);
                                tmp.set_len(head.getTrackLength());
                                tmp.set_path(paths.get(i).toString());
                                song_list.set(ind, tmp);
                            }
                }
            }
            catch (Exception e) {
        }
    }
    
    public static String getFileExtention(String filename){
        int dotPos = filename.lastIndexOf(".") + 1;
        return filename.substring(dotPos);
    }
    

    

}
