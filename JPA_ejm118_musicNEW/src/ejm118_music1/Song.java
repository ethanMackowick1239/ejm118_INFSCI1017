package ejm118_music1;

import javax.persistence.*;

@Entity
@Table (name = "song")
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column (name = "song_id")
	private String songID;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "length")
	private String length;
	
	@Column(name = "file_path")
	private String coverImagePath;
	
	@Column(name = "release_date")
	private String recordingCompany; 	
	
	@Column(name = "record_date")
	private int numberOfTracks; 



	public Song (){
			
	}

	
	//GETTERS AND SETTERS	!!!!
	
	

	public String getSongID() {
		return songID;
	}



	public void setSongID(String songID) {
		this.songID = songID;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}



	public String getCoverImagePath() {
		return coverImagePath;
	}



	public void setCoverImagePath(String coverImagePath) {
		this.coverImagePath = coverImagePath;
	}



	public String getRecordingCompany() {
		return recordingCompany;
	}



	public void setRecordingCompany(String recordingCompany) {
		this.recordingCompany = recordingCompany;
	}



	public int getNumberOfTracks() {
		return numberOfTracks;
	}



	public void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}


	
	
	
	

	
	
	


	


	
	
	

	

	
	
	
}
