package dragon;

public class ProudDragon extends AbstractDragon {
/*
 
 
Kompliment: Vertrauen +14, Wachsamkeit −2
‣ Füttern: (gelungen): Vertrauen +7, Wachsamkeit −3
‣ Füttern: (misslungen): Vertrauen −2, Wachsamkeit +1
‣ Singen: Vertrauen +6, Wachsamkeit −4
‣ Geschenk: nur wenn Spieler genug Gold hat: Vertrauen +4, Wachsamkeit -2,
Spieler-Gold -10
– sonst: Vertrauen -1, Wachsamkeit +1
‣ Nähern: Vertrauen +4, Wachsamkeit −2
 */
	public ProudDragon(String name) {
		super(name, 45 ,60);
	}
	
	@Override
		public void reactCompliment() {
			super.changeTrust(14);
			super.changeAlertness(-2);
		}
	@Override
		public void reactFeedHimNeg() {
		System.out.println("Füttern ist missgelungen!");
		System.out.println("-----------------------------------------------------");
		super.changeTrust(-2);
		super.changeAlertness(1);
		}
	@Override
		public void reactFeedHimPos() {
		System.out.println("Füttern war erfolgreich der Drache mag es!");
		System.out.println("-----------------------------------------------------");
		super.changeTrust(7);
		super.changeAlertness(-3);
		}
	@Override
		public void reactSing() {
		System.out.println("I kom ausm landl Tirol! du Singst für den Drache er findet es TOLL!");
		System.out.println("-----------------------------------------------------");
		super.changeTrust(6);
		super.changeAlertness(-4);
		}
	@Override
		public boolean reactToGift(Player player) {
	    boolean status;
			if(player.getGold() >= 10) {
				System.out.println("Geschenk wurde übergeben!");
				System.out.println("Der Drache findet es ok!");
				System.out.println("-----------------------------------------------------");
				player.decGold(10);
				super.changeTrust(4);
				super.changeAlertness(-2);
				status =  true;	
			}else {
				System.out.println("Nicht genügend GOLD!");
				System.out.println("Der Drache findet es nicht toll!");
				System.out.println("-----------------------------------------------------");
				super.changeTrust(-1);
				super.changeAlertness(1);
				status =  false;
			}
		return status;
		}
	@Override
		public void reactGetClose() {
		System.out.println("Du näherst dich den Drachen an!");
		System.out.println("-----------------------------------------------------");
		super.changeTrust(4);
		super.changeAlertness(-2);
	
		}
}


