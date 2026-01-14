package casino;

public class Player extends Persons {
	private int credits;
	private int playedGames;
	public Player(String name, int startCredits) {
		super(name);
		credits = startCredits;
	}
	public void addCredits(int addCredits) {
		if (addCredits > 0) {
			System.out.printf("Du hast %d Credits hinzugefügt den standt Steigt von %d --> %d\n", addCredits,credits,credits+addCredits);
			credits += addCredits;
		}
	}
	public boolean placeCredits(int place) {
		if(place > 0 && place <=credits) {
			System.out.println(place + "Credits wurden gesetzt");
			return true;
			
		}else {
			System.out.println("Ungültiger Einsatz");
			return false;
		}
	}
	public void setCredits(int credits) {
		this.credits += credits;
	}
	public int getCredits() {
		return credits;
	}
	public int getPlayedGame() {
		return playedGames;
	}
	public void setPlayedGamesUp() {
		playedGames++;
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
	
