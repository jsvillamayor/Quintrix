
/**
 * 
 * @author James Villamayor
 * @version 5/4
 * Homework #2
 * A class 'Song' where we have constructor chaining,
 * setters, getters, and a toString Override function
 *
 */

public class Song {
	
	private String title;
	private String artist;
	private String genre;
	
	/**
	 * Primary constructor
	 * @param title - title of song
	 * @param artist - artist of song
	 * @param genre - genre of song
	 */
	public Song(String title, String artist, String genre) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
	}
	
	/**
	 * Constructor chain where if there is
	 * no genre, we set it as unknown
	 * @param title
	 * @param artist
	 */
	public Song(String title, String artist) {
		this(title, artist, "unknown");
	}
	
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public String getGenre() {
		return genre;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return artist + " - " + title + "   Genre: " + genre;
	}
	
}
