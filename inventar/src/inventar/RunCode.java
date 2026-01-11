package inventar;

public class RunCode {

	public static void main(String[] args) {
	//Snacks
	Snack snack = new Snack("Snickers", 150, 0);
	System.out.println("Der Preis ist: " + snack.getPriceCent());
	System.out.println("Ist verfügbar?: "+ snack.isAvalibale());
	System.out.println("Marke: "+ snack.getLabel());
	snack.sellOne();
	
	System.out.println("--------------------------");
	
	//Souvenier
	Souvenir souv = new Souvenir("StanzSouv", 777, 1);
	System.out.println("Der Preis ist: " + souv.getPriceCent());
	System.out.println("Ist verfügbar?: "+ souv.isAvalibale());
	System.out.println("Marke: "+ souv.getLabel());
	
	}
}
