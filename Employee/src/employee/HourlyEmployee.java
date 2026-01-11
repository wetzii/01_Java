package employee;

public class HourlyEmployee extends Employee {

	private double hourlyRate;
	private int monthlyHours;
	
	public HourlyEmployee(String name, int id, double hourlyRate, int monthlyHours) {
		super(name, id);
		this.monthlyHours = monthlyHours;
	}
	
	//– fügt die übergebenen Stunden den monthlyHours hinzu
	public void addHours(int increaseHours) {
		monthlyHours += increaseHours;
		System.out.printf("Stunden wurden um %d erhöht\n", monthlyHours);
	}
	//Stunden werden auf 0 gesetzt
	public void resetMonthlyHours() {
		monthlyHours = 0;
		System.out.println("Monatliche Stunden wurde auf 0 gesetz!");
	}
	// changeHourlyRate
	// verändert den Stundenlohn 
	public void changeHourlyRate(double newRate) {
			hourlyRate = newRate;
	}
	public void calculateMonthlySalary() {
	    //Monatliches Gehalt wird ausgerechent
		//.2f für 2 Nachkommastellen bei double
	    System.out.printf("Dein Gehalt: %.2f\n", monthlyHours * hourlyRate);
	}
	
}
