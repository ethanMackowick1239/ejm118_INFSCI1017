package ejm118_music1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.mysql.jdbc.PreparedStatement;

public class Artist {

	private String artistID;
	private String firstName;
	private String lastName;
	private String bandName;
	private String bio; 
	private DbUtilities db;
	
	/*
	Creates a new artist record in the database
	Creates a new artist object
	Generates a artistID using  java.util.UUID.randomUUID() method
	Sets class properties
	*/
	public Artist(String firstName, String lastName, String bandName)
	{
		artistID = UUID.randomUUID().toString().replaceAll("-", "");
		this.firstName = firstName;
		this.lastName = lastName;
		this.bandName = bandName;
		
		db = new DbUtilities();
		String sql = "INSERT INTO artist (first_name, last_name, band_name, artist_id)"
				+ " VALUES (?,?,?,?);";
		System.out.println(sql);
		PreparedStatement stmt = (PreparedStatement) db.executeAlbumQuery1(sql);
		try {
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, bandName);
			stmt.setString(4, artistID);
			int i = stmt.executeUpdate();
			System.out.println(i + "Records inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	Retrieves an existing record from the database using artistID as the key
	Creates a new Artist object
	Sets corresponding class properties
	*/

	public Artist(String artistID)
	{
		this.artistID = artistID;
		db = new DbUtilities();	
		
		String sql = "SELECT first_name, last_name, band_name"
				+ "FROM artist WHERE (artistID = ?);";
		PreparedStatement stmt = (PreparedStatement) db.executeAlbumQuery1(sql);

	    try {
	    	stmt.setString(1, artistID);
			ResultSet rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(sql);
	    
	}
	
	//deletes a row from the artist table in db using a specific artistID
	public void deletArtist(String artistID)
	{
		db = new DbUtilities();
		String sql = "DELETE FROM artist WHERE (artist_id = ?);";
		PreparedStatement stmt = (PreparedStatement) db.executeAlbumQuery1(sql);
		try {
			stmt.setString(1, artistID);
			stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sql);
	}
	
	
	
	
	//GETTERS AND SETTERS	!!!!
	
	
	//returns first name
	public String getFirstName() {
		return firstName;
	}
	//sets first name in db and locally using artistIF
	public void setFirstName(String firstName) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE artist SET first_Name = '" + firstName + "'WHERE artist_id = '" + this.artistID + "';";
		this.firstName = firstName;	
		db.executeQuery(sql);
	}
	//returns last name
	public String getLastName() {
		return lastName;
	}
	//sets last name locally and in db using artistID
	public void setLastName(String lastName) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE artist SET last_Name = '" + lastName + "'WHERE artist_id = '" + this.artistID + "';";
		this.lastName = lastName;	
		db.executeQuery(sql);	
		}
	
	//returns bandname
	public String getBandName() {
		return bandName;
	}
	//sets band name in db and locally using artistID
	public void setBandName(String bandName) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE artist SET band_Name = '" + bandName + "'WHERE artist_id = '" + this.artistID + "';";
		this.bandName = bandName;	
		db.executeQuery(sql);	
		}
	//returns bio
	public String getBio() {
		return bio;
	}

	//sets bio locally and in db using artistID
	public void setBio(String bio) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE artist SET bio = '" + bio + "'WHERE artist_id = '" + this.artistID + "';";
		this.bio = bio;	
		db.executeQuery(sql);	
	}
	//returns artistID
	public String getArtistID() {
		return artistID;
	}
	
	
	
	
	
	
}
