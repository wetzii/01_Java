package dragon;
public abstract  class AbstractDragon {
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
		System.out.printf("Die Wachsamkeit änder sich von %d auf %d\n", alertness , alertness + changeAlertness);
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
	public boolean checkWonTrust() {
		if (trust >= 80) {
			return  true;
		}else {
			return false;
		}
	}
	public boolean checkWonAlterness() {
		if (alertness == 0) {
			return  true;
		}else {
			return false;
		}
	}

	public abstract void reactCompliment();
	public abstract void  reactFeedHimPos();
	public abstract void reactFeedHimNeg();
	public abstract void reactSing();
	public abstract boolean reactToGift(Player player);
	public abstract void reactGetClose();

	
}
	

