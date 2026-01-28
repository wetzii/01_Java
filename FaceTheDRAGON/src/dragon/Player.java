package dragon;

public class Player implements Status {
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
	public String getName() {
		return name;
	}
	public void decGold(int changedGold) {
		if(changedGold <= gold) {
		System.out.printf("Das Gold ändert sich um %d auf %d\n reduziert", gold , gold - changedGold);
		gold -= changedGold;
		} else {
			System.out.println("Du hast kein Gold dafür!");
		}
	}

		@Override
			public String getStatus() {
				return "Name: "+ name+ "\nGold: "+ gold;
			}
}

