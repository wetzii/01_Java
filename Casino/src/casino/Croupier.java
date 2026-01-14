package casino;

public class Croupier extends Persons {

	public Croupier (String name) {
		super(name);
	}
	public boolean checkPlace(int place, Player player) {
		if((player.getCredits() + place)/2 > place) {
			System.out.println("Ungültiger Einsatz du Setzt mehr wie die Hälfte deiner Credits");
			System.out.printf("Du hast %d Credits zurück gebucht bekommen\n", place);
			return false;
		}else {
			System.out.printf("Crouper %s hat den Einsatz %s Credits akzeptiert \n", getName(), place);
			return true;
		}
	}
	@Override
	public boolean performRole() {
	System.out.printf("%s überwacht das Spiel!",getName());
		return true;
	}
}
