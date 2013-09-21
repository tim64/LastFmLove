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
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.audio.flac.FlacAudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.ID3v24Frames;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.*;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.tag.flac.FlacTag;
import org.jaudiotagger.tag.mp4.Mp4FieldKey;
import org.jaudiotagger.tag.mp4.Mp4Tag;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentFieldKey;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;
/**
 *
 * @author Тим
 */
public class Scaner {
    
    public void scan_root(String root_dir, ArrayList<Song> song_list) throws IOException, Exception {
        FileFinder f = new FileFinder();
        List dirs;
        String path, input;
        Pattern pattern;
        Matcher matcher;
        dirs = f.findDirectories(root_dir);
        for (int s = 0; s < song_list.size(); s++)
        {
            String artist = song_list.get(s).artist.toLowerCase().replace(" ", "");
            //pattern = Pattern.compile(song_list.get(s).artist);
                 //if (!pattern.pattern().isEmpty())
                 //{
                    for (int d = 0; d < dirs.size(); d++)
                    {
                        path = dirs.get(d).toString();
                        input = dirs.get(d).toString().toLowerCase().replace(" ", "");
                        //matcher = pattern.matcher(input); 
                        //if (matcher.) {
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
