package dragon;

public class GreedyDragon extends AbstractDragon{
	


 /*
 Kompliment: Vertrauen +2, Wachsamkeit +1
‣ Füttern: (gelungen): Vertrauen +5, Wachsamkeit -2
‣ Füttern: (misslungen): Vertrauen -4, Wachsamkeit +3
‣ Singen: Vertrauen +1, Wachsamkeit -3
‣ Geschenk: nur wenn Spieler genug Gold hat: Vertrauen +14, Wachsamkeit -6,
Spieler-Gold -10
– sonst: Vertrauen -6, Wachsamkeit +2
‣ Nähern: Vertrauen -2, Wachsamkeit +2*/
	 public GreedyDragon(String name) {
		super(name, 20, 84);
	}
	
	@Override
		public void reactCompliment() {
			super.changeTrust(2);
			super.changeAlertness(1);
		}
	@Override
		public void reactFeedHimNeg() {
			//Füttern: (misslungen): Vertrauen -2, Wachsamkeit +2
		super.changeTrust(-4);
		super.changeAlertness(3);
		}
	@Override
		public void reactFeedHimPos() {
		super.changeTrust(5);
		super.changeAlertness(-2);
		}
	@Override
		public void reactSing() {

		super.changeTrust(1);
		super.changeAlertness(-3);
		}
	@Override
		public boolean reactToGift(Player player) {
	    boolean status;
			if(player.getGold() >= 10) {
				System.out.println("Geschenk wurde übergeben!");
				player.setGold(-10);
				super.changeTrust(14);
				super.changeAlertness(-6);
				status =  true;	
			}else {
				System.out.println("Nicht genügend GOLD!");
				super.changeTrust(-6);
				super.changeAlertness(2);
				status =  false;
			}
		return status;
		}
	@Override
		public void reactGetClose() {
		System.out.println("Du näherst dich den Drachen an!");
		super.changeTrust(-2);
		super.changeAlertness(2);
		}
}


