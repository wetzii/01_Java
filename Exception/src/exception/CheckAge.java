package exception;

import java.util.Scanner;

public class CheckAge {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int age;
		boolean status = false;
		while(!status) {
			try {
				System.out.println("Gib dein Altern ein!: ");
				age = scan.nextInt();
				checkAge(age);
				status = true;
			} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			scan.nextLine();
			} catch (Exception e) {
				System.out.println("Bitte gib eine Zahl ein! ");
				System.out.println(e.getMessage());
				System.out.println(e.getClass().getSimpleName());
			}
		}
	}

	public static void checkAge(int age) {
		if(age < 0) {
			throw new IllegalArgumentException("Das Alter kann nicht negativ sein!");
			
		}
	}
}
