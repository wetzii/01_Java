package casino;

import java.util.Scanner;

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
	System.out.println("  _  __                 _  ___         _      __  \n"
			+ " | |/ /___ _ _ _ _  ___| |/ __|__ _ __(_)_ _ /  \\ \n"
			+ " | ' </ -_) '_| ' \\/ -_) | (__/ _` (_-< | ' \\ () |\n"
			+ " |_|\\_\\___|_| |_||_\\___|_|\\___\\__,_/__/_|_||_\\__/ \n"
			+ "                                                  ");
	}
	public static void main(String[] args) {
		printLogo();
		Scanner scan = new Scanner(System.in);
		Player player = createPlayer(scan);
		Croupier croupier = createCroupier();
	}
	public static Player createPlayer(Scanner scan) {
	System.out.println("Gib deinen Namen ein: ");
	Player player = new Player(scan.nextLine());
	return player;
	}
	public static Croupier createCroupier() {
		Croupier croupier = new Croupier("Nino");
		return croupier;
	}
	public void mainMenu(Scanner scan, Player player, Croupier croupier) {
		System.out.println("-----------------Hauptmenu-----------------");
		System.out.println("(1) --> Spiele Roulette");
		System.out.println("(2)--> Spiele Slotmachine");
		System.out.println("(3)--> Infos");
		System.out.println("(0) --> Exit");
		int choice = scan.nextInt();
		
		switch (choice) {
		case 0: 
			return;
			
		case 1: 
			//Roulette
			break;
		case 2:
			//Slotmaschine
			break;
		case 3: 
			//Neue Methode im Plyer Damkit Kontostand und gespielte SPiele Ausgegeben wird Maybe +- Rechnung
			break;
			
		default:
			System.out.println("Ungültige Eingabe!!!!");
			break;
		}
	}
}
