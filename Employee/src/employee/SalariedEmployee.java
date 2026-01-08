package employee;

public class SalariedEmployee extends Employee{

		private int monthlySalaray;
		
		public SalariedEmployee(int monthlySalaray, String name, int id ) {
			super(name, id);
			this.monthlySalaray = monthlySalaray;
			
		}
		
		public void givenRaise(double percent) {
			  if(percent > 0) { 
				  monthlySalaray = ((int)percent /100 +1) * monthlySalaray;
				  System.out.println("Dein Gehalt jetzt : "+monthlySalaray);
			  }else {
				  System.out.println("Du kannst nicht - Prozente bekommen");
			  }
		}
		public int getMonthlySalaray() {
			return monthlySalaray;
		}
		public  void calculateMonthlySalary() {
			System.out.printf("Dein Gehalt: %d", monthlySalaray );
		}
}
