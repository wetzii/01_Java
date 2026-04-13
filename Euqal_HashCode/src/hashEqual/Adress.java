package hashEqual;

public class Adress {

	private String street;
	private int houseNumber;
	private int postCode;
	private String city;
	
	public Adress(String street, int houseNumber, int postCode, String city) {
		this.street = street;
		this.houseNumber = houseNumber;
		this.postCode = postCode;
		this.city = city;
		
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
}
