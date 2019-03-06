package ejm118_music1;
import java.sql.*;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.net.URL;
public class musicTest {

	public static void main(String[] args) 
	{
	
//		artistManager am = new artistManager();
//		am.CreateArtist("3", "Daisy Chain", "Jam");
//			AlbumManager amm = new AlbumManager();
//	amm.CreateAlbum("3", "Oh my, Satan", "2019-02-16", "SCDC", 8);
	
	SongManager sm = new SongManager();
		//sm.CreateSong("2", "Lines", 10, "Who cares", "2019-8-10", "2019-5-22");
		//sm.updateArtist("2",  "Red", 10, "Who cares", "2019-8-10", "2019-5-22");
		sm.deleteArtist("2");
		
		
	}
}
