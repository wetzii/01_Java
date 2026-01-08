package employee;

public class RunCode {
	public static void main(String[] args) {
	HourlyEmployee hourlyEmployee = new HourlyEmployee("Hausberg,", 3, 19.2,120);
	
			hourlyEmployee.changeName("Max Danninger");
			hourlyEmployee.addHours(9);
			hourlyEmployee.changeHourlyRate(20.4);
			hourlyEmployee.calculateMonthlySalary();
		
					
			System.out.println("----------------------------------------------------------");
			
			SalariedEmployee salariedEmployee = new SalariedEmployee(2900, "Nüs", 9);
	
			salariedEmployee.changeName("Sigma");
			salariedEmployee.givenRaise(25);
			salariedEmployee.calculateMonthlySalary();
	}
}
