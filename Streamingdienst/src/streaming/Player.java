package streaming;

import java.util.Scanner;




public class Player {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		mainMenu(scan);
	}
	public static boolean createAccount(Scanner scan) {
		System.out.println("Möchtest du für 9.23€ monatlich die Premium-Version abonieren (1 - Ja |2 - Nein): ");
		int paysString = scan.nextInt();
		switch(paysString) {
			case(1): System.out.println("Top Wen du nicht bezahlst beschlagnamen wir dein Haus");
			return true;
		default:
			System.out.println("Ja Schade dann musst du werbung hören");
			return false;
		}
	
	}
	public static String askName(Scanner scan) {
		System.out.println("Gib deinen Namen ein: ");
		String name = scan.nextLine();
		return name;
	}
	public static void mainMenu(Scanner scan) {
		Account acc;
		
		if(createAccount(scan)) {
			acc = new PremiumAccount(askName(scan));
		}else {
			 acc = new StandardAccount(askName(scan));
		}
		while(true) {
			
		System.out.println("Was möchtest du machen");
		System.out.println("Deine Möglichkeiten: ");
		System.out.println("Playlist erstellen --> (1)");
		System.out.println("Song in Playlist einfügen --> (2)");
		System.out.println("Song aus Playlist abspielen --> (3)");
		
		int choice = scan.nextInt();
		scan.nextLine();
		switch(choice) {
	
	case 1: 
		createNewPlaylist(acc, scan);	
		break;
	case 2:
		System.out.println("Gib den Song namen ein: ");
		String songName = scan.nextLine();
		System.out.println("Gib den Interpret ein: ");
		String artistName = scan.nextLine();
		System.out.println("Was für eine Musik Richtung ist der Song: ");
		String genreName = scan.nextLine(); 
		System.out.println("In welche Playlist möchtest du den Song speichern: ");
		acc.printPlaylists();
		int playlistChoice = scan.nextInt();
		scan.nextLine();
		//Also du mmusst die Array Postion Nutzen  und dann auf addSong einfügen kiene Ahnung ob es die schon gibt
		//song Objekt sollte normalerweise in den Array direkt 
		//Normalerweise geht Debugen kann nicht debuggen
		acc.getPlaylitAt(playlistChoice).insertSong(new Song(songName, artistName,genreName ));
		break;
		//Case 3 wird dazu da sein den Song zu spielen
	case 3: 
		System.out.println("In Welcher Playlist möchtest du nach dem Song suchen: ");
		acc.printPlaylists();
		int playlistSelect = scan.nextInt();
		Playlist target = acc.getPlaylitAt(playlistSelect);
		
		System.out.println("Playlist vortlaufend hören (1) | Song mit zufälliger Wiedergabe hören (2) | einzelnen Song aus Playlist spielen (3): ");
		int playChoice = scan.nextInt();
		switch(playChoice) {
			case 1:
				target.playPlaylistStrict();
				break;
			case 2: 
				target.playPlaylistRand(acc);
				break;
			case 3 :
				System.out.println("Diese Songs befinden sich in der Playlist: ");
				target.printPosblSongs();
				int songChoice = scan.nextInt();
				acc.playSong(playlistSelect, songChoice);
				
				}
			}
		}
	}
	public static void createNewPlaylist(Account acc, Scanner scan) {
			int lenPlaylist = 0;
		//Maybe noch If einfügen die Chekct ob noch Platz ist
			System.out.printf("Du hast noch %d freie Playlist Plätze\n", acc.getMaxPlaylists() - acc.getPlaylistCount());
			System.out.println("Name der Playlist: ");
			String playlistName = scan.nextLine();
			
			
			do {
					
				System.out.println("Wie lange sollte deine Playlist sein: ");
				lenPlaylist = scan.nextInt();
				
				} while (lenPlaylist < 0);
				acc.addPlaylist(new Playlist(playlistName, lenPlaylist), playlistName);
				
				
	}
}

