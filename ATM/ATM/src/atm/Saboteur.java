package atm;

public class Saboteur {
	
	private ATM[] atmList = new ATM[10];
	private int currentPos;
	
	public Saboteur() {
		int currentPos = 0;
	}
	public void pushAtmToArray(ATM atm){
	  if(atmList.length < currentPos) {
		  return; //Muss da jetzt mir return arbeiten weil ich kein Exceptions handlen kann in der anderen KLasse
	  }
		atmList[currentPos] = atm; 
		currentPos ++;
	}
}
