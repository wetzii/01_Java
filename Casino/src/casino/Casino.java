package casino;

import java.util.Scanner;


public class Casino {

	public static void main(String[] args) {
		greeter();
		Scanner scan = new Scanner(System.in);
		Player player = createPlayer(scan);
		Croupier croupier = createCroupier();
		Playable[] games = {createSlotMaschine(), createRoulette()};
		mainMenu(scan, player, croupier, games);
		goodbye();
		
	}
	
	public static Player createPlayer(Scanner scan) { //Spieler erstellen
		boolean status = false;
		String nameString = null;
		int startCredits = -1;
		
		while(!status){
	System.out.println("Gib deinen Namen ein: ");
	 nameString = scan.nextLine();
	 try {
		 
	while(startCredits < 30) {
		if(startCredits < 30) {
			System.out.println("Du musst mehr wie 30 aufladen!");
		}
		System.out.println("Wie viele Credits möchtest du  Kaufen 1€ --> 10 Credits");
		startCredits = scan.nextInt();
		scan.nextLine();
		}
	
	System.out.printf("Das Kostet %.2f€\n", (float)startCredits/10 ); // EInfache Umrechunng wie viele € wie viele Tokens sind
		
	Player player = new Player(nameString,startCredits); //Objekt wird erstellt
	return player;
		} catch (Exception e) {
	 System.err.println("Gib bitte eine Zahl ein!");
			}
		}
		return null;
	}
	
	public static Croupier createCroupier() {
		Croupier croupier = new Croupier("Nino"); //Ganz einfach Objekt erstellen
		return croupier;
	}
	public static Roulette createRoulette() {//Muss erstellt werden sonst keinen Zugriff
		return new Roulette(); 
	}
	public static SlotMaschine createSlotMaschine() { //Muss erstellt werden sonst keinen Zugriff
		return new SlotMaschine();
	}
	public static void mainMenu(Scanner scan, Player player, Croupier croupier, Playable[] games) {
			while(true) {
				boolean status = false;
				int choice = -1;
				while(!status) {
			try { 
			System.out.println("-----------------Hauptmenu-----------------");
			System.out.println("(1--> Spiele Roulette");
			System.out.println("(2)--> Spiele Slotmachine");
			System.out.println("(3)--> Credits Kaufen"); 
			System.out.println("(4)--> Credits anzeigen)");
			System.out.println("(0) --> Exit");
			System.out.println("------------------Eingabe------------------");
			
		     	choice = scan.nextInt();	
		     	if(choice > 5 || choice < 0) {
		     		status = true;
				}
			}catch (Exception e) {
				System.err.println("Bitte gib eine Zahl ein!");
				scan.nextLine();
			}
			
			
				}
		   int place;
			switch (choice) {
			case 0: 
				return;
				
			case 1: 
				System.out.println("------------------Roulette------------------");
				place =	placeBet(player, scan);
				games[1].playRound(player, croupier,place);				
				
				break;
			case 2:
				System.out.println("---------------Slot-Maschine----------------");
				place =	placeBet(player, scan);
				games[0].playRound(player, croupier, place);	
				break;
			case 3: 
			addCredits(scan, player);
				break;
			case 4:
				System.out.println("Deine Creditsstand: "+player.getCredits());
				break;
				
			default:
				System.err.println("Ungültige Eingabe!!!!");
			}	
		}
	}
	public static int placeBet(Player player, Scanner scan) {
		boolean status = false;
		
		int place = -1;
		while(!status) {
			
		do {
			try {
			System.out.println("Wie hoch ist dein Einsatz?");
			System.out.printf("Dein Kontostand: %d |möglicher Einsatz: %d\n", player.getCredits(), player.getCredits()/2);
			System.out.println("Wie viel möchtest du setzten: ");
			place = scan.nextInt();
			}catch(Exception e) {
				System.err.println("Gib eine Zahl ein!");
				scan.nextLine();
			}
		}while (!player.placeCredits(place));
		return place;
		}
		return -1;
	}
	public static void goodbye() {
		printLogo();
		System.out.println("-------------------TSCHAU-------------------");
	}
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
	public static void addCredits(Scanner scan, Player player) {
		boolean status = false;
		int add = -1;
		while (!status) {
		try {
		System.out.println("---------------Credits-Kaufen---------------");
		System.out.println("Wie viele Credits möchtest du  Kaufen 1€ --> 10 Credits");
		add = scan.nextInt();
		if(add > 0) {
			status = true;
		}else {
			System.out.println("Gib mehr wie 0 ein!");
		}
		} catch (Exception e) {
			System.err.println("Gib eine Zahl ein!");
		}
		player.addCredits(add);
		scan.nextLine();
		}
	}
}
