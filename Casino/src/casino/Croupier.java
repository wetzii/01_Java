package casino;

public class Croupier extends Persons {

	public Croupier (String name) {
		super(name);
	}
	public boolean checkPlace(int place, Player player) { //Eingabe wird überprüft
		System.out.println("-------------Eingabe Überprüfen-------------");
		if(player.getCredits()/2 < place) { //Wenn der Einsatz zu hoch ist wird er wieder gut geschrieben
			System.out.println("Ungültiger Einsatz du Setzt mehr wie die Hälfte deiner Credits\n");
			System.out.printf("Du hast %d Credits zurück gebucht bekommen\n", place);
			return false;
		}else { //Wenn es passt passiert nichts weiteres außer meldung und true
			System.out.printf("Crouper %s hat den Einsatz %s Credits akzeptiert \n", getName(), place);
			return true;
		}
	}
	@Override
	public boolean performRole() {
	System.out.printf("%s überwacht das Spiel!",getName());  //Abstrakte Methode die einfach sagt das er das Spiel überwacht
		return true;
	}
}
