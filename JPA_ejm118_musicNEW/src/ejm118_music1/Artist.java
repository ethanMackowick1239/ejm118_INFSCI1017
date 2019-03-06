package ejm118_music1;

import javax.persistence.*;


@Entity
@Table (name = "artist")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column (name = "artist_id")
	private String artistID;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "band_name")
	private String bandName;
	
	@Column(name = "bio")
	private String bio; 	

	public Artist()
	{
		
	}
	
	
	
	//GETTERS AND SETTERS	!!!!
	
	public void setArtistID(String artistID) {
		this.artistID = artistID;
	}

	
	//returns first name
	public String getFirstName() {
		return firstName;
	}
	//sets first name in db and locally using artistIF
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;	
	}
	//returns last name
	public String getLastName() {
		return lastName;
	}
	//sets last name locally and in db using artistID
	public void setLastName(String lastName) {
		this.lastName = lastName;	
		}
	
	//returns bandname
	public String getBandName() {
		return bandName;
	}
	//sets band name in db and locally using artistID
	public void setBandName(String bandName) {
		this.bandName = bandName;	
		}
	//returns bio
	public String getBio() {
		return bio;
	}

	//sets bio locally and in db using artistID
	public void setBio(String bio) {
		this.bio = bio;	
	}
	//returns artistID
	public String getArtistID() {
		return artistID;
	}
	
	
	
	
	
	
}
