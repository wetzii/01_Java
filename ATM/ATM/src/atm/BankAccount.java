package atm;

public class BankAccount {

	private String costumerNameString;
	private int pin;
	private int saldo;
	
	private BankAccount(int costumerName, int pin, int saldo){
		this.pin = pin;
	}
}
