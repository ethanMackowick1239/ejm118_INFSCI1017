package ejm118_music1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SongManager {

	public void CreateSong(String songID, String title, int length, String filePath, String releaseDate, String recordDate)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_ejm118_music_Artist");
		
		EntityManager entMan = emFactory.createEntityManager();
		
		entMan.getTransaction().begin();
		Song a = new Song();
		a.setSongID(songID);
		a.setTitle(title);
		a.setLength(length);
		a.setFilePath(filePath);
		a.setReleaseDate(releaseDate);
		a.setRecordDate(recordDate);
		
		
		//add the object to the ORM object grid
		entMan.persist(a);
		
		//commit transaction
		entMan.getTransaction().commit();
		
		//Close connection to persistence manager
		entMan.close();
		emFactory.close();
	}
	
	public void updateArtist(String songID, String title, int length, String filePath, String releaseDate, String recordDate)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_ejm118_music_Artist");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song a = em.find(Song.class, songID);
		
		if(!title.equals(""))
		{
			a.setTitle(title);
		}
		if(!filePath.contentEquals(""))
		{
			a.setFilePath(filePath);
		}
		if(!releaseDate.equals(""))
		{
			a.setReleaseDate(releaseDate);
		}
		if(!recordDate.contentEquals(""))
		{
			a.setRecordDate(recordDate);
		}
		if(length ==0)
		{
			a.setLength(length);
		}
		
		em.persist(a);
	    em.getTransaction().commit();
		
		//Close connection to persistence manager
		em.close();
		emFactory.close();
	}
	
	public void deleteArtist(String songID)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_ejm118_music_Artist");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song a = em.find(Song.class, songID);
	
		em.remove(a);
	    em.getTransaction().commit();
		
		//Close connection to persistence manager
		em.close();
		emFactory.close();
	}
}
