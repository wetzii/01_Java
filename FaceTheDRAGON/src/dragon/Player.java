package dragon;

public class Player {
private String name;
private int gold;
//Mybe kommt nacher nochwas

	public Player(String name) {
		this.name = name;
		this.gold = 20;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int changedGold) {
		System.out.printf("Das Gold ändert sich von %d auf %d\n", gold , gold + changedGold);
		gold += gold;
	}
}
