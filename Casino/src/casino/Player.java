package casino;

public class Player extends Persons {
	private int credits;
	private int playedGames;
	public Player(String name) {
		super(name);
		credits = 0;
	}
	public void addCredits(int addCredits) {
		if (addCredits > 0) {
			System.out.printf("Du hast %d Credits hinzugefügt den standt Steigt von %d --> %d", addCredits,credits,credits+addCredits);
			credits += addCredits;
		}
	}
	public int placeCredits(int place) {
		if(place > 0) {
			System.out.println(place + "Credits wurden gesetzt");
			return place;
			
		}else {
			System.out.println("Ungültiger Einsatz");
			return 0;
		}
	}
	public void setCredits(int credits) {
		this.credits += credits;
	}
	public int getCredits() {
		return credits;
	}
	@Override
	public boolean performRole() {
		 if(credits > 0) {
			 System.out.println("Dein Name: "+ getName());
			 System.out.println("Deine Credits :"+ credits);
			 return true;
			 }else {
				 System.out.println("Du hast nicht genug Credits!!!");
				return false;
			}
	}
}
	
