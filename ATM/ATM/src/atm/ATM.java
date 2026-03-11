package atm;

public class ATM {
	
	private String name;
	static private int globalSum;
	
	
	public ATM (String name) {
		this.name = name;
	}
	public boolean checkPin(BankAccount acc, int pin) {
		return acc.getPin() == pin;
			
	}
	public boolean drawMoney throws new InvalidDrawAmount (BankAccount acc, int sum) {
		if(sum > acc.getSaldo()) {
			return false;
		}else {
			throw new InvalidDrawAmount("Du hast nicht genügend Geld auf den Konto");
		} 
	}
}
