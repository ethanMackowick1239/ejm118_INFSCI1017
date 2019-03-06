package ejm118_music1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SongManager {

	public void CreateSong(String songID, String title, int length, String filePath, String releaseDate, String recordDate)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_ejm118_music_Song");
		
		EntityManager entMan = emFactory.createEntityManager();
		
		entMan.getTransaction().begin();
		Song a = new Song();
		a.setSongID(songID);
		a.setTitle(title);
		a.setLength(length);
		a.setFilePath(filePath);
		
		
		//add the object to the ORM object grid
		entMan.persist(a);
		
		//commit transaction
		entMan.getTransaction().commit();
		
		//Close connection to persistence manager
		entMan.close();
		emFactory.close();
	}
	
	public void updateArtist(String artistID, String bandName, String bio)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_ejm118_music_Artist");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist a = em.find(Artist.class, artistID);
		
		if(!bandName.equals(""))
		{
			a.setBandName(bandName);
		}
		if(!bio.contentEquals(""))
		{
			a.setBio(bio);
		}
		
		em.persist(a);
	    em.getTransaction().commit();
		
		//Close connection to persistence manager
		em.close();
		emFactory.close();
	}
	
	public void deleteArtist(String artistID, String bandName, String bio)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_ejm118_music_Artist");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist a = em.find(Artist.class, artistID);
	
		em.remove(a);
	    em.getTransaction().commit();
		
		//Close connection to persistence manager
		em.close();
		emFactory.close();
	}
}
