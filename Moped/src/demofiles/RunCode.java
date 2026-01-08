package demofiles;
import java.util.Scanner;

public class RunCode {
	public static void main(String[] args) {
		TwoWheeler moped = new Moped("PuchTM50", "green", "Puch");
		System.out.println(moped.getModel());
		Motorcycle motorcycle = new Motorcycle("Husquana 78", "red", "Husquana");
		System.out.println(motorcycle.getModel());
		
		moped.speedUp(50);
		System.out.println(moped);
		}
		
	}
