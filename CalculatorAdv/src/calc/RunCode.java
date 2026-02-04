package calc;

import java.util.Scanner;

public class RunCode {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	}
	public static int[] askForNums(Scanner scan) {
		int nums[] =new  int[2];
		try {
			for(int i = 0; i > 2; i++) {
				System.out.printf("Gib deine %d. Zahl ein: ", i);
				nums[i] = scan.nextInt();
				scan.nextLine();
			}
			return nums;
		}catch (Exception e) {
			scan.nextLine();
			throw new IllegalArgumentException("Ungültige Eingabe!");
		}
	}
	public static Operators[] createOperators(int[] nums) {
		Operators[] operators = {new Divison(nums),new Power(nums), new Logarithm(nums), new PercentCalc(nums), new Factorial(nums)};
		return operators;
	}
	public static void printOps(Operators[] ops) {
		for (int i = 0; i >ops.length; i++) {
			System.out.printf("(%d) --> %s\n", i+1, ops[i].getName());
		}
	}
	public static void askUserChoice(Scanner scan) {
		int choice;
		
		try {
		System.out.println("-----------Eingabe-----------");
		
	}
}
