package calc;

public class Power extends Operators {
	
	public Power(int[] nums) {
		super(nums, "Potenzieren");
	}
	@Override
	public double calc(int[] nums) {
		check();
		double result = Math.pow(nums[0] , nums[1]);
		return result;
	}
	@Override
	public void check() {
		
		if(getNum(1) > 20) {
			throw new IllegalArgumentException("Die Potenz sollte kleiner gliech wie 20 sein");
		}
		if(getNum(1) < -20) {
			throw new IllegalArgumentException("Die Potenz sollte Größer gleich wie -20 sein!!");
		}
	}
	@Override
	public void printResult(int[] nums, double result) {
		System.out.printf("Das Ergebnis von %d hoch %d  = %f.4 \n", nums[0], nums[1],result );
	}
}


