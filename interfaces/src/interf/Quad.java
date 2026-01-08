package interf;

public class Quad implements Drive {
	//...
	@Override
	public void speedUp(int incSpeed) {
		System.out.printf("Geschwindigkeit wurde um %d Km/H erhöht\n", incSpeed);
	}
}
