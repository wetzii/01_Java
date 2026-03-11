package atm;

public class UI {
	public static void main(String[] args) {
		
		BankAccount acc = new BankAccount("Test", 1200, 12);
		ATM atm01 = new ATM("Test01");
		
		try {
			atm01.drawMoney(acc, 13);
		}catch (InvalidDrawAmount e) {
			System.out.println("Du kannst nicht so viel AbhebenQ");
		}catch (Exception e) {
			System.out.println("Keine Ahnung");
		}
		
	}

}
