package inventar;

public interface Sellable {
	public abstract String getLabel() ;
	public abstract double getPriceCent();
	public abstract boolean isAvalibal();
	public abstract void sellOne();
	
}
	
