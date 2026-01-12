package casino;

public abstract class  Persons {
private String name;

	public Persons (String name) {
		this.name = name;
	}
	public abstract boolean performRole();
	
	public String getName() {
		return name;
	}
}
