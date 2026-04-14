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
	    // 1. Identitätsprüfung (Performance-Boost)
	    if (this == other) return true;

	    // 2. Null-Prüfung UND Typ-Prüfung
	    // 'instanceof' gibt praktischerweise false zurück, wenn 'other' null ist!
	    if (!(other instanceof Adress)) return false;

	    // 3. Sicherer Cast
	    Adress otherObj = (Adress) other;

	    // 4. Inhaltsvergleich
	    // Nutze Objects.equals für Strings, falls diese null sein könnten (auch wenn du im Konstruktor prüfst)
	    return this.houseNumber == otherObj.houseNumber
	            && this.postCode == otherObj.postCode
	            && Objects.equals(this.street, otherObj.street)
	            && Objects.equals(this.city, otherObj.city);
	}

	// WICHTIG: Wenn du equals überschreibst, MUSST du auch hashCode überschreiben!
	@Override
	public int hashCode() {
	    return Objects.hash(street, houseNumber, postCode, city);
	}
}
