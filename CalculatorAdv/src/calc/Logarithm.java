package calc;

public class Logarithm extends Operators {
	
	public Logarithm(int[] nums) {
		super(nums, "Logaeythmus");
	}
	
	@Override
	public double calc(int[] nums) {
		check();
		double result = Math.log(nums[0]) / Math.log(nums[1]);
		return result;
	}
	@Override
	public void check() {
		
		if(getNum(0)  < 0 ) {
			throw new IllegalArgumentException("Die Basis muss positiv sein!");
		}
		if(getNum(0)== 1) {
			throw new IllegalArgumentException("Die Basis soll nicht '1' sein");
		
		}if( getNum(1) <= 0){
			throw new IllegalArgumentException("Der Numerus darf nicht negativ sein");
			
		}
	}
	@Override
	public void printResult(int[] nums, double result) {
		System.out.printf("Der Logarythmus von %d  mit der Basis %d = %f.4 \n", nums[1], nums[0],result );
	}

}
