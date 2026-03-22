package atm_wetzlhuetter;

public class InvalidPinException extends Exception{
	public InvalidPinException(String text) {
		super(text);
	}
}
