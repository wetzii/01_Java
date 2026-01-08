package demofiles;

// Signature
public class Moped extends TwoWheeler {
	public Moped(String model, String color, String engine) {
		super(model, color, engine);
	}
	@Override
	public void speedUp(int increase) {
		int speed = getSpeed();
		if(speed + increase > 45) {
			System.out.println("Dein Moped kann nicht so schnell fahren");
		} else {
			setSpeed(speed += increase);
			System.out.println("Deine Moped fährt " + getSpeed());
		}
	}
	}