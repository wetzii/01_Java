package dragon;

public class GreedyDragon extends AbstractDragon{
	//Alle methoden werden überschrieben und mit Werten versehen 
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
				player.decGold(10);
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


