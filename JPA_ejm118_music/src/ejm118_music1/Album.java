package ejm118_music1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import com.mysql.jdbc.PreparedStatement;

public class Album {
	
	private String albumID;
	private String title;
	private String releaseDate;
	private String coverImagePath;
	private String recordingCompany;
	private int numberOfTracks;
	private String pmrcRating;
	private int length;
	private DbUtilities db;
	private Hashtable<String, Song> albumSongs = new Hashtable<String, Song>();
	
	
	/*
	Creates a new album record in the database
	Creates a new Album object
	Generates a albumID using  java.util.UUID.randomUUID() method
	Sets corresponding class properties

	 */
	public Album(String title, String releaseDate, String recordingCompany, int numberOfTracks, String pmrcRating, int length)
	{
		albumID = UUID.randomUUID().toString().replaceAll("-", "");
		this.title = title;
		this.releaseDate = releaseDate;
		this.recordingCompany = recordingCompany;
		this.numberOfTracks = numberOfTracks;
		this.pmrcRating = pmrcRating;
		this.length = length;
		
		String sql = "INSERT INTO album";
		sql = sql + "(title, release_date, recording_company_name, number_of_tracks, PMRC_rating, length, album_id)";
		sql = sql + "VALUES";
		sql = sql + "(?,?,?,?,?,?,?);";
		db = new DbUtilities();	
		PreparedStatement stmt = (PreparedStatement) db.executeAlbumQuery1(sql);
		System.out.println(sql);
		try {
			stmt.setString(1, title);
			stmt.setString(2, releaseDate);
			stmt.setString(3, recordingCompany);
			stmt.setInt(4, numberOfTracks);
			stmt.setString(5, pmrcRating);
			stmt.setInt(6, length);
			stmt.setString(7, albumID);
			int i = stmt.executeUpdate();
			System.out.println(i + "Records inserted");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/*
	  Retrieves an existing record from the database using albumid as the key
	  Creates a new Album object
	  Sets corresponding class properties
	 */
	
	public Album(String albumID)
	{
		this.albumID = albumID;
		db = new DbUtilities();	
		
		String sql = "SELECT title, release_date, recording_company_name,"
				+ " number_of_tracks, length, PMRC_rating FROM album WHERE (album_id = ?);";
		PreparedStatement stmt = (PreparedStatement) db.executeAlbumQuery1(sql);

	    try {
	    	stmt.setString(1, albumID);
			ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(sql);
	}
	
	
	//Deletes an album from the database using albumID as the key
	public void deleteAlbum(String albumID)
	{
		db = new DbUtilities();
		String sql = "DELETE FROM album WHERE (album_id = ?);";
		PreparedStatement stmt = (PreparedStatement) db.executeAlbumQuery1(sql);
		try {
			stmt.setString(1, albumID);
			stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sql);
	}
	
	
	
	
	//Adds new Song object to the hash map of album's songs
	public void addSong(Song song)
	{
		
		albumSongs.put(new String (song.getSongID()), new Song(song.getTitle(), song.getReleaseDate(), song.getRecordDate(), song.getLength()));
	}
	
	//Deletes a song from the hash map of album songs using songID
	public void deleteSong(String songID)
	{
		albumSongs.remove(songID);
	}
	
	//Deletes a song from the hash map of album songs using property of song object
	public void deleteSong(Song song)
	{
		albumSongs.remove(song.getSongID());
	}
	


	
//GETTERS AND SETTERS	!!!!!!!
	
	
	
//returns the album title
	public String getTitle() {
		return title;
	}

	//sets the title locally and in the database with @param title
	public void setTitle(String title) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE album SET title = '" + title + "'WHERE album_id = " + this.albumID + ";";
		this.title = title;	
		db.executeQuery(sql);	
	}
	
	//returns reeleaseDate
	public String getReleaseDate() {
		return releaseDate;
	}
	
	//sets release date locally and in db
	public void setReleaseDate(String releaseDate) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE album SET release_date = '" + releaseDate + "'WHERE album_id = " + this.albumID + ";";
		this.releaseDate = releaseDate;	
		db.executeQuery(sql);
	}
	
	//returns cover imgage path
	public String getCoverImagePath() {
		return coverImagePath;
	}

	//sets cover image path locally and in db
	public void setCoverImagePath(String coverImagePath) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE album SET cover_image_path = '" + coverImagePath + "'WHERE album_id = " + this.albumID + ";";
		this.coverImagePath = coverImagePath;	
		db.executeQuery(sql);
	}
	
	//returns name of recording Company
	public String getRecordingCompany() {
		return recordingCompany;
	}

	//Sets name of recording company locally and in db
	public void setRecordingCompany(String recordingCompany) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE album SET recording_company_name = '" + recordingCompany + "'WHERE album_id = " + this.albumID + ";";
		this.recordingCompany = recordingCompany;	
		db.executeQuery(sql);
	}

		
	//return number of tracks in album
	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	//sets number of tracks in album
	public void setNumberOfTracks(int numberOfTracks) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE album SET number_of_tracks = '" + numberOfTracks + "'WHERE albumI_id = " + this.albumID + ";";
		this.numberOfTracks = numberOfTracks;	
		db.executeQuery(sql);
	}

	//returns pmrc rating
	public String getPmrcRating() {
		return pmrcRating;
	}

	//sets Pmrc rating locally and in db
	public void setPmrcRating(String pmrcRating) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE album SET PMRC_rating = '" + pmrcRating + "'WHERE album_id = '" + this.albumID + "';";
		this.pmrcRating = pmrcRating;	
		db.executeQuery(sql);
	}

	//returns length
	public int getLength() {
		return length;
	}

	//sets length locally and in db
	public void setLength(int length) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE album SET length = '" + length + "'WHERE album_id = '" + this.albumID + "';";
		System.out.println(sql);
		this.length = length;	
		db.executeQuery(sql);
	}


	public String getAlbumID() {
		return albumID;
	}
	


}
