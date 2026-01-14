package casino;

public class Croupier extends Persons {

	public Croupier (String name) {
		super(name);
	}
	public checkPlace(int place, Player player) {
		if((player.getCredits() + place)/2 > place)
	}
	@Override
	public boolean performRole() {
	System.out.printf("%s überwacht das Spiel!",getName());
		return true;
	}
}
