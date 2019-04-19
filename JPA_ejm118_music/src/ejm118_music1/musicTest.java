package ejm118_music1;
import java.sql.*;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.net.URL;
public class musicTest {

	public static void main(String[] args) 
	{
		//showcases the artist methods
//		artistManager am = new artistManager();
//		am.CreateArtist("9", "Daisy Chain", "Jam");
//		am.CreateArtist("10", "Daisy Chain", "Jam");
//		am.updateArtist("10", "Led Zeppelin", "rock");
//		am.deleteArtist("9");
		
		//showcases the song methods
//		SongManager sm = new SongManager();
//		sm.CreateSong("9", "Lines", 10, "Who cares", "2019-8-10", "2019-5-22");
//		sm.CreateSong("10", "Lines", 10, "Who cares", "2019-8-10", "2019-5-22");
//		sm.updateArtist("10",  "Red", 10, "Who cares", "2019-8-10", "2019-5-22");
//		sm.deleteArtist("9");
		
		//Showcases the album methods
		AlbumManager amm = new AlbumManager();
//		amm.CreateAlbum("13", "Oh my, Satan", "2019-02-16", "SCDC", 8);
//		amm.CreateAlbum("14", "Oh my, Satan", "2019-02-16", "SCDC", 8);
//		amm.updateAlbum("14", "Take it Easy", "2019-02-16", "SCDC", 8);
//		amm.deleteAlbum("13");

	
		//amm.getAlbum("12");
		
		JSONObject gj = new JSONObject();
	
		try {
			gj.append("artist_title" , "harsh nose");
			gj.append("artist_id", "09e7e255-9c3e-4d99-85c2-3547ac10d54d");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(gj.toString());
	}
}
