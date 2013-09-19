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
    
    Song (String t, String a)
    {
        title = t;
        artist = a;
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
          
}
