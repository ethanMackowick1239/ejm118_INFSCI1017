package ejm118_music1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlbumManager {
	
	public void CreateAlbum(String albumID, String title, String releaseDate, String recordingCompanyName, int numberOfTracks)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_ejm118_music_Artist");
		
		EntityManager entMan = emFactory.createEntityManager();
		
		entMan.getTransaction().begin();
		Album a = new Album();

		a.setAlbumID(albumID);
		a.setTitle(title);
		a.setReleaseDate(releaseDate);
		a.setRecordingCompany(recordingCompanyName);
		a.setNumberOfTracks(numberOfTracks);
		
		//add the object to the ORM object grid
		entMan.persist(a);
		
		//commit transaction
		entMan.getTransaction().commit();
		
		//Close connection to persistence manager
		entMan.close();
		emFactory.close();
	}
	
	public void updateAlbum(String albumID, String title, String releaseDate, String recordingCompanyName, int numberOfTracks)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_ejm118_music_Artist");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album a = em.find(Album.class, 23);
		
		if(!title.equals(""))
		{
			a.setTitle(title);
		}
		if(!releaseDate.contentEquals(""))
		{
			a.setReleaseDate(releaseDate);
		}
		if(!recordingCompanyName.contentEquals(""))
		{
			a.setRecordingCompany(recordingCompanyName);
		}
		if(!releaseDate.contentEquals(""))
		{
			a.setReleaseDate(releaseDate);
		}
		if(numberOfTracks == 0)
		{
			a.setNumberOfTracks(numberOfTracks);
		}
		
		em.persist(a);
	    em.getTransaction().commit();
		
		//Close connection to persistence manager
		em.close();
		emFactory.close();
	}
	
	public void deleteAlbum(String albumID)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_ejm118_music_Artist");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist a = em.find(Artist.class, albumID);
	
		em.remove(a);
	    em.getTransaction().commit();
		
		//Close connection to persistence manager
		em.close();
		emFactory.close();
	}

}
