package casino;

import java.util.Scanner;

public class Roulette implements Playable{
@Override

	public void playRound(Player player, Croupier croupier, int place) {
		if(croupier.checkPlace(place, player)) {
			player.setPlayedGamesUp();
			Scanner scan = new Scanner(System.in);
			System.out.printf("Willkomen %s bei Roulette", player.getName());
			System.out.println("Du kannst gewinnen in dem du Die gleiche Zahl wie der Croupier hast oder wenn du ungerade oder gerade hast");
			System.out.println("Ungerade und Gerade bestimmst du in dem du Ungerade oder Gerade Zah eingibst");
			int num;
			int rewardMulti;
			do{
				System.out.println("Gib deine Zahl 0 - 36");
				num = scan.nextInt();
			}while(num < 0 || num > 36) ;
			System.out.printf("%d wurde auf Zahl %d gesetzt\n", place, num);
			int rightNum = (int) Math.random() * 36;
			
			if(num == rightNum ) {
				winMessage(player);
				rewardMulti = 36;
				addReward(place, rewardMulti, player);
				
				
			}else if(num %2 == rightNum %2 && num != 0 && rightNum != 0) {
				winMessage(player);
				rewardMulti = 2;
				addReward(place, rewardMulti, player);
				
			}else {
				loseMessage(player);
			}
			scan.close();
		}
	}

@Override
	public void loseMessage(Player player) {
		System.out.printf("%s hat bei Roulette leider verloren Versuche es nochmal!!!!\n", player.getName());
	}
@Override
public void winMessage(Player player) {
	System.out.printf("TOP %s hat bei Roulette gewonnen\n", player.getName());
	}
@Override
	public void addReward(int place, int rewardMultiplier, Player player) {
		player.addCredits(rewardMultiplier* place);
		
	}
}
