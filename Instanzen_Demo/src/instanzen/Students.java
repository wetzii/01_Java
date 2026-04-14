package instanzen;

import hashEqual.Adress;

public class Students extends Person{
	private int matNr;
	
	public Students (String name, int matNr) {
		super(name);
		this.matNr= matNr;
	}
	public int getMatNr() {
		return matNr;
	}
	public boolean equals(Object other) {
		if(other == this) return true;
		if(other == null) return false;
		if(other.getClass() != this.getClass()) return false;
		
		Student otherObj = (Student) other;
		
	}
}
