package atm_wetzlhuetter;


import java.util.Scanner;


public class UI {
	
	static ATM[] atms = new ATM[10];
	static Saboteur sab = new Saboteur();
	static Scanner scan = new Scanner(System.in);
	static BankAccount konto;
	
	
	public static void main(String[] args) {
	    printLogo("-----------------------------Herzlich Willkomen bei:");
	    try {
	        setupNormal(); 
	    } catch (InputTypeMissmatch e) {
	        System.out.println("Eingabefehler: " + e.getMessage());
	    } catch (InvalidPinTypeException e) {
	        System.out.println("Pin-Format Fehler: " + e.getMessage());
	    }
	    runMainLogic(); // Main Logic benötigt eigenes Try Catch sonst wäre schleife nicht möglich 
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
	public static void createAccount() throws InvalidPinTypeException {
	    while (true) {
	        try {
	            System.out.println("======= Konto erstellen =======");
	            System.out.println("Name");
	            String name = scanString();
	            System.out.println("----------------------------");
	            System.out.println("Startguthaben");
	            double saldo = scanDouble();
	            konto = new BankAccount(name, saldo);
	            System.out.println("----------------------------");
	            System.out.print("PIN (4 Ziffern): ");
	            konto.createPin(scanInt());
	            System.out.println("Willkommen bei der ByteBank, " + konto.getCustomerName() + "!\n");
	            break; //Wenn es passt zurück zu main --> In diesem Fall einfacher mit break auch wenn wir es nicht benützen sollten
	        } catch (InputTypeMissmatch e) {
	            System.out.println("Fehler: " + e.getMessage() + " Bitte nochmal von vorne!");
	        }
	    }
	}
	//Setup den er am Start machen soll wie zum beispiel 10 Atms erstellen und auf den Array zuweisen und 1 User
	public static void setupNormal()  throws InputTypeMissmatch, InvalidPinTypeException{
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
	//--------------> Scanner für Wahlen mit Fehler überprüfung
	 public static int scanChoice(int min, int max) throws InputTypeMissmatch{ //Nehme in diesem Fall While schleife für den Bereich das macht alles ein wenig einfacher und man wird nicht immer zurückgeworfen
		 int num;
		 do {
			num = scanInt();
		} while (num < min || num > max);
		 return num;
	 }
//================================
//Print Functions
//================================
	 public static void printMenuTransaction() {
		 System.out.println("=========================================");
		 System.out.println("Deine Auswahl: ");
		 System.out.println("(1) ----> Geld abheben");
		 System.out.println("(2) ----> Geld einzahlen");
		 System.out.println("(3) ----> Kontostand prüfen");
	 }
	 //---------------> Alle ATMs inkl Status ausgeben 
	 public static void  printAllAtms() {
		 System.out.println("=========================================");
		 for( int i = 0; i < atms.length; i++  ) {
			 System.out.printf("(%d) --> %s\n",i+1, atms[i].getLocation());
			 System.out.printf("Verfügbar: %s\n", atms[i].getStatus());
			 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		 }
			 
	 }
	
	 public static void printSabotage() {
		 System.out.println("=========================================");
		    System.out.println("Ihr gewünschter ATM wurde kürzlich gesprengt, bitte benützen Sie einen anderen!");
		    System.out.println("\nFunktionierende Bankomaten:");
		    for (int i = 0; i < atms.length; i++) {
		        if (atms[i].getStatus())
		            System.out.printf("(%d) --> %s%n", i+1, atms[i].getLocation());
		    }
		    System.out.println("========================================");
		}
	 
	 public static void printMainMenu() {
		 System.out.println("Deine Auswahl: ");
		 System.out.println("(1) --> Transaktionen");
		 System.out.println("(2) --> Statistiken ausgeben");
		 System.out.println("(0) --> Programm beenden");
		 System.out.println("--------------------------------");
	 }
//===================================
// Logische Methoden 
//==================================
	//------------> Abbuchen von Konto
	 public static void handleDraw(ATM atm, BankAccount acc) throws InvalidDrawAmount, InputTypeMissmatch{
		 System.out.println("=========================================");
		 System.out.println("Geben sie den Betrag ein den sie abheben möchten");
		 double n = scanDouble();
		 atm.drawMoney(acc, n);
		 System.out.printf("Der Betrag %.2f wurde Erfolgreich abgehoben! Dein neuer Saldo: %.2f €%n", n, acc.getSaldo());
		 
	 }
	 //------------------> Einzahlen 
	 public static void handleDeposit(ATM atm, BankAccount acc) throws InvalidDrawAmount, InputTypeMissmatch{
		 System.out.println("=========================================");
		 System.out.println("Geben sie den Betrag ein den sie einzahlen möchten");
		 double n = scanDouble();
		 atm.depositMoney(acc, n);
		 System.out.printf("Der Betrag %.2f wurde Erfolgreich eingezahlt! Dein neuer Saldo: %.2f €%n", n, acc.getSaldo());
	 }
	 //----------------> Pin eingabe
	 public static void handlePin(BankAccount acc,ATM atm) throws InvalidPinException, InputTypeMissmatch{
		 System.out.println("=========================================");
		 System.out.println("Gib deinen Pin ein: ");
		 int pin = scanInt();
		 if (!atm.checkPin(acc, pin))
			    throw new InvalidPinException("Falscher PIN!");
		 
		 System.out.println("Pin war erfolgreich");
	 }
	 //------------------> Infos von spezifeschen ATM
	 public static void getInfoAtm(ATM atm) {
		 atm.getInfo();
	 }
	 //-----> Statistiken
	 public static void giveGlobalInfos() {
		 System.out.println("");
		 System.out.println("=========================================");
		 System.out.println("Statistiken der ByteBank");
		 System.out.println("Insgesamt erstelle Konten: "+BankAccount.getAccountCount() ); 
		 System.out.println("Anzahl der Transaktionen: "+ATM.getTransactionCount());
		 System.out.println("=========================================");
	 }
//=============================
//  Methoden für Verzweigungen
//===========================
	 //---------------------> ATM auswählen
	 public static ATM chooseAtm() throws InputTypeMissmatch, InvalidArrayPos {
		    printAllAtms();
		    int choice = scanInt();
		    if (choice-1 < 0 || choice-1 >= atms.length) {
		        throw new InvalidArrayPos("Diesen Automat gibt es nicht!"); //Abfrage welcher ATM es sein sollte!
		    }
		    return atms[choice-1];
		}
	 
	//---------------------> Hauptmenü auswahl
	 public static boolean chooseMainMenu(ATM atm, BankAccount b) throws InputTypeMissmatch, InvalidDrawAmount, InvalidPinException{ //eingaben für das Hauptmenu
		 printMainMenu();
		 int choice = scanChoice(0, 2); // Ist hardgecoded
		 switch (choice) {
		case 1: 
			handlePin(b, atm); //Als erstes Pin abfragen danach weiter zu Transaktionen
			doTransaction(b, atm);
			break;
		case 2:
			giveGlobalInfos();
			break;
		case 0:
			return false;
		 }
		return true;
	 }
	//--------------> Transaktions auswahl
	 public static void doTransaction(BankAccount acc, ATM atm) throws InputTypeMissmatch , InvalidDrawAmount{ //Eingaben für das Transactionsmenu
		 printMenuTransaction();
		 int choice = scanChoice(1,3);
		 switch (choice) {
		case 1: 
			handleDraw(atm, acc);
			break;
		case 2:
			handleDeposit(atm, acc);
			break;
		case 3:
			System.out.println("Aktueller Saldo: " + acc.getSaldo());
		}
		 
	 }
//=====================
//Run all together
//======================
	 public static void runMainLogic() {
		    boolean status = true;
		    while (status) {
		        try {
		            ATM atm = chooseAtm();
		            sab.destroyRandAtm(); //Randopm zerstören und danach checken ob er noch existiert
		            if (!atm.getStatus()) {
		                printSabotage();
		            } else {
		                status = chooseMainMenu(atm, konto); //Alle catches die was mit der Durchgehendlaufenden Logik zu tun haben
		            }
		        } catch (InputTypeMissmatch e) {
		            System.out.println("Eingabefehler: " + e.getMessage());
		        } catch (InvalidDrawAmount e) {
		            System.out.println("Transaktionsfehler: " + e.getMessage());
		        } catch (InvalidPinException e) {
		            System.out.println("PIN Fehler: " + e.getMessage());
		        } catch (InvalidArrayPos e) {
		            System.out.println("Ungültige Auswahl: " + e.getMessage());
		        }
		    }
		    printLogo("----------------Bis zum nächsten mal");
		}
//============================
// --------Logo
//===========================
	 public static void printLogo(String text) {
		 System.out.println(" .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .-----------------. .----------------. \r\n"
		 		+ "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\r\n"
		 		+ "| |   ______     | || |  ____  ____  | || |  _________   | || |  _________   | || |   ______     | || |      __      | || | ____  _____  | || |  ___  ____   | |\r\n"
		 		+ "| |  |_   _ \\   | || | |_  _||_  _| | || | |  _   _  |  | || | |_   ___  |  | || |  |_   _ \\    | || |     /  \\     | || ||_   \\|_   _| | || | |_  ||_  _|  | |\r\n"
		 		+ "| |    | |_) |   | || |   \\ \\  / /   | || | |_/ | | \\_|  | || |   | |_  \\_|  | || |    | |_) |   | || |    / /\\ \\    | || |  |   \\ | |   | || |   | |_/ /    | |\r\n"
		 		+ "| |    |  __'.   | || |    \\ \\/ /    | || |     | |      | || |   |  _|  _   | || |    |  __'.   | || |   / ____ \\   | || |  | |\\ \\| |   | || |   |  __'.    | |\r\n"
		 		+ "| |   _| |__) |  | || |    _|  |_    | || |    _| |_     | || |  _| |___/ |  | || |   _| |__) |  | || | _/ /    \\ \\_ | || | _| |_\\   |_  | || |  _| |  \\ \\_  | |\r\n"
		 		+ "| |  |_______/   | || |   |______|   | || |   |_____|    | || | |_________|  | || |  |_______/   | || ||____|  |____|| || ||_____|\\____| | || | |____||____| | |\r\n"
		 		+ "| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |\r\n"
		 		+ "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\r\n");
System.out.println(text);
	 }
}
