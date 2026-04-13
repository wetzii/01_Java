package hashEqual;
import java.util.Objects;
public class Adress {

	private String street;
	private int houseNumber;
	private int postCode;
	private String city;
	
	public Adress(String street, int houseNumber, int postCode, String city) {
		this.street = Objects.requireNonNull(street, "Street darf nicht Null sein!");
		this.houseNumber = houseNumber;
		this.postCode = postCode;
		this.city =  Objects.requireNonNull(city, "Street darf nicht Null sein!");
		
	}
	public String getStreet() {
		return street;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public int getPostCode() {
		return postCode;
	}
	public String getCity() {
		return city;
	}
	@Override 
	public boolean equals(Object other) {
		Adress otherObj = (Adress) other;
		return otherObj.street.equals(otherObj)
	}
}
