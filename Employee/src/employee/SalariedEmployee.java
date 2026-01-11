package employee;

public class SalariedEmployee extends Employee{

		private int monthlySalaray;
		
		public SalariedEmployee(int monthlySalaray, String name, int id ) {
			super(name, id);
			this.monthlySalaray = monthlySalaray;
			
		}
		
		//Grhaltserhöhung mit Prozent
		public void givenRaise(double percent) {
			  if(percent > 0) { //Check ob die Gehaltserhöhung größer wie 0 ist
				  monthlySalaray = ((int)percent /100 +1) * monthlySalaray;
				  System.out.println("Dein Gehalt jetzt : "+monthlySalaray);
			  }else {
				  System.out.println("Du kannst nicht - Prozente bekommen");
			  }
		}
		
		public int getMonthlySalaray() { // Monatliches Gehalt wird zurückgegeben
			return monthlySalaray;
		}
		public void calculateMonthlySalary() {
			//Monatsgehalt wird ausgerechnet --> in diesem Fall nur gepprintet
			//Rechnung wird gleich nach Gehaltserhöhung durgeführt
			System.out.printf("Dein Gehalt: %d", monthlySalaray );
		}
}
