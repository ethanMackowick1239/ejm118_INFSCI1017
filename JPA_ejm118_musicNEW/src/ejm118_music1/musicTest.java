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
			AlbumManager amm = new AlbumManager();
	amm.CreateAlbum("2", "Oh my, Satan", "2019-02-16", "SCDC", 8);
		
		
	}
}
