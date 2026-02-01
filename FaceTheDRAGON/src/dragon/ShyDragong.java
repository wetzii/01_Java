package dragon;

public class ShyDragong extends AbstractDragon{

	//Alle Methoden werden überschrieben und mit den Richtigen Werten versehen
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
		//einfache Abfrage ob genügend Gold da ist
		//Satus ist da um zurückzugeben ob das Geschenk übergeben wird oder nicht --> Muss nicht unbedingt verwendet werden
	    boolean status;
			if(player.getGold() >= 10) {
				System.out.printf("Geschenk wurde an %s übergeben!\n", getName());
				player.decGold(10);
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
		System.out.printf("Du näherst dich den Drachen %s an!\n", getName());
		super.changeTrust(3);
		super.changeAlertness(-3);
	}
}
