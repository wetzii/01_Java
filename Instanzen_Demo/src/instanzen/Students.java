package instanzen;

public class Students extends Person{
	private int matNr;
	
	public Students (String name, int matNr) {
		super(name);
		this.matNr= matNr;
	}
	public int getMatNr() {
		return matNr;
	}
}
