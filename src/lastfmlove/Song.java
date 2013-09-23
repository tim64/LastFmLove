package lastfmlove;
public class Song {
    public String title = "";
    public String artist = "";
    public String path = "";
    public String album = "";
    public String url = "";
    public int length = Integer.valueOf(0);
    
    Song (String t, String a, String p) {
        title = t;
        artist = a;
        path = p;
    }
    
     Song (String t, String a, String p, String al, String u, int l) {
        title = t;
        artist = a;
        path = p;
        album  = al;
        url = u;
        length = l;
    }

    Song() {}
 
    public String get_title() {
        return title;
    }
    public void set_title(String title_) {
       title = title_;
    }
    
    public String get_artist() {
        return artist;
    }
    public void set_artist(String artist_) {
        artist = artist_;
    }
     public String get_path() {
        return path;
    }
    public void set_path(String path_) {
        path = path_;
    }
    public String get_album() {
        return album;
    }
    public void set_album(String album_) {
        album = album_;
    }
    
    public String get_url() {
        return url;
    }
    public void set_len(int len_) {
        length = len_;
    }
    public int get_length() {
        return length;
    }
    public void set_length(int len_) {
        length = len_;
    }        
}
