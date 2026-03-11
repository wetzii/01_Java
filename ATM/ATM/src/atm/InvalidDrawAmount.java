package atm;

public class InvalidDrawAmount extends Exception{
	public InvalidDrawAmount(String text) {
		super(text);
	}
}
