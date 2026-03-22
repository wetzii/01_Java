package atm_wetzlhuetter;

public class InvalidDrawAmount extends Exception{
	public InvalidDrawAmount(String text) {
		super(text);
	}
}
