package ejm118_music1;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class artistManager 
{
	
	//Creates new artist instance in database with the parameters
	public void CreateArtist(String artistID, String bandName, String bio)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_ejm118_music_Artist");
		
		EntityManager entMan = emFactory.createEntityManager();
		
		entMan.getTransaction().begin();
		Artist a = new Artist();
		a.setArtistID(artistID);
		a.setBandName(bandName);
		a.setBio(bio);
		
		//add the object to the ORM object grid
		entMan.persist(a);
		
		//commit transaction
		entMan.getTransaction().commit();
		
		//Close connection to persistence manager
		entMan.close();
		emFactory.close();
	}
	
	//Updates artist row using the artistId and then fill it with the parameters
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
	
	//deletes an album instance in the database using artistID
	public void deleteArtist(String artistID)
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
