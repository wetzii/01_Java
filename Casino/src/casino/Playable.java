package casino;

public interface Playable { //Interfaces
	

	public void playRound(Player player, Croupier croupier, int place);
	public void loseMessage(Player player);
	public void winMessage(Player player);
	public void addReward(int place, int rewardMultiplier, Player player); // ZUsatz Methode die ich dazu benutze Reward hinzuzufügen
}
