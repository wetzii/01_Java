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
		
		System.out.printf("Die Wachsamkeit änder sich von %d auf %d\n", alertness , alertness + changeAlertness);
		alertness += changeAlertness;
	}
	public void changeTrust(int changeTrust) {
		System.out.printf("Das Vertrauen des Drachens %s ändert sich von %d auf %d\n", name , trust, trust  +changeTrust);
		trust += changeTrust;
	}
	public void status() {
		//MUss noch schaeun was Kommt!
		System.out.println("--");
	}
/*
 

• ShyDragon (Start: Vertrauen 30, Wachsamkeit 70)
‣ Kompliment: Vertrauen +5, Wachsamkeit -2
‣ Füttern: (gelungen): Vertrauen +7, Wachsamkeit -3
‣ Füttern: (misslungen): Vertrauen -2, Wachsamkeit +2
‣ Singen: Vertrauen +6, Wachsamkeit -5
‣ Geschenk: nur wenn Spieler genug Gold hat: Vertrauen +5, Wachsamkeit -2,
 */
	public abstract void reactCompliment();
	public abstract void  reactFeedHimPos();
	public abstract void reactFeedHimNeg();
	public abstract void reactSing();
	public abstract boolean reactToGift(Player player);
	public abstract void reactGetClose();
}
	

