package streaming;

import java.util.Scanner;

public class Player {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		greeter(); //Begrüßung
		mainMenu(scan); // DA passiert alles
		goodbye();
		scan.close();
	}
	public static boolean createAccount(Scanner scan) { //In der Methode wird gefragt ob er Premium haben will oder nicht --> bool
		System.out.println("Möchtest du für 9.90€ monatlich die Premium-Version abonieren (1 - Ja |2 - Nein): ");
		int paysString = scan.nextInt();
		switch(paysString) {
			case(1): System.out.println("ABBRECHNUNG ERFOLGT AUTOMATISCH");
			return true;
		default:
			System.out.println("Ja Schade dann musst du werbung hören");
			return false;
		}
	
	}
	public static String askName(Scanner scan) { //Namenabfragen
		System.out.println("Gib deinen Namen ein: ");
		scan.nextLine();
		String name = scan.nextLine();
		return name;
	}
	public static void mainMenu(Scanner scan) {
		Account acc;
		
		if(createAccount(scan)) { //Account wird erstellt und mit den Boolean entschieden welcher Typ name wird auch abgefragt 
			acc = new PremiumAccount(askName(scan));
		}else {
			 acc = new StandardAccount(askName(scan));
		}
		while(true) { // MAIN Menü
		System.out.println("-----------------------------------------------------");
		System.out.printf("%s was möchtest du machen?\n", acc.getUsername());
		System.out.println("Deine Möglichkeiten: ");
		System.out.println("-----------------------------------------------------");
		System.out.println("Playlist erstellen --> (1)");
		System.out.println("Song in Playlist einfügen --> (2)");
		System.out.println("Song aus Playlist abspielen --> (3)");
		System.out.println("Account - Info --> (4)");
		if(acc.getPremiumFetures()) { // Aktion nur anzeigen wenn Premium
			System.out.println("Premium Funktionen --> (5)");
		}
		System.out.println("EXIT --> (0)");
		System.out.println("EINGABE----------------------------------------------");
		int choice = scan.nextInt();
		scan.nextLine();
		switch(choice) {
	case 0: 
			return; //Zurück bzw beenden
	case 1: 
		createNewPlaylist(acc, scan);	//Neue Playlist
		break;
	case 2:
		if(acc.getPlaylistCount() != 0) { //song in Playlist einfügen wenn Playlists vorhanden sind
		insertSong(scan, acc);
		}else {
			System.out.println("-----------------------------------------------------");
			System.out.println("Du hast noch keine Playlist erstellt!");
		}
		break;
	case 3: 
		if(acc.getPlaylistCount() != 0) { //Erst zur Methode wenn entschieden ob Playlists vorhanden sind
			listenSong(scan, acc);
			}else {
				System.out.println("-----------------------------------------------------");
				System.out.println("Du hast noch keine Playlist erstellt!");
			}
		break;
	case 4: 
		infoAcc(acc); 
		break;

	case 5:
	    if(acc.getPremiumFetures()) { //Nur wenn man Premium falls Standard user sich vertippen sollte
	        
	    	// Hier casten wir 'acc' zu 'PremiumAccount' lösung durch Gemini (war am verzweifeln) 
	        premiumFetures((PremiumAccount) acc, scan); //Also Methode PremiumFetures wird mit dem gecasteten Objekt und Scanner ausgeführt
	    }
	    break;
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
				
				} while (lenPlaylist < 0); // einfache Abfrage ob Länge > 0 ist 
			
				acc.addPlaylist(new Playlist(playlistName, lenPlaylist)); // Playlist erstellen
	}
	public static void insertSong(Scanner scan, Account acc) { 
	    //Playlist wählen
	    System.out.println("In welche Playlist möchtest du den Song speichern?");
	    acc.printPlaylists();
	    
	    int playlistChoice = scan.nextInt() -1; // -1 weil im Print zu dem Index +1 gezählt wird
	    scan.nextLine();  // Buffer leeren

	    //Überprüfen wegen Plalyist Nummer
	    if (playlistChoice < 0 || playlistChoice >= acc.getPlaylistCount()) { // WENN eingabe kleiner wie 0 oder Zahl zu hoch ist
	        System.out.println("Fehler: Ungültige Playlist-Nummer!");
	        return; // Methode abbrechen wenn falsch
	    }

	    // target definieren also welche Playlist
	    Playlist target = acc.getPlaylitAt(playlistChoice);

	    // Prüfen ob der Platz da ist
	    if (target.getCurrenPos() < target.getPlaylistLen()) {
	        System.out.println("Gib den Songnamen ein: ");
	        String songName = scan.nextLine();
	        
	        System.out.println("Gib den Interpret ein: ");
	        String artistName = scan.nextLine();
	        
	        System.out.println("Was für eine Musikrichtung ist der Song: ");
	        String genreName = scan.nextLine();

	        // Song erstellen und einfügen
	        target.insertSong(new Song(songName, artistName, genreName));
	        System.out.println("Song erfolgreich hinzugefügt!");
	    } else {
	        System.out.println("Deine Playlist ist schon voll!");
	    }
	}
	
	public static void listenSong(Scanner scan, Account acc) {
		System.out.println("In Welcher Playlist möchtest du nach dem Song suchen: ");
		acc.printPlaylists();
		int playlistSelect = scan.nextInt() - 1; //-1 Weil  bei Einem Array 0 die 1. Stelle ist
		Playlist target = acc.getPlaylitAt(playlistSelect);
		System.out.println(target.getName());
		if(target.getSongAt(0) != null) { //Überprüfen ob überhaupt Songs in der Playlist sind 
			System.out.println("Playlist vortlaufend hören (1) | Song mit zufälliger Wiedergabe hören (2) | einzelnen Song aus Playlist spielen (3): ");
			int playChoice = scan.nextInt();
			switch(playChoice) {
				case 1:
					target.playPlaylistStrict(acc);
					break;
				case 2: 
					target.playPlaylistRand(acc);
					break;
				case 3 :
					System.out.println("Diese Songs befinden sich in der Playlist: ");
					target.printPosblSongs();
					scan.nextLine();
					int songChoice = scan.nextInt() -1;
					System.out.println(songChoice);
					target.playSoloSong(acc, songChoice);
					break;
					}
				}else {
					System.out.println("Playlist ist leer");
				}
			}
	public static void infoAcc(Account acc) {
		System.out.println("Daten werden angezeigt: ");
		System.out.printf("Name: %s\n",acc.getUsername());
		System.out.printf("Songs wurden gespielt: %d\n", acc.getSongCount());
		if(acc.getPremiumFetures()) {
			PremiumAccount prem = (PremiumAccount) acc; //Acc auf Premium Casten  weil ich bestimmte Variablen brauche die nur da existieren
			if(prem.getFavSong() != null) {
			System.out.printf("Dein Lieblingssong: %s\n", prem.getFavSong().getTitle());
			System.out.printf("Lieblingssong wurde gespielt: %d\n", prem.getFavSongCount());
			}
		}
		System.out.printf("Audioqualität: %s\n", acc.getplayQual());
		System.out.printf("Freie Anzahl Playlits: %d\n", acc.getMaxPlaylists() - acc.getPlaylistCount());
		System.out.printf("Premium Funktionen: %b\n", acc.getPremiumFetures());
		
		
	} // Methode wenn man Premium Funktionen hat
	public static void premiumFetures(PremiumAccount acc, Scanner scan) {

		boolean status = true;
		while (status) {
		System.out.println("PRREMIUM+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		System.out.printf("Deine Auswahl %s\n",acc.getUsername());
		System.out.println("Lieblingssong makieren --> (1)");
		System.out.println("Lieblingssong spielen --> (2)");
		System.out.println("Audioqualität ändern --> (3)");
		System.out.println("Zurück zum Hauptmenü --> (4)");
		int choice = scan.nextInt();
		
		switch(choice) {
			case 1 :
				markFav(acc, scan);
				break;
			case 2:
				if(acc.getFavSong() != null) { //Nur zu
					acc.playFavSong();
				}else {
					System.out.println("PRREMIUM+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
					System.out.println("Kein Lieblingssong ausgewählt!");
				}
				break;
			case 3:
				changeAudioQuali(scan, acc);
				break;
			case 4:
				status = false;
				break;
			default: 
				System.out.println("Ungültige Eingabe+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
				break;
				
			}
		}
	}
	public static void markFav(PremiumAccount acc, Scanner scan) {
	    // 1. Playlist auswählen
	    System.out.println("In welcher Playlist ist dein Song?");
	    
	    int targetIndex;
	    while (true) {
	      	acc.printPlaylists();
	        System.out.print("Eingabe Playlist Nummer: ");
	        targetIndex = scan.nextInt() - 1;
	        // idnde muss größer Gleich wie 0 sein und kleiner wie Playlist Count also überprüfen ob an dieser Position überhaupt schon gearbeitet wurde
	        if (targetIndex >= 0 && targetIndex < acc.getPlaylistCount()) {
	            break; 
	        }
	        System.out.println("Ungültige Playlist!");
	    }

	    Playlist selectedPlaylist = acc.getPlaylitAt(targetIndex); //ausgewählte Playlist speichern

	    // 2. Song selecten aus Playlist
	    int songIndex;
	    while (true) {
	    	 System.out.println("-----------------------------------------------------");
	 	    selectedPlaylist.printPosblSongs(); // Zeigt alle Songs in der Playlist
	 	    System.out.println("Welchen Song möchtest du als Lieblingssong markieren?");
	        System.out.print("Eingabe Song Nummer: ");
	        songIndex = scan.nextInt() -1;
	        //Song muss existieren--> check mit kleiner gleich 0 und der CurrentPos also wo gerade befüllt werden würde
	        if (songIndex >= 0 && songIndex < selectedPlaylist.getCurrenPos()) {
	            break;
	        }
	        System.out.println("Ungültiger Song!");
	    }
	    // 3. Song setzen
	    Song favorite = selectedPlaylist.getSongAt(songIndex);
	    acc.setfavSong(favorite);
	    System.out.printf("'%s' wurde als Lieblingssong markiert!\n", favorite.getTitle()); 
	}
	
	public static void changeAudioQuali(Scanner scan, PremiumAccount acc) {
		System.out.printf("Deine Song Qualität ist: %s\n",acc.getplayQual());
		System.out.println("Auf was möchtest du sie ändern: ");
		System.out.println("(1) --> Datensparmodus");
		System.out.println("(2) --> Normal");
		System.out.println("(3) --> Lossless 16 Bit/44,1 kHz ALAC" );
		System.out.println("(4) --> Hi-Res Lossless (ALAC bis zu 24 Bit/192 kHz)");
		boolean status = true;
		
		while(status) {
			int choice = scan.nextInt();
			switch (choice) {
			case 1: 
				acc.setPlayQual("Datensparmodus");
				System.out.printf("Audioqualität wurde auf %s\n", acc.getplayQual());
				status = false;
				break;
			case 2: 
				acc.setPlayQual("Normal");
				System.out.printf("Audioqualität wurde auf %s\n", acc.getplayQual());
				status = false;
				break;
			case 3:
				acc.setPlayQual("Lossless 16 Bit/44,1 kHz ALAC");
				System.out.printf("Audioqualität wurde auf %s\n", acc.getplayQual());
				status = false;
				break;
			case 4:
				acc.setPlayQual("Hi-Res Lossless (ALAC bis zu 24 Bit/192 kHz)");
				System.out.printf("Audioqualität wurde auf %s\n", acc.getplayQual());
				status = false;
			default:
				System.out.println("-----------------------------------------------------");
				System.out.println("Ungültige Eingabe!");
				
			}
		}
	
	}
	public static void goodbye() {
		    System.out.println("  _____  ____________  ___  _______ ______");
		    System.out.println(" / _ ) \\/ /_  __/ __/ / _ )/ __/ _ /_  __/");
		    System.out.println("/ _  |\\  / / / / _/  / _  / _// __ |/ /   ");
		    System.out.println("/____/ /_/ /_/ /___/ /____/___/_/ |_/_/    ");
		    System.out.println("                                           ");
		    System.out.println("--------- !Bis zum nächsten mal! ---------");
		    System.out.println("------------------------------------------");
	}
		public static void greeter() {
		    System.out.println("  _____  ____________  ___  _______ ______");
		    System.out.println(" / _ ) \\/ /_  __/ __/ / _ )/ __/ _ /_  __/");
		    System.out.println("/ _  |\\  / / / / _/  / _  / _// __ |/ /   ");
		    System.out.println("/____/ /_/ /_/ /___/ /____/___/_/ |_/_/    ");
		    System.out.println("                                           ");
		    System.out.println("--- WILLKOMMEN BEI BYTEBEAT STREAMING ---");
		    System.out.println("------------------------------------------");
		
	}
}
