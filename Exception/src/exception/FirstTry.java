package exception;

import java.util.Scanner;

public class FirstTry {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		boolean checkInput = false;
		int age = -1;
		
		while(!checkInput) {
			System.out.println("Geben sie Ihr Alter ein: ");
			
			//Check Input == false
		try {
			age = scan.nextInt();
			checkInput = true;
			
		} catch(Exception e) {
			System.err.println("Geben sie eine Zahl ein!");
			System.out.println(e.getClass().getSimpleName());
		
			scan.nextLine();
			}
		}
		System.out.println(age);
		scan.close();
	}
}
