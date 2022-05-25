import java.util.Scanner;

/**
 * 
 * @author James Villamayor
 * @version 5/4
 * Homework #2
 * A class Album that represents an album in a 
 * music collection. Every album will have a 
 * favorite track inside of it.
 * 
 */
public class Album {

	private String title;
	private String artist;
	private String genre;
	private Song favoriteTrack;
	private int trackNumber;
	private static int numAlbums = 0;
	
	/**
	 * Main constructor for Album class
	 * @param title - name of album
	 * @param favoriteTrack 
	 * @param trackNumber - No. the track is on album
	 */
	public Album(String title, Song favoriteTrack, int trackNumber) {
		this.title = title;
		this.favoriteTrack = favoriteTrack;
		this.trackNumber = trackNumber;
		this.artist = favoriteTrack.getArtist();
		this.genre = favoriteTrack.getGenre();
		numAlbums++;
	}
	
	/**
	 * Constructor chain for Song, where Track No.
	 * is not know, so it is defaulted to 1
	 * @param title
	 * @param favoriteTrack
	 */
	public Album(String title, Song favoriteTrack) {
		this(title, favoriteTrack, 1);
	}
	
	public String getTitle() {
		return title;
	}
	public Song getFavoriteTrack() {
		return favoriteTrack;
	}
	public int getTrackNumber() {
		return trackNumber;
	}
	public int getNumAlbums() {
		return numAlbums;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
		this.favoriteTrack.setGenre(genre);
	}
	
	@Override
	public String toString() {
		return "'" + title + "' - " + artist + "   Genre: " + genre;
	}
	
	/**
	 * user is put into a loop where they have the option
	 * to get the Favorite track on album, change the
	 * genre of the album, or return back to main loop
	 * @param album
	 */
	public static void albumOptions(Album album) {
		boolean loop = true;
		while(loop) {
			System.out.println(album.toString());
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Get Favorite Track");
			System.out.println("2. Change Genre");
			System.out.println("3. Return");
			System.out.print("Make a choice: ");
			int choice = scanner.nextInt();
			
			 
			switch (choice) {
			case 1:
				System.out.println("Track No. " + album.getTrackNumber() + ": " + album.favoriteTrack.toString());
				System.out.println();
				break;
			case 2:
				System.out.print("New Genre: ");
				String newGenre = scanner.next();
				album.setGenre(newGenre);
				System.out.println();
				break;
			case 3:
				loop = false;
				System.out.println();
				break;
			}
		}
		
	}
	
}
