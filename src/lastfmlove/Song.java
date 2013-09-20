/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lastfmlove;

/**
 *
 * @author Тим
 */
public class Song {
    public String title = "";
    public String artist = "";
    public String path = "";
    
    Song (String t, String a, String p)
    {
        title = t;
        artist = a;
        path = p;
    }

    Song() {
      
    }
 
    public String get_title() 
    {
        return title;
    }
    public void set_title(String title_) 
    {
       title = title_;
    }
    
    public String get_artist() 
    {
        return artist;
    }
    public void set_artist(String artist_) 
    {
        artist = artist_;
    }
    
     public String get_path() 
    {
        return path;
    }
    public void set_path(String path_) 
    {
        path = path_;
    }
          
}
