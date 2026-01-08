package employee;

public class HourlyEmployee extends Employee {
	/*
	3. HourlyEmployee
	• Fields
	‣ hourlyRate
	‣ monthlyHours
	• Methods

	‣ resetMonth
	– setzt die monthlyHours zurück
	‣ changeHourlyRate
	– verändert den Stundenlohn – Achten Sie auch hierbei auf korrekte Parameter!
	‣ calculateMonthlySalery
	– berechnet und gibt das Monatsgehalt aus
	*/
	private double hourlyRate;
	private int monthlyHours;
	
	public HourlyEmployee(String name, int id, double hourlyRate, int monthlyHours) {
		super(name, id);
		this.monthlyHours = monthlyHours;
	}
		//	‣ addHours
	//– fügt die übergebenen Stunden den monthlyHours hinzu
	public void addHours(int increaseHours) {
		monthlyHours += increaseHours;
		System.out.printf("Stunden wurden um %d erhöht\n", monthlyHours);
	}
	public void resetMonthlyHours() {
		monthlyHours = 0;
		System.out.println("Monatliche Stunden wurde auf 0 gesetz!");
	}
	//‣ changeHourlyRate
	//– verändert den Stundenlohn – Achten Sie auch hierbei auf korrekte Parameter!
	public void changeHourlyRate(double newRate) {
			hourlyRate = newRate;
	}
	public void calculateMonthlySalary() {
	    // %.2f sorgt dafür, dass das Gehalt mit 2 Nachkommastellen angezeigt wird
	    System.out.printf("Dein Gehalt: %.2f\n", monthlyHours * hourlyRate);
	}
	
}
