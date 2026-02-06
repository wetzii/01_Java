package calc;

import java.util.Scanner;

public class RunCode {

    public static void main(String[] args) {
    	msgCalc("Wilkommen bei");
        Scanner scan = new Scanner(System.in);    
        while(true) {
        int[] nums = askForNums(scan);  //Beide Zahlen werden abgefragt mit Methode
        Operators[] operators = createOperators(nums);  // Alle Operator Objekte werden erstellt in eigener Methode
        printOps(operators); //Alle Operatoren werden ausgegeben mit Index Zahl im Array +1 das ist für ausgabe perfekt
        int choice = askUserChoice(scan);   //User sucht aus von printOps was er machen will
        if(choice == 0) {
        	msgCalc("Wiedersehen bei");
        	break;
        }
        
        doCalc(choice, operators);  // Führt alles aus
        }
        scan.close();
    }

    public static int[] askForNums(Scanner scan) { //methode die EInfach beide Zahlen abfragt und als Array zurückgibt
        int[] nums = new int[2];

        try {
            for (int i = 0; i < 2; i++) {
                System.out.printf("Gib deine %d. Zahl ein: ", i + 1);   
                nums[i] = scan.nextInt();
            }
            scan.nextLine(); //Buffer leeren
            return nums;
        } catch (Exception e) {
            scan.nextLine(); //Buffer 
            throw new IllegalArgumentException("Ungültige Eingabe!");
        }
    }

    public static Operators[] createOperators(int[] nums) { //Alle OPeratoren Objekte werden mt den 2 Abgefragten Zahken erstellt
        return new Operators[]{new Divison(nums), new Power(nums), new Logarithm(nums), new PercentCalc(nums), new Factorial(nums)
        };
    }

    public static void printOps(Operators[] ops) { //Alle möglichen Operationen werden direkt asu dem Array ausgegeben
        System.out.println("-----------Operationen-----------");
        for (int i = 0; i < ops.length; i++) {
            System.out.printf("(%d) --> %s%n", i + 1, ops[i].getName()); //Stelle+1 + Namen
        }
        System.out.println("(0) --> Beenden");
    }
    public static int askUserChoice(Scanner scan) {
        try {
            System.out.print("Wähle eine Operation: "); //Nimt die Zahl entgegen  die Bei printOps dabeisteht
            int choice = scan.nextInt();
            scan.nextLine(); 
            return choice;
        } catch (Exception e) {
            scan.nextLine();
            throw new IllegalArgumentException("Ungültige Auswahl!");
        }
    }

    public static void checkPosRange(Operators[] ops, int choice) { //Einfache Metode die checkt ob die Zahl im Wertebereichs des Arrays ist
        if (choice < 1 || choice > ops.length) {
            throw new IllegalArgumentException("Gib eine Zahl im gültigen Bereich ein!");
        }
    }

    public static void doCalc(int choice, Operators[] ops) { //Du calc Führt alles aus
        try {
            checkPosRange(ops, choice); //1. Zahl die Abgefragt wird auf den Gültigen Werte bereich

            Operators op = ops[choice - 1]; //Danach wird sozumsagen das Objekt mit dem gerechnet wird aus dem Array 'entnommen' mit choice -1 weil vorher war Plus 1
            op.check(); //Checkt immer Pro Rechen zeichen die Bedingungen
            int[] nums = op.getNums(); //Zahlen werden nochmal 'geholt'
            double result = op.calc(nums); //Rechnung wird ausgeführt -> merke gerade Nums übergeben sinnlos

            op.printResult(nums, result); //Ergebnis wird ausgegeben

        } catch (Exception e) {
            System.err.println(e.getMessage()); //Hab das irgendwo mall mit err Gesehen --> macht text Rot also so wie Fehler meldung
        }
    }
    public static void msgCalc(String text) {
    	System.out.printf("------------------------%s------------------------\n",text);
    	System.out.println("      o__ __o           o           o            o__ __o   \n"
    			+ "     /v     v\\         <|>         <|>          /v     v\\  \n"
    			+ "    />       <\\        / \\         / \\         />       <\\ \n"
    			+ "  o/                 o/   \\o       \\o/       o/            \n"
    			+ " <|                 <|__ __|>       |       <|             \n"
    			+ "  \\\\                /       \\      / \\       \\\\            \n"
    			+ "    \\         /   o/         \\o    \\o/         \\         / \n"
    			+ "     o       o   /v           v\\    |           o       o  \n"
    			+ "     <\\__ __/>  />             <\\  / \\ _\\o__/_  <\\__ __/>  \n"
    			+ "                                                           \n"
    			+ "                                                           \n"
    			+ "                                                           ");
    }
}
