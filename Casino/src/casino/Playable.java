package casino;

public interface Playable {
	
	
	//Play 
	//Lose
	//Win
	
	public void playRound(Player player, Croupier croupier, int place);
	public void loseMessage(Player player);
	public void winMessage(Player player);
	public void addReward(int place, int rewardMultiplier, Player player);
}
