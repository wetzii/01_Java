package mediathek;

import java.util.Scanner;

public class Mediathek {
	public static void main(String[] args) {
		DigitalMedia[] digitalMedia =  createFilmGames();
		Newsletter[] news = createNews();
		
	}
	public static DigitalMedia[] createFilmGames() {
		DigitalMedia[] digitalMedia = new DigitalMedia[5];
		
		digitalMedia[0] = new Film("Inception", "SciFi", 148, "Ein Dieb dringt in Traeume ein.");
        digitalMedia[1] = new Film("Interstellar", "SciFi", 169, "Astronauten reisen durch ein Wurmloch.");
        digitalMedia[2] = new Game("Zelda - Breath of the Wild", "Adventure", 3000, new String[]{"Nintendo Switch"});
        digitalMedia[3] = new Game("Elden Ring", "RPG", 3600, new String[]{"PC", "PS5"});
        digitalMedia[4] = new Film("The Dark Knight", "Action", 152, "Batman kaempft gegen den Joker.");
        return digitalMedia;
	}
	public static Newsletter[] createNews() {
		
		Newsletter[] newsletters = new Newsletter[3];
		newsletters[0] = new Newsletter("Tech Weekly", "Neue KI-Trends auf dem Vormarsch.", 1);
        newsletters[1] = new Newsletter("Gaming News", "Release des neuen Blockbusters steht bevor.", 2);
        newsletters[2] = new Newsletter("Science Journal", "Durchbruch in der Quantenphysik.", 3);
        return newsletters;
	}
	public static void printAllMedien(DigitalMedia[] digitalMedias, Newsletter[] news) {
		
		for(int i = 0; i < digitalMedias.length; i++) {
			if(digitalMedias[i] != null) {
			System.out.printf("(%d) --> %s\n", digitalMedias[i].getTitle());
			}
		}
		for (int idx = 0; idx < news.length; idx++) {
			if(news[idx] != null) {
				System.out.printf("(d)--> %s\n", news[idx].getTitle());
	
				}
			}
	}
	public static void printMenu() {
		System.out.println("-------------Deine-Auswahl-------------");
		System.out.println("(1) -- Digitale Medien Auswahl");
		System.out.println("(2) -- Auswahl für Bücher");
		System.out.println("(3) -- Gesamte Inhalte ausgeben");
	}
	public static void doFilmGames(int activityCh) { // Hier Kommen noch unter Methoden
		System.out.println("dd");
	
	}
	public static void rate(DigitalMedia media, Scanner scan) {
		System.out.printf("Wie möchtest du den Film %s von 0-5 bewerten\n", media.getTitle());
		int rating = 0;
		try {
			rating = scan.nextInt();
		}
			catch (Exception e) {
				System.err.println("Versuche es nochmal wo möglich falscher Datentyp");
			}
		media.rate(rating);
		System.out.println("Bewertung wurde hinzugefügt");
		
	}
}
