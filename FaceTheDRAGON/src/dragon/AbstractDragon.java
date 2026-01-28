package dragon;


public abstract  class AbstractDragon implements GoalGold, GoalRide, Status{
	/*
	 *• Abstrakte Klasse AbstractDragon
‣ Gemeinsame Attribute: name, trust, alertness (Wachsamkeit)
‣ Gemeinsame Methoden: Getter, changeTrust(…), changeAlertness(…), status()
‣ Abstrakte Methoden für Reaktionen auf die 5 Aktionen (z.B. reactToCompli-
ment(), …)
	 */
	
private int trust;
private String name;
private int alertness;

	public AbstractDragon(String name, int trust, int alertness) {
	this.name = name;
	this.trust = trust;
	this.alertness = alertness;
	}
	public String getName() {
		return name;
	}
	public int getTrust() {
		return trust;
	}
	public int getAlertness() {
		return alertness;
	}
	public void changeAlertness(int changeAlertness) {
		if(alertness + changeAlertness > 0) {
		System.out.printf("Die Wachsamkeit ändert sich von %d auf %d\n", alertness , alertness + changeAlertness);
		alertness += changeAlertness;
		}else {
			System.out.println("Die Wachsamkeit liegt auf 0");
			alertness = 0;
		}
	}
	public void changeTrust(int changeTrust) {
		System.out.printf("Das Vertrauen des Drachens %s ändert sich von %d auf %d\n", name , trust, trust  +changeTrust);
		if (trust + changeTrust > 0)
		trust += changeTrust;
	}
	public void status() {
		//MUss noch schaeun was Kommt!
		System.out.println("--");
	}
	
	public void feedHimMaster() {
		int rand =(int ) (Math.random() *2);
		if(rand == 0) {
			reactFeedHimPos();
		}else if(rand == 1) {
			reactFeedHimNeg();
		}
	}
	public boolean checkWinMaster() {
		if(checkWinGoal() || checkWinRide()) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean checkWinGoal() {
		if(alertness <= 0) {
			winMsgGold();
			return true;
		}else {
			return false;
		}	
	}
	@Override
	public void collectGold(Player player) {
		player.decGold(200000); //Muss geändert werden
		
	}
	@Override
	public void winMsgGold() {
		System.out.println("Du hast den Schatz bekommen!");
	}
	@Override
	public boolean checkWinRide() {
		if(trust >= 100) {
			winMsgRide();
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void winMsgRide() {
		System.out.println("Juhu du hast den Drachen für die bekommen --> Fliege mit Ihm");
		
	}
	@Override
	public String getStatus() {
		return "Name: " + name + "\nVertrauen: " + trust + "\nWachsamkeit: " + alertness + "\n";
	}

	public abstract void reactCompliment();
	public abstract void  reactFeedHimPos();
	public abstract void reactFeedHimNeg();
	public abstract void reactSing();
	public abstract boolean reactToGift(Player player);
	public abstract void reactGetClose();

	
}
	

