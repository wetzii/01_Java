package dragon;

import java.util.Scanner;

public class RunCode {
	public static void main(String[] args) {
		greeter();
		
	Scanner scan = new Scanner(System.in);
	mainMenu(scan, createUser(scan), randDragon());
	scan.close();
	}
	public static void greeter(){ //Greeter ist da um Grafik auszugeben --> Grafik wird nicht auf jeden Gerät richtig ausgegeben
		System.out.println("___{_____ __________    _____    ________ ________    _______   \n"
				+ "\\______ \\\\______   \\  /  _  \\  /  _____/ \\_____  \\   \\      \\  \n"
				+ " |    |  \\|       _/ /  /_\\  \\/   \\  ___  /   |   \\  /   |   \\ \n"
				+ " |    `   \\    |   \\/    |    \\    \\_\\  \\/    |    \\/    |    \\\n"
				+ "/_______  /____|_  /\\____|__  /\\______  /\\_______  /\\____|__  /\n"
				+ "        \\/       \\/         \\/        \\/         \\/         \\/ ");
	}
	public static void mainMenu(Scanner scan, Player player, AbstractDragon dragon) {
		boolean status = true;
		
		while (status == true) {  //Methode die immer die Grafik ausgibt was man spielen kann
			System.out.println("------------------------------------");
		System.out.println("Was möchtest du machen?");
		System.out.println("(1) --> Füttern");
		System.out.println("(2) --> für Drachen singen");
		System.out.println("(3) --> Drache Geschenk machen");
		System.out.println("(4) --> Drache annähern");
		System.out.println("(5) --> Werte ausgeben");
		System.out.println("(0) --> Spiel beenden!");
		status = doAction(player, dragon, askMainManu(scan));
		if(dragon.checkWinMaster()) {
			return;
				}
			}
		}
	public static int askMainManu(Scanner scan) {   //methode ist nur da um Abzufragen was man machen möchte
		int user;
		do {
			System.out.println("Eingabe-------------------");
			user = scan.nextInt();
			scan.nextLine();
		}while(user < 0 && user > 5);
		return user;
	}
	
	public static boolean doAction(Player player, AbstractDragon dragon, int choice) { //Diese Methode bekommt eine Zahl und leitet dann weiter was man machen kann
		boolean status = true;
		switch(choice) {
			case 1: 
				dragon.feedHimMaster();
				break;
			case 2:
				dragon.reactSing();
				break;
			case 3:
				dragon.reactToGift(player);
				break;
			case 4:
				dragon.reactGetClose();
				break;
			case 5:
				printStats(player, dragon);
				break;
			case 0:
				goodbye();
				status = false;
				return status;
		}
		return status;
	}
	public static AbstractDragon[] createDragons() {
		String[] dragonNames = {
		                      "NullPointer", //Array wurde von ChatGPT befüllt
		                      "Firewallfred",
		                      "StackOverflow",
		                      "Bugzilla",
		                      "Sir Crashes-a-Lot",
		                      "BlueScreen",
		                      "Lagathor",
		                      "Lord Segfault",
		                      "Dr. Exception",
		                      "MemoryLeak",
		                      "KernelPanic",
		                      "PatchyMcPatchface",
		                      "404DracheNotFound",
		                      "Syntaxerrorion",
		                      "RuntimeRex",
		                      "Bitbeißer",
		                      "Cloudschlurfer",
		                      "CopyPastegon",
		                      "Debuggadon",
		                      "WiFire"
		};

		//Neuer Drache wird erstellt und mit einem Random Name instanziieret --> funktioniert mnit math.random die eine Zufällige Array Position erzeugt
		AbstractDragon[] dragons = {new ShyDragong(dragonNames[(int)(Math.random() * dragonNames.length)]), new GreedyDragon(dragonNames[(int)(Math.random() * dragonNames.length)]), new ProudDragon(dragonNames[(int)(Math.random() * dragonNames.length)])}; 
		//Also die Methode erzeugt einen Array mit jeder "Drachen Art" welcher Drache dann zum Spiel kommt entscheident andere Methode
		return dragons;
	}
	public static AbstractDragon randDragon(){ 
		AbstractDragon[] dragons= createDragons(); //Führt Methode aus die ale 3 Drachen erzeugt 
		return dragons[(int) (Math.random() * dragons.length)]; //ein Drache wird wandom genommen und zurückgegeben
	}
	public static void printStats(Player player, AbstractDragon dragon) { //Status von Allen Werten wird ausgegeben
		System.out.println("-------------------------------");
		System.out.println(player.getStatus());
		System.out.println("-----------------------------");
		System.out.println(dragon.getStatus());
	}
	public static Player createUser(Scanner scan) {  //user erstellen inkl Abfrage von Namen 
		System.out.println("Gib deinen Namen ein: ");
		String name = scan.nextLine();
		return new Player(name);	
	}
	public static void goodbye () { //Nachricht die kommt wenn man spiel beendet
		greeter();
		System.out.println("------------------------------------");
		System.out.println("Schön das du gespielt hast!");
		System.out.println("Bis zum nächsten mal!");
	}
}
