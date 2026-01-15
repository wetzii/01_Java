package casino;

import java.util.Scanner;

public class SlotMaschine  implements Playable{

public int[] spin() {
	int[] slotMaschine = new int[5];
	for (int i = 0; i < 5; i++) {
		slotMaschine[i] = (int) (Math.random()*9) +1;
	}
	return slotMaschine;
}
@Override
public void playRound(Player player, Croupier croupier, int place) {
	if(croupier.checkPlace(place, player)) {
		
		System.out.println("---------------Slot Maschine----------------");
		System.out.println("Hast du 3 Gleiche Zahlen Bekommst du das 12 Fache");
		Scanner scan = new Scanner(System.in);// Ich muss Scanner Objekt hier erstellen, da in der Angabe nichts vom Scanner übergeben steht --> Kann ich auch nicht schließen Programm funktioniert sonst nicht
		System.out.println("(Belibige Taste) um fortzufahren");
		scan.nextLine();
		int[] nums = spin();
		System.out.println("--------------------------------------------");
		System.out.printf("------------[%d] [%d] [%d] [%d] [%d]-------------\n",nums[0], nums[1], nums[2], nums[3],nums[4]);
		System.out.println("|-|-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|-|-|-|-|-|\n");
		boolean allSame = true;
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[0]) {
				allSame = false;
				break;
			}
		}

		if(allSame) {
			winMessage(player);
			addReward(place, 50, player);
		}else {
		loseMessage(player);
			}
		}
	}

@Override
	public void loseMessage(Player player) {
	System.out.println("L------L------L-----LOSE------L------L------");
		System.out.printf("%s hat bei Slot Maschiene Leider Verloren Versuche es nochmal! \n",player.getName());
	}
@Override
	public void winMessage(Player player) {
	System.out.println("W----W----W----W----WIN----W----W----W----W-");
		System.out.printf("%s hat Bei Slot Maschine Gewonnen TOLL!!!\n", player.getName());
	}
@Override
	public void addReward(int place, int rewardMultiplier, Player player) {
		player.addCredits(rewardMultiplier* place);
	}
}
