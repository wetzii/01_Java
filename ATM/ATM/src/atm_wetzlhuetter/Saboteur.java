package atm_wetzlhuetter;

public class Saboteur {
	
	private ATM[] atmList = new ATM[10];
	private int currentPos;
	
	public Saboteur() {
		int currentPos = 0;
	}
	public void pushAtmToArray(ATM atm) {
        if (currentPos >= atmList.length) {
        	return; //Muss das hier mit Return machen weil ich fange das ja nicht ab im Constucter von ATM
        }
        atmList[currentPos] = atm;
        currentPos++;
    }
	public void destroyRandAtm() {
        int index = (int)(Math.random() * currentPos);
        while(true) {
	        if (atmList[index] != null) { //Check ob es den ATM überhaupt gibt
	            atmList[index].changeStatus();
	            break;     //Es probiert solange bis es wrklich einen Automaten zerstören kann
        	}
        }
    }
}
