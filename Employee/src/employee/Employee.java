package employee;

public abstract  class Employee {

		private String name;
		private int employeeID;
		
		public Employee(String name, int employeeID) {
			this.name = name;
			this.employeeID = employeeID;
		}
		//changeName
		//– Methode zum Ändern des Namens. Achten Sie dabei darauf, zu checken, wann
		//der Name nicht geändert werden kann!
		public void changeName(String newName) {
			if(newName != null) {
				name = newName;
			}
		}
}
