package calc;

public class Logarithm extends Operators {
	
	public Logarithm(int[] nums) {
		super(nums, "Potenzieren");
	}
	
	@Override
	public double calc(int[] nums) {
		check(nums);
		double result = Math.log(nums[0]) / Math.log(nums[1]);
		return result;
	}
	@Override
	public void check(int[] nums) {
		
		if(nums[0]  < 0 ) {
			throw new IllegalArgumentException("Die Basis muss positiv sein!");
		}
		if(nums[0] == 1) {
			throw new IllegalArgumentException("Die Basis soll nicht '1' sein");
		
		}if( nums[1] <= 0){
			throw new IllegalArgumentException("Der Numerus darf nicht negativ sein");
			
		}
	}
	@Override
	public void printResult(int[] nums, double result) {
		System.out.printf("Der Logarythmus von %d  mit der Basis %d = %f.4 \n", nums[1], nums[0],result );
	}

}
