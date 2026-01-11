package inventar;

public interface Sellable {
	//Alle Interfaces angelegt
	public abstract String getLabel() ;
	public abstract int getPriceCent();
	public abstract boolean isAvalibale();
	public abstract void sellOne();
	
}
	
