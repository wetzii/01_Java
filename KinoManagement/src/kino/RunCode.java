package kino;

import java.util.ArrayList;
import java.util.Scanner;

public class RunCode {
	public static ArrayList<Hall> halls = new ArrayList<Hall>();  
	public static Scanner scan = new Scanner(System.in);
	static Cinema cinema = new Cinema("Dieselkino", "Kapfenberg");
	
	
	public static void main(String[] args) {
		printMenu();
		printLogo("Wilkommen");
		
	}
	//_________------------_______________------------________
	//++++++++++           Create Methoden               ++++++++
	//_________------------_______________------------________
	
	public static void setupHall() {
		cinema.getAvailableHalls().add(new Hall(1, "Halle 1", 50, cinema));
		cinema.getAvailableHalls().add(new Hall(2, "Halle 2", 59, cinema));
		cinema.getAvailableHalls().add(new Hall(3, "Halle 3", 52, cinema));
	}

	//_________------------_______________------------________
	//++++++++++           Logik Methoden               ++++++++
	//_________------------_______________------------________
	public static void showAllHall() {
		
	}
	//_________------------_______________------------________
	//++++++++++           Print Methoden               ++++++++
	//_________------------_______________------------________
	public static void printMenu() {
		System.out.println("01 -- Alle Säle anzeigen");
		System.out.println("02 -- Film zum Repertoire hinzugügen");
		System.out.println("03 -- Film einem Saal zuweisen");
		System.out.println("04 -- Film aus einem Saal entfernen");
		System.out.println("05 -- Programm eines Saals anzeigen (sortiert nach FSK)");
		System.out.println("06 -- Kunde registriere");
		System.out.println("07 -- Alle Säle anzeigen");
		System.out.println("08 -- Einlass — Kunde betritt Saal");
		System.out.println("09 -- Vorstellung beenden (Saal räumen)");
		System.out.println("10 -- Saal zufällig in Renovierung schicken");
		System.out.println("11 -- 1 - Zufälligen Renovierungssaal freigeben");
		System.out.println("00 -- BEEENDEN");
		
	}
	private static void printLogo(String text) {
		System.out.println("  ______   _______ _____ ____ ___ _   _ _____ __  __    _    \r\n"
				+ " | __ ) \\ / /_   _| ____/ ___|_ _| \\ | | ____|  \\/  |  / \\   \r\n"
				+ " |  _ \\\\ V /  | | |  _|| |    | ||  \\| |  _| | |\\/| | / _ \\  \r\n"
				+ " | |_) || |   | | | |__| |___ | || |\\  | |___| |  | |/ ___ \\ \r\n"
				+ " |____/ |_|   |_| |_____\\____|___|_| \\_|_____|_|  |_/_/   \\_\\\r\n"
				+ "                                                             ");
		System.out.println("---------------" + text + "---------------");

	}
	public static void printLine() {
		System.out.println("---------------------------------------------------------------");
	}
}
