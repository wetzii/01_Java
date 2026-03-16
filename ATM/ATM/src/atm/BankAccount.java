package atm;

public class BankAccount {

	private String costumerName;
	private int pin;
	private int saldo;
	private static int accountCount = 0;
	
	public BankAccount(String costumerName, int pin, int saldo){
		
		this.costumerName = costumerName;
		this.pin = pin;
		this.saldo = saldo;
	}
	public int getPin() {
		return pin;
	}
	public int getSaldo() {
		return saldo;
	}
	public String getCostumerName() {
		return costumerName;
	}
}
