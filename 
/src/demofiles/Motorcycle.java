package demofiles;

// Signature
public class Motorcycle extends TwoWheeler{
	public Motorcycle(String model, String color, String engine) {
		super(model, color, engine);
	}
	

	@Override
	public  void speedUp(int increase) {
	setSpeed(getSpeed() + increase);	
		System.out.println("Wroom Wroom");
	}
			

}


