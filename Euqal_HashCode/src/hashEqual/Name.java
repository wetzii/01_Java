package hashEqual;

public class Name {

	private String firstname;
	private String lastname;
	
	public Name(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		
	}
	public String getLastname() {
		return lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	@Override
	public boolean equals(Object other) {
//		if(other == this) {
//			return true;
//		}
//		if(other == null) {
//			return false;
//		}
//		if(other.getClass() != this.getClass()) {
//			return false;
//		}
         	Name otherObj = (Name) other;
//			if(!otherObj.getFirstname().equals(this.getFirstname())) {
//			return false;
//		
//			} if(!otherObj.getFirstname().equals(this.getFirstname())) {
//			return false;
//		}
//			return true;
		return otherObj.firstname.equals(this.getFirstname())  && otherObj.equals(this.getFirstname());
	}
	@Override
	public int hashCode() {
		// Formel: hash = hash * multiplier + Fieldwert
		int hash = 67;
		int multiplier = 21;
		hash = hash * multiplier + this.firstname.hashCode() ;
		hash = hash * multiplier + this.lastname.hashCode() ;
		return hash;
	}
}
