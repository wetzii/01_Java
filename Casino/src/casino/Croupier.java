package casino;

public class Croupier extends Persons {

	public Croupier (String name) {
		super(name);
	}
	@Override
	public boolean performRole() {
	System.out.printf("%s überwacht das Spiel!",getName());
		return true;
	}
}
