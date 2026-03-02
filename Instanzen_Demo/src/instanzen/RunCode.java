package instanzen;

public class RunCode {
	
	public static void main(String[] args) {
			Person[] persons = new Person[2];
			
			persons[0] = new Person("Matthias Oh Nein");
			persons[1] = new Students("Cora", 100029);
			
			if(persons[1] instanceof Students) {
				//Variante a: 
				Students s = (Students) persons[1];
				s.getMatNr();
				
				//Variante b: 
				((Students)persons[1]).getMatNr();
			}
			
		}
}
