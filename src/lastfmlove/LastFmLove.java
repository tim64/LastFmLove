/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lastfmlove;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Тим
 */
class LastFmLove {
    
    public static void main (String[] args) throws IOException, Exception
    {
        int sum = 0;
        ArrayList<Song> song_list;
        Downloader d = new Downloader();
        Scaner s = new Scaner();
        String url = d.get_request("tim32", "1000");
        song_list = d.read_xml(url); 
        s.scan_root("D:\\Music", song_list);
        for (int i  = 0; i < song_list.size(); i++)
        {
            if (!song_list.get(i).path.isEmpty())
            {
            sum++;   
            //System.out.println(song_list.get(i).path);
            }
        }
        System.out.println("In all: "+song_list.size()+" Found: "+sum);
        
    }
}


//Добавить сканер для версии тегов 1 и 2
//Scaner заходит по нескольку раз к одному и томуже файлу. См. вывод
/*
 * сен 21, 2013 12:26:46 AM org.jaudiotagger.tag.id3.AbstractID3v2Frame readIdentifier
WARNING: 02 Follow Me Down feat. Sleepy Sun.mp3:No space to find another frame:
сен 21, 2013 12:26:46 AM org.jaudiotagger.tag.id3.ID3v23Tag readFrames
WARNING: 02 Follow Me Down feat. Sleepy Sun.mp3:Invalid Frame:02 Follow Me Down feat. Sleepy Sun.mp3:No space to find another frame
сен 21, 2013 12:26:46 AM org.jaudiotagger.tag.id3.AbstractID3v2Frame readIdentifier
WARNING: 02 Follow Me Down feat. Sleepy Sun.mp3:No space to find another frame:
сен 21, 2013 12:26:46 AM org.jaudiotagger.tag.id3.ID3v23Tag readFrames
WARNING: 02 Follow Me Down feat. Sleepy Sun.mp3:Invalid Frame:02 Follow Me Down feat. Sleepy Sun.mp3:No space to find another frame
сен 21, 2013 12:26:46 AM org.jaudiotagger.tag.id3.AbstractID3v2Frame readIdentifier
WARNING: 02 Follow Me Down feat. Sleepy Sun.mp3:No space to find another frame:
сен 21, 2013 12:26:46 AM org.jaudiotagger.tag.id3.ID3v23Tag readFrames
WARNING: 02 Follow Me Down feat. Sleepy Sun.mp3:Invalid Frame:02 Follow Me Down feat. Sleepy Sun.mp3:No space to find another frame
сен 21, 2013 12:26:48 AM org.jaudiotagger.tag.id3.AbstractID3v2Frame readIdentifier
WARNING: 01. [Turn the City Lights off].mp3:No space to find another frame:
сен 21, 2013 12:26:48 AM org.jaudiotagger.tag.id3.ID3v24Tag readFrames
WARNING: 01. [Turn the City Lights off].mp3:Invalid Frame:01. [Turn the City Lights off].mp3:No space to find another frame
сен 21, 2013 12:26:48 AM org.jaudiotagger.tag.id3.AbstractID3v2Frame readIdentifier
WARNING: 01. [Turn the City Lights off].mp3:No space to find another frame:
сен 21, 2013 12:26:48 AM org.jaudiotagger.tag.id3.ID3v24Tag readFrames
WARNING: 01. [Turn the City Lights off].mp3:Invalid Frame:01. [Turn the City Lights off].mp3:No space to find another frame
сен 21, 2013 12:26:48 AM org.jaudiotagger.tag.id3.AbstractID3v2Frame readIdentifier
WARNING: 01. [Turn the City Lights off].mp3:No space to find another frame:
сен 21, 2013 12:26:48 AM org.jaudiotagger.tag.id3.ID3v24Tag readFrames
WARNING: 01. [Turn the City Lights off].mp3:Invalid Frame:01. [Turn the City Lights off].mp3:No space to find another frame
сен 21, 2013 12:26:53 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\Knife Party\Unreleased\Knife Party – Internet Friends (Knife Party Remix).mp3:Checking further because the ID3 Tag ends at 0x346d but the mp3 audio doesnt start until 0x360e
сен 21, 2013 12:26:53 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\Knife Party\Unreleased\Knife Party – Internet Friends (Knife Party Remix).mp3:Checking further because the ID3 Tag ends at 0x346d but the mp3 audio doesnt start until 0x360e
сен 21, 2013 12:26:55 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\VA - Ultimae Records\Solar Fields - 2012 - Random Friday\08. Lift Off.mp3:Checking further because the ID3 Tag ends at 0x800 but the mp3 audio doesnt start until 0xc14
сен 21, 2013 12:26:55 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\Hol Baumann\Unreleased\10. Handwritten Notes.mp3:Checking further because the ID3 Tag ends at 0x2558c but the mp3 audio doesnt start until 0x28df4
сен 21, 2013 12:26:55 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\Hol Baumann\Unreleased\10. Handwritten Notes.mp3:Checking further because the ID3 Tag ends at 0x2558c but the mp3 audio doesnt start until 0x28df4
сен 21, 2013 12:26:55 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\VA - Ultimae Records\Solar Fields - 2012 - Random Friday\05. Daydreaming.mp3:Checking further because the ID3 Tag ends at 0x800 but the mp3 audio doesnt start until 0xc14
сен 21, 2013 12:26:56 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\Biosphere\Bleep\1990 - The North Pole By Submarine (CD, Album)\06. The Snake.mp3:Checking further because the ID3 Tag ends at 0x1000 but the mp3 audio doesnt start until 0x11a1
сен 21, 2013 12:26:56 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\Biosphere\Bleep\1990 - The North Pole By Submarine (CD, Album)\06. The Snake.mp3:Checking further because the ID3 Tag ends at 0x1000 but the mp3 audio doesnt start until 0x11a1
сен 21, 2013 12:27:13 AM org.jaudiotagger.tag.id3.AbstractID3v2Tag loadFrameIntoSpecifiedMap
WARNING: Ignoring Duplicate Frame:RVA2
сен 21, 2013 12:27:13 AM org.jaudiotagger.tag.id3.AbstractID3v2Tag loadFrameIntoSpecifiedMap
WARNING: Ignoring Duplicate Frame:RVA2
сен 21, 2013 12:27:20 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\Enduser\2005 - Enduser - Comparing Paths (VF028CD) (CD, Album)\07 - Devil Tricked The World.mp3:Checking further because the ID3 Tag ends at 0x1a2af but the mp3 audio doesnt start until 0x1a6c3
сен 21, 2013 12:27:21 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\Enduser\2005 - Enduser - Comparing Paths (VF028CD) (CD, Album)\07 - Devil Tricked The World.mp3:Checking further because the ID3 Tag ends at 0x1a2af but the mp3 audio doesnt start until 0x1a6c3
сен 21, 2013 12:27:24 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\VA - Ultimae Records\Solar Fields - 2012 - Random Friday\02. Random Friday.mp3:Checking further because the ID3 Tag ends at 0x800 but the mp3 audio doesnt start until 0xc14
сен 21, 2013 12:27:27 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\Bong-Ra\Bong-Ra\2003 - Junglist! (Clash MX1) (CD) [192]\16 - Bong Ra - Blood & Fire.mp3:Checking further because the ID3 Tag ends at 0xc800 but the mp3 audio doesnt start until 0xca72
сен 21, 2013 12:27:27 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\Bong-Ra\Bong-Ra\2003 - Junglist! (Clash MX1) (CD) [192]\16 - Bong Ra - Blood & Fire.mp3:Checking further because the ID3 Tag ends at 0xc800 but the mp3 audio doesnt start until 0xca72
сен 21, 2013 12:27:27 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\Bong-Ra\Bong-Ra\2003 - Junglist! (Clash MX1) (CD) [192]\16 - Bong Ra - Blood & Fire.mp3:Checking further because the ID3 Tag ends at 0xc800 but the mp3 audio doesnt start until 0xca72
сен 21, 2013 12:27:30 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\The Black Dog\Ov Mind, Ov Magick\17. Siiiipher (Reworked From Bass Soldier Forgemaster Remix).mp3:Checking further because the ID3 Tag ends at 0x819 but the mp3 audio doesnt start until 0x82d
сен 21, 2013 12:27:30 AM org.jaudiotagger.audio.mp3.MP3File checkAudioStart
WARNING:  D:\Music\The Black Dog\Ov Mind, Ov Magick\17. Siiiipher (Reworked From Bass Soldier Forgemaster Remix).mp3:Checking further because the ID3 Tag ends at 0x819 but the mp3 audio doesnt start until 0x82d
 */