package demofiles;

// Signature
public abstract class   TwoWheeler {
// Fields
	private String model;
	private String color;
	private String engine;
	private int speed;
	
// Constructor
	public TwoWheeler(String model, String color, String engine) {
		this.model = model;
		setColor(color);
		setEngine(engine);
		speed = 0;
	}
	
// Getter (Accessor)
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public String getEngine() {
		return engine;
	}
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	//Setter (Mutator)
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setEngine(String engine) {
		this.engine = engine;
	}
	
	public abstract void speedUp(int increase) ;
	public void slowDown(int decrease ) {
		speed -= decrease;
		System.out.printf("Du drossels um %d km/h auf %d km/h", decrease, getSpeed());
	}
	
	@Override
	public String toString() {
		return String.format("Type: %s\n"
				+ "Geschwindigkeit: %d", model, speed);
	}
}
