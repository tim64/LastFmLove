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
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.*;

/**
 *
 * @author Тим
 */
public class Scaner {
    
    public void scan_root(String root_dir, ArrayList<Song> song_list) throws IOException, Exception {
        FileFinder f = new FileFinder();
        List dirs, paths = null;
        //ArrayList <String> paths = new ArrayList<>();
        String input;
        Pattern pattern;
        Matcher matcher;
        dirs = f.findDirectories(root_dir);
        //System.out.println(song_list);
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
                            paths = folder_path_creator(input, song_list.get(s).title);
                        }
                    }
                 }
                 System.out.println(paths);

         
        }
        
    }
    
    public List folder_path_creator(String root_dir, String title) throws IOException, TagException {
        List paths = null;
        ArrayList <String> result = new ArrayList<>();
        FileFinder f = new FileFinder();
            try {
                paths = f.findFiles(root_dir,title);
                for (int i = 0; i < paths.size(); i++)
                {
                    File source_file = new File(paths.get(i).toString());
                    MP3File mp3_file = new MP3File(source_file);
                    //System.out.println("file = " + mp3_file.getID3v1Tag().getTitle()); 
                    if (mp3_file.getID3v1Tag().getTitle().equals(title))
                    {
                        result.add(paths.get(i).toString());
                    }
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
        }
    
    return result;
    }
    
}
