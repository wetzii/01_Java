package atm;

import java.util.Scanner;


public class UI {
	
	static ATM[] atms = new ATM[10];
	static Saboteur sab = new Saboteur();
	static Scanner scan = new Scanner(System.in);
	static BankAccount konto;
	
	
	public static void main(String[] args) {
			printLogo("Herzlich Willkomen bei:-----------------------------");
			// Try Cath sollt ehier dann für alles mögliche her
			setupNormal();
	}
//===========================================================
//Create Metoden
//===========================================================

	//----------> Create für ATm's
	public static void createAtms() {
		 atms[0] = new ATM("ATM1", "Mürzzuschlag Hauptplatz",   "SN-001", sab);
	     atms[1] = new ATM("ATM2", "Kindberg Marktplatz",        "SN-002", sab);
	     atms[2] = new ATM("ATM3", "Krieglach Bahnhofstraße",    "SN-003", sab);
	     atms[3] = new ATM("ATM4", "Stanz im Mürztal Dorfplatz", "SN-004", sab);
	     atms[4] = new ATM("ATM5", "Kapfenberg Stadtplatz",      "SN-005", sab);
	     atms[5] = new ATM("ATM6", "Miniwalk Spielberg",       "SN-006", sab);
	     atms[6] = new ATM("ATM7", "Knittelfeld Grazer Straße",  "SN-007", sab);
	     atms[7] = new ATM("ATM8", "Zeltweg Bahnhofplatz",       "SN-008", sab);
	     atms[8] = new ATM("ATM9", "Gaal Bachweg 5a",   "SN-009", sab);
	     atms[9] = new ATM("ATM10","Leoben Hauptplatz",          "SN-010", sab);
		}
	//----------> Create für UserAccount
	public static void createAccount() throws InputTypeMissmatch {
        System.out.println("======= Konto erstellen =======");
        System.out.print("Name: ");
        String name = scanString();   
        System.out.print("PIN (4 Ziffern): ");
        int pin = scanInt();
        System.out.print("Startguthaben: ");
        double saldo = scanDouble();
        konto = new BankAccount(name, pin, saldo);
        System.out.println("Willkommen bei der ByteBank, " + konto.getCustomerName() + "!\n");
    }
	//Setup den er am Start machen soll wie zum beispiel 10 Atms erstellen und auf den Array zuweisen und 1 User
	public static void setupNormal()  throws InputTypeMissmatch{
		createAtms();
		createAccount();
	}
//===========================================================
//Scanner Methoden
//===========================================================

//Lege jeden Scanner inkl Fehler abfrage einmal an kann diese dann immer benutzen 
	
	//--------------> Double Scanner
	public static double scanDouble() throws InputTypeMissmatch{ //Einmal ein Scanner für double mit Fehler abfrage
		
	    System.out.print("Deine Eingabe: ");
	    try {
	        double choice = scan.nextDouble();
	        scan.nextLine();
	       
	        return choice;
	    } catch (Exception e) {
	        scan.nextLine();
	        throw new InputTypeMissmatch("Bitte gib eine Valide Zahl ein");
	    }
	}
	
	//--------------> Integer Scanner
	public static int scanInt() throws InputTypeMissmatch{ //Einmal ein Scanner für int mit Fehler abfrage
		
	    System.out.print("Deine Eingabe: ");
	    try {
	        int choice = scan.nextInt();
	        scan.nextLine();
	       
	        return choice;
	    } catch (Exception e) {
	        scan.nextLine();
	        throw new InputTypeMissmatch("Bitte gib eine Valide Zahl ein");
	    }
	}
	
	//--------------> String Scanner
	 public static String scanString() throws InputTypeMissmatch {
	        System.out.print("Deine Eingabe: ");
	        try {
	            String choice = scan.nextLine().trim();
	            if (choice.isEmpty()) throw new InputTypeMissmatch("Eingabe darf nicht leer sein!");
	            return choice;
	        } catch (Exception e) {
	            throw new InputTypeMissmatch("Ungültige Eingabe!");
	        }
	    }
//================================
//Print Functions
//================================
	 public static void printMenuTransaction() {
		 System.out.println("Deine Auswahl: ");
		 System.out.println("(1) ----> Geld abheben");
		 System.out.println("(2) ----> Geld einzahlen");
		 System.out.println("(3) ----> Kontostand prüfen");
	 }
	 public static void  printAllAtms() {
		 
	 }

//============================
// --------Logo
//===========================
	 public static void printLogo(String text) {
		 System.out.println(" .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .-----------------. .----------------. \r\n"
		 		+ "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\r\n"
		 		+ "| |   ______     | || |  ____  ____  | || |  _________   | || |  _________   | || |   ______     | || |      __      | || | ____  _____  | || |  ___  ____   | |\r\n"
		 		+ "| |  |_   _ \\    | || | |_  _||_  _| | || | |  _   _  |  | || | |_   ___  |  | || |  |_   _ \\    | || |     /  \\     | || ||_   \\|_   _| | || | |_  ||_  _|  | |\r\n"
		 		+ "| |    | |_) |   | || |   \\ \\  / /   | || | |_/ | | \\_|  | || |   | |_  \\_|  | || |    | |_) |   | || |    / /\\ \\    | || |  |   \\ | |   | || |   | |_/ /    | |\r\n"
		 		+ "| |    |  __'.   | || |    \\ \\/ /    | || |     | |      | || |   |  _|  _   | || |    |  __'.   | || |   / ____ \\   | || |  | |\\ \\| |   | || |   |  __'.    | |\r\n"
		 		+ "| |   _| |__) |  | || |    _|  |_    | || |    _| |_     | || |  _| |___/ |  | || |   _| |__) |  | || | _/ /    \\ \\_ | || | _| |_\\   |_  | || |  _| |  \\ \\_  | |\r\n"
		 		+ "| |  |_______/   | || |   |______|   | || |   |_____|    | || | |_________|  | || |  |_______/   | || ||____|  |____|| || ||_____|\\____| | || | |____||____| | |\r\n"
		 		+ "| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |\r\n"
		 		+ "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\r\n");
System.out.println(text);
	 }
}
