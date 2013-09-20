/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lastfmlove;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

/**
 *
 * @author Тим
 */
public class Scaner {
    
    public void scan_root(String root_dir, ArrayList<Song> song_list) throws IOException, Exception {
        FileFinder f = new FileFinder();
        List dirs;
        String input;
        Pattern pattern;
        Matcher matcher;
        dirs = f.findDirectories(root_dir);
        for (int s = 0; s < song_list.size(); s++)
        {
            pattern = Pattern.compile(song_list.get(s).artist);
                 if (!pattern.pattern().isEmpty())
                 {
                    for (int d = 0; d < dirs.size(); d++)
                    {
                        input = dirs.get(d).toString();
                        matcher = pattern.matcher(input); 
                        if (matcher.find()) {
                            folder_path_creator(input, song_list, s);
                        }
                    }
                 }
        }   
    }
    
    public void folder_path_creator(String root_dir, ArrayList<Song> song_list, int ind) throws IOException {
        int count = 0;
        List paths;
        MP3File mp3_file;
        FileFinder f = new FileFinder();
            try {
                paths = f.findFiles(root_dir, song_list.get(ind).title);
                for (int i = 0; i < paths.size(); i++)
                {
                    File source_file = new File(paths.get(i).toString());                 
                    mp3_file = (MP3File)AudioFileIO.read(source_file);
                    if (mp3_file.getID3v1Tag().getFirstTitle().equals(song_list.get(ind).title))
                    {
                        count++;
                        Song tmp = song_list.get(ind);
                        tmp.set_path(paths.get(i).toString());
                        song_list.set(ind, tmp);
                    }
                }
            }
            catch (Exception e) {
                //System.out.println("no read "+song_list.get(ind).title);
        }
    } 
}
