package casino;

import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class Casino {
/*Casino implementiert den kompletten Casino-Aufenthalt. Zuerst wird der Spieler
nach seinem Namen gefragt und mit wievielen Credits er spielt (Credits müssen
mindestens 30 sein). Anschließend werden vom Spieler und vom Croupier die per-
formRole() ausgegeben. Die unterschiedlichn Spiele, die es im Casino gibt, werden
in einem Array gespeichert. Der Nutzer hat die Möglichkeit aus 4 verschiedenen
Menü-Punkten zu wählen (Slot Maschine, Roulette, Credits anzeigen, Exit). Wird die
Slot-Maschine oder Roulette ausgewählt, so setzt der Player zuerst seinen Einsatz
bevor die jeweiligen Aktionen ausgeführt werden. Wenn der Player einen ungültigen
Einsatz setzt (siehe Methode in Player), dann soll er nochmal den Einsatz setzten
können*/
	public static void printLogo() {
	System.out.println(""
			+ "________        _____     _________________________\r\n"
			+ "___  __ )____  ___  /________  __ )__  ____/__  __/\r\n"
			+ "__  __  |_  / / /  __/  _ \\_  __  |_  __/  __  /   \r\n"
			+ "_  /_/ /_  /_/ // /_ /  __/  /_/ /_  /___  _  /    \r\n"
			+ "/_____/ _\\__, / \\__/ \\___//_____/ /_____/  /_/     \r\n"
			+ "        /____/                                     ");
	}
	public static void greeter() {
		System.out.println("|||||||||||||||||||Wikkommen bei||||||||||||||||||||");
		printLogo();
		System.out.println("----------------------------------------------------");
		
	}
	public static void main(String[] args) {
		greeter();
		Scanner scan = new Scanner(System.in);
		Player player = createPlayer(scan);
		Croupier croupier = createCroupier();
		mainMenu(scan, player, croupier, createRoulette(), createSlotMaschine());
		
	}
	public static Player createPlayer(Scanner scan) {
	System.out.println("Gib deinen Namen ein: ");
	String nameString = scan.nextLine();
	int startCredits = 0;
	while(startCredits < 1) {
		System.out.println("Wie viele Credits möchtest du  Kaufen 1€ --> 10 Credits");
		startCredits = scan.nextInt();
		scan.nextLine();
		}
	System.out.printf("Das Kostet %.2f€\n", (float)startCredits/10 );
	Player player = new Player(nameString,startCredits);
	return player;
	}
	
	public static Croupier createCroupier() {
		Croupier croupier = new Croupier("Nino");
		return croupier;
	}
	public static Roulette createRoulette() {
		return new Roulette();
	}
	public static SlotMaschine createSlotMaschine() {
		return new SlotMaschine();
	}
	public static void mainMenu(Scanner scan, Player player, Croupier croupier, Roulette roulette, SlotMaschine slotMaschine) {
			while(true) {
			System.out.println("-----------------Hauptmenu-----------------");
			System.out.println("(1) --> Spiele Roulette");
			System.out.println("(2)--> Spiele Slotmachine");
			System.out.println("(3)--> Infos");
			System.out.println("(4)--> Credits Kaufen"); 
			System.out.println("(5)--> Credits zu Geld umwandeln"); // Muss noch gemacht werden
			System.out.println("(0) --> Exit");
			System.out.println("------------------Eingabe------------------");
			int choice = scan.nextInt();
		
			switch (choice) {
			case 0: 
				return;
				
			case 1: 
				System.out.println("------------------Roulette------------------");
				roulette.playRound(player, croupier, placeBet(player, scan));				
				
				break;
			case 2:
				System.out.println("---------------Slot-Maschine----------------");
				slotMaschine.playRound(player, croupier, placeBet(player, scan));	
				break;
			case 3: 
				System.out.println("---------------Credits-Kaufen---------------");
				System.out.println("Wie viele Credits möchtest du  Kaufen 1€ --> 10 Credits");
				int add = scan.nextInt();
				player.addCredits(add);
				break;
				
			default:
				System.out.println("Ungültige Eingabe!!!!");
			}	
		}
	}
	public static int placeBet(Player player, Scanner scan) {
		int place;
		do {
			System.out.println("Wie hoch ist dein Einsatz?");
			System.out.printf("Dein Kontostand: %d |möglicher Einsatz: %d\n", player.getCredits(), player.getCredits()/2);
			System.out.println("Wie viel möchtest du setzten: ");
			place = scan.nextInt();
		}while (!player.placeCredits(place));
		return place;
	}
}
