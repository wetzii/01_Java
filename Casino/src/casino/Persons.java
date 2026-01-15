package casino;

public abstract class  Persons { //Abstrakte KLasse
private String name;

	public Persons (String name) {
		this.name = name;
	}
	public abstract boolean performRole(); //Abstrakte Methode
	
	public String getName() {
		return name;
	}
}
