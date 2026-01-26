package dragon;

import java.util.Scanner;

public class RunCode {
	public static void main(String[] args) {
		greeter();
//
	Scanner scan = new Scanner(System.in);
	Player player = new Player("Matthi");
	mainMenu(scan, new Player("Dein Name"), randDragon());
	scan.close();
	}
	public static void greeter() {
		System.out.println("________ __________    _____    ________ ________    _______   \n"
				+ "\\______ \\\\______   \\  /  _  \\  /  _____/ \\_____  \\   \\      \\  \n"
				+ " |    |  \\|       _/ /  /_\\  \\/   \\  ___  /   |   \\  /   |   \\ \n"
				+ " |    `   \\    |   \\/    |    \\    \\_\\  \\/    |    \\/    |    \\\n"
				+ "/_______  /____|_  /\\____|__  /\\______  /\\_______  /\\____|__  /\n"
				+ "        \\/       \\/         \\/        \\/         \\/         \\/ ");
	}
	public static void mainMenu(Scanner scan, Player player, AbstractDragon dragon) {
		while (true) {
			System.out.println("------------------------------------");
		System.out.println("Was möchtest du machen?");
		System.out.println("(1) --> Füttern");
		System.out.println("(2) --> für Drachen singen");
		System.out.println("(3) --> Drache Geschenk machen");
		System.out.println("(4) --> Drache annähern");
		System.out.println("(5) --> Werte ausgeben)");
		doAction(player, dragon, askMainManu(scan));
		if(dragon.checkWinMaster()) {
			return;
				}
			}
		}
	public static int askMainManu(Scanner scan) {
		int user;
		do {
			System.out.println("Eingabe-------------------");
			user = scan.nextInt();
			scan.nextLine();
		}while(user < 1 && user > 5);
		return user;
	}
	public static void doAction(Player player, AbstractDragon dragon, int choice) {
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
		}
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

		
		AbstractDragon[] dragons = {new ShyDragong(dragonNames[(int)(Math.random() * dragonNames.length)]), new GreedyDragon(dragonNames[(int)(Math.random() * dragonNames.length)]), new ProudDragon(dragonNames[(int)(Math.random() * dragonNames.length)])}; 
		return dragons;
	}
	public static AbstractDragon randDragon(){
		AbstractDragon[] dragons= createDragons();
		return dragons[(int) (Math.random() * dragons.length)];
	}
	public static void printStats(Player player, AbstractDragon dragon) {
		System.out.println("Dein Name: " + player.getName());
		System.out.println("Dein Gold: "+ player.getGold());
		System.out.println("-----------------------------");
		System.out.println("Name des Drachens:  "+ dragon.getName());
		System.out.println("Achtsamkeit des Drachens: "+dragon.getAlertness());
		System.out.println("Vertrauen des Drachens: "+ dragon.getTrust());
	}
}
