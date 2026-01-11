package inventar;

public interface Sellable {
	public abstract String getLabel() ;
	public abstract double getPriceCent();
	public abstract boolean isAvalibale();
	public abstract void sellOne();
	
}
	
