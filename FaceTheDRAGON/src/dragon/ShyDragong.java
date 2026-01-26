package dragon;

public class ShyDragong extends AbstractDragon{
/*
 *• ShyDragon (Start: Vertrauen 30, Wachsamkeit 70)
‣ Kompliment: Vertrauen +5, Wachsamkeit -2
‣ Füttern: (gelungen): Vertrauen +7, Wachsamkeit -3
‣ Füttern: (misslungen): Vertrauen -2, Wachsamkeit +2
‣ Singen: Vertrauen +6, Wachsamkeit -5
‣ Geschenk: nur wenn Spieler genug Gold hat: Vertrauen +5, Wachsamkeit -2,
Spieler-Gold -10
– sonst: Vertrauen -3, Wachsamkeit +1
‣ Nähern: Vertrauen +3, Wachsamkeit -2
 */
	public ShyDragong(String name) {
		super(name, 30, 70);
	}
	
	@Override
		public void reactCompliment() {
			super.changeTrust(5);
			super.changeAlertness(-2);
		}
	@Override
		public void reactFeedHimNeg() {
			//Füttern: (misslungen): Vertrauen -2, Wachsamkeit +2
		super.changeTrust(2);
		super.changeAlertness(2);
		}
	@Override
		public void reactFeedHimPos() {
		super.changeTrust(7);
		super.changeAlertness(-3);
		}
	@Override
		public void reactSing() {

		super.changeTrust(6);
		super.changeAlertness(-5);
		}
	@Override
		public boolean reactToGift(Player player) {
	    boolean status;
			if(player.getGold() >= 10) {
				System.out.println("Geschenk wurde übergeben!");
				player.setGold(-10);
				super.changeTrust(5);
				super.changeAlertness(-2);
				status =  true;	
			}else {
				System.out.println("Nicht genügend GOLD!");
				super.changeTrust(-3);
				super.changeAlertness(1);
				status =  false;
			}
		return status;
		}
	@Override
		public void reactGetClose() {
		System.out.println("Du näherst dich den Drachen an!");
		super.changeTrust(3);
		super.changeAlertness(-3);
	}
	@Override
		public void collectGold() {
			System.out.println("Kommt noch");
		}
	@Override
		public boolean checkWinGold() {
			if(super.getAlertness()  <= 0) {
				return true;
			}else {
				return false;
			}
		}
}
