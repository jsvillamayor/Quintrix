import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author James Villamayor
 * @version 5/4
 * Homework #2
 * A class that displays all the albums made. It
 * puts user in a loop, where they can choose
 * an album, or until they choose to break out
 * of the loop
 */
public class MusicCollection {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		Song song1 = new Song("Black Skinhead", "Kanye West", "Hip-Hop/Rap");
		Album album1 = new Album("Yeezus", song1, 2);
		Song song2 = new Song("What Do You Mean?", "Justin Bieber");
		Album album2 = new Album("Purpose", song2, 3);
		album2.setGenre("Pop");
		Song song3 = new Song("Honey, I'm Good.", "Andy Grammer", "Country");
		Album album3 = new Album("Magazines Or Novels", song3);
		
		ArrayList<Album> albums = new ArrayList<>();
		albums.add(album1);
		albums.add(album2);
		albums.add(album3);
		boolean loop = true;
		
		while(loop) {
			System.out.println("Music Collection:");
			int j = 0;
			for(Album i : albums) {			
				System.out.println(j + ". " + i.getTitle());
				j++;
			}
			System.out.println("0. Exit");
			System.out.print("Choose an album: ");
			int choice = scanner.nextInt();
			System.out.println();
			
			switch (choice) {
			case 0:
				loop = false;
				break;
			case 1:
				Album.albumOptions(album1);
				break;
			case 2:
				Album.albumOptions(album2);
				break;
			case 3:
				Album.albumOptions(album3);
				break;
			}
		}
	}
	
}
