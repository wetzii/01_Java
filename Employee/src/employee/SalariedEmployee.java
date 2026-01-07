package employee;

public class SalariedEmployee extends Employee{

		private int monthlySalaray;
		
		public SalariedEmployee(int monthlySalaray, String name, int id ) {
			super(name, id);
			this.monthlySalaray = monthlySalaray;
			
		}
		/*
		2. SalariedEmployee
		• Fields
		‣ monthlySalary
	
		‣ givenRaise(double percent)
		– monthlySalary wird um den angegebenen Prozentsatz erhöht. Checken Sie auch,
		ob der Parameter korrekte Werte beinhaltet!
		‣ calculateMonthlySalery
		– gibt das Monatsgehalt aus
		*/
		public void givenRaise(double percent) {
			  if(percent > 0) {
				  monthlySalaray *= percent;
			  }else {
				  System.out.println("Du kannst nicht - Prozente bekommen");
			  }
		}
		public int getMonthlySalaray() {
			return monthlySalaray;
		}
}
