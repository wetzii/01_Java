package atm_wetzlhuetter;

public class BankAccount {
    private static int accountCount = 0;   // zählt alle erstellten Konten

    private String customerName;
    private int pin;
    private double saldo;

    public BankAccount(String customerName, double saldo) {
        this.customerName = customerName;
        this.saldo = saldo;
        accountCount++;
    }

  
    public static int getAccountCount() { //Alle Accounts werden zurück gegeben -> (globaler Count)
        return accountCount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposit(double amount) {
        saldo += amount;
    }

    public void withdraw(double amount) {
        saldo -= amount;
    }
    public void createPin(int pin) throws InvalidPinTypeException {
    		if(String.valueOf(pin).length() != 4) {
    			throw new InvalidPinTypeException("Dein Pin muss 4 stellig sein");
    		}
    		this.pin = pin;
    }
}