import java.sql.SQLException;
public class genre 
{
	private int genreID;
	private String genreName;
	private String description;
	
	public genre(int genreID)
	{
		this.genreID = genreID;
		DbUtilities db = new DbUtilities();

	    String sql = "SELECT genre_name, description from genre WHERE genre_id = " + this.genreID + ";";
	    ResultSet rs = db.getResultSet(sql);
	}
	
	public genre(String genreName, String description)
	{
		DbUtilities db = new DbUtilities();
		this.genreName = genreName;
		this.description = description;
		
		String sql = "INSERT INTO genre (genre_name, description) VALUES ('" + genreName + "' , '" + description + ";";
		db.executeQuery(sql);
	}
	
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		DbUtilities db = new DbUtilities();
		String sql = "UPDATE genre SET genre_name = '" + genreName + "'WHERE genre_id = " + this.genreID + ";";
		this.genreName = genreName;
		db.executeQuery(sql);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGenreID() {
		return genreID;
	}
}
