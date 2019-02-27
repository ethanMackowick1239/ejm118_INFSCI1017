package ejm118_music1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import com.mysql.jdbc.PreparedStatement;

public class Song {
	private String songID;
	private String title;
	private int length;
	private String filePath;
	private String releaseDate;
	private String recordDate;
	private DbUtilities db;
	private static Hashtable<String, Artist> songArtists = new Hashtable<String, Artist>();
	
	/*
	Creates a new song record in the database
	Creates a new Song object
	Generates a songID using  java.util.UUID.randomUUID() method
	Sets class properties
	*/
	public Song (String title, String releaseDate, String recordDate, int length)
	
	{
		songID = UUID.randomUUID().toString().replaceAll("-", "");
		this.title = title;
		this.releaseDate = releaseDate;
		this.recordDate = recordDate;
		this.length = length;
		
		db = new DbUtilities();
		String sql = "INSERT INTO song (title, release_date, record_date, song_id, length) VALUES "
				+ "(?, ?, ?, ?, ?);";
		System.out.println(sql);
		PreparedStatement stmt = (PreparedStatement) db.executeAlbumQuery1(sql);
		try {
			stmt.setString(1, title);
			stmt.setString(2, releaseDate);
			stmt.setString(3, recordDate);
			stmt.setString(4, songID);
			stmt.setInt(5, length);
			int i = stmt.executeUpdate();
			System.out.println(i + "Records inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	Retrieves an existing record from the database using songID as the key
	Creates a new song object
	Sets class properties
	*/
	public Song(String songID)
	{
		this.songID = songID;
		db = new DbUtilities();	
		
		String sql = "SELECT title, release_date,record_date, length"
				+ "FROM album WHERE (songID = ?);";
		PreparedStatement stmt = (PreparedStatement) db.executeAlbumQuery1(sql);

	    try {
	    	stmt.setString(1, songID);
			ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(sql);
	}
	
	//deletes song's row from database
	public void deleteSong(String songID)
	{
		db = new DbUtilities();
		String sql = "DELETE FROM song WHERE (song_id = ?);";
		PreparedStatement stmt = (PreparedStatement) db.executeAlbumQuery1(sql);
		try {
			stmt.setString(1, songID);
			stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sql);
	}
	
	//adds artist hash map of songArtists
	public void addArtist(Artist artist)
	{
		songArtists.put(new String(artist.getArtistID()), new Artist(artist.getFirstName(), artist.getLastName(), artist.getBandName()));
	}
	
	//deletes artist from Hash map of artist objects using property of object
	public void deleteArtist(Artist artist)
	{
		songArtists.remove(artist.getArtistID());
	}
	
	//deletes artist from hash map using artistID
	public void deleteArtist(String artistID)
	{
		songArtists.remove(artistID);
	}
	

	
	
	
//GETTERS AND SETTERS	!!!!
	

	//returns title
	public String getTitle() {
		return title;
	}
	
	//sets title in db and local code
	public void setTitle(String title) {
		
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE song SET title = '" + title + "'WHERE song_id = '" + this.songID + "';";
		this.title = title;	
		db.executeQuery(sql);
		
	}
	//returns length
	public int getLength() {
		return length;
	}
	
	//sets length in db and locally
	public void setLength(int length) {
		DbUtilities db = new DbUtilities();
		this.length = length;
		String sql = "UPDATE song SET length = '" + length + "'WHERE song_id = '" + this.songID + "';";
		db.executeQuery(sql);
	}
	
	//returns filepath
	public String getFilePath() {
		return filePath;
	}
	
	//sets filepath in db and locally
	public void setFilePath(String filePath) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE song SET filePath = '" + filePath + "'WHERE song_id = '" + this.songID + "';";
		this.filePath = filePath;	
		db.executeQuery(sql);
	}
	
	//returns release date
	public String getReleaseDate() {
		return releaseDate;
	}
	
	//sets release date in db and locally
	public void setReleaseDate(String releaseDate) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE song SET releaseDate = '" + releaseDate + "'WHERE song_id = '" + this.songID + "';";
		this.releaseDate = releaseDate;	
		db.executeQuery(sql);
	}
	
	//returns record date
	public String getRecordDate() {
		return recordDate;
	}
	
	//sets record date in db and locally
	public void setRecordDate(String recordDate) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE song SET recordDate = '" + recordDate + "'WHERE song_id = '" + this.songID + "';";
		this.recordDate = recordDate;	
		db.executeQuery(sql);	}
	
	//returns songID
	public String getSongID() {
		return songID;
	}
	
	
	
}
