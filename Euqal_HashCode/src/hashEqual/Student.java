package hashEqual;


public class Student {
	private static int nextID;
	
	private Name name;
	private Adress adress;
	private int id;
	
	public Student(Name name, Adress adress) {
		this.name = name;
		this.adress = adress;
		this.id = nextID;
		nextID ++;
	}
	
	public Name getName() {
		return name;
	}
	public Adress getAdress() {
		return adress;
	}
	public int getID() {
		return id;
	}
	@Override
	public String toString() {

		return String.format("""
				Name: %s %s
				Adress: %s %d, %d %s
				ID: %d
				""",getName().getFirstname(), getName().getLastname(),getAdress().getHouseNumber(),getAdress().getHouseNumber(), getAdress().getPostCode(),getAdress().getCity(),getID());
	}
	public boolean equals(Object other) {
		if(other == this) return true;
		if(other == null) return false;
		if(other.getClass() != this.getClass()) return false;
		
		Student otherObj = (Student) other;
		return otherObj.id == this.id;
	}
}
