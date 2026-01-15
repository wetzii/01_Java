package casino;

import java.util.Scanner;

public class Roulette implements Playable{
@Override

	public void playRound(Player player, Croupier croupier, int place) { 
		if(croupier.checkPlace(place, player)) {
			player.setPlayedGamesUp();
			Scanner scan = new Scanner(System.in); // Ich muss Scanner Objekt hier erstellen, da in der Angabe nichts vom Scanner übergeben steht --> Kann ich auch nicht schließen Programm funktioniert sonst nicht
			System.out.println("------------------Roulette------------------");
			System.out.println("Du kannst gewinnen in dem du Die gleiche Zahl wie der Croupier hast oder wenn du ungerade oder gerade hast!");
			System.out.println("Ungerade und Gerade bestimmst du in dem du Ungerade oder Gerade Zah eingibst!");
			 
			int num;
			int rewardMulti; //Damit wird der Gewinn ermittelt
			do{
				System.out.println("------------------Eingabe-------------------");
				System.out.println("Gib deine Zahl 0 - 36");
				num = scan.nextInt(); // USerabfrage
			}while(num < 0 || num > 36) ;
			System.out.printf("%d wurde auf Zahl %d gesetzt\n", place, num); 
			int rightNum = (int) (Math.random() * 37);
			
			if(num == rightNum ) { // Wenn der Sieler die Gleiche Zahl hat
				winMessage(player);
				rewardMulti = 36;
				addReward(place, rewardMulti, player);
				
				
			}else if(num %2 == rightNum %2 && num != 0 && rightNum != 0) { // Wenn der Spieler ungerade oder gerade richtig hat
				winMessage(player);
				rewardMulti = 2;
				addReward(place, rewardMulti, player);
				
			}else {
				System.out.println("Deine Nummer: "+num);
				System.out.println("Richtige Nummer: " +rightNum);
				loseMessage(player);
			}
		}
	}

@Override
	public void loseMessage(Player player) {
	System.out.println("L------L------L-----LOSE------L------L------");
		System.out.printf("%s hat bei Roulette leider verloren Versuche es nochmal!!!!\n", player.getName());
	}
@Override
public void winMessage(Player player) {
	System.out.println("W----W----W----W----WIN----W----W----W----W-");
	System.out.printf("TOP %s hat bei Roulette gewonnen\n", player.getName());
	}
@Override
	public void addReward(int place, int rewardMultiplier, Player player) {
		player.addCredits(rewardMultiplier* place);
		
	}
}
