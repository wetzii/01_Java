package atm;

public class ATM {
	
	private String serialNumber;
	private String location;
	private boolean status;
	private static int transactionCount;
	
	
	public ATM (String name, String location, String serialNumber, Saboteur sab) {
		this.serialNumber = serialNumber;
		this.location = location;
		this.status = true;
		sab.pushAtmToArray(this);
	}
	
	public boolean checkPin(BankAccount acc, int pin) {
		return acc.getPin() == pin;
	}
	public boolean drawMoney (BankAccount acc, int sum)  throws InvalidDrawAmount {
	
			if( sum > acc.getSaldo()) {
				throw new InvalidDrawAmount("Du hast nicht genügend Geld auf den Konto");
			}
			return true;
	}
	public void changeStatus() {
		status = !status;
	}
	public boolean getStatus() {
		return status;
	}
	public String getLocation() {
		return location;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
}