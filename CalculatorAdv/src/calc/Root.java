package calc;

public class Root extends Operators {
	
	public Root(int[] nums) {
		super(nums, "Wurzel");
	}
	@Override
	public double calc(int[] nums) {
		check();
		double result = Math.pow(nums[0] , 1/nums[1]);
		return result;
	}
	@Override
	public void check() {
		
		if(getNum(0)  == 0) {
			throw new IllegalArgumentException("Es kann nicht die 0. Wurzel sein!");
		}
		if(getNum(1) < 0 && getNum(0) % 2 == 0 ) {
			throw new IllegalArgumentException("Die Diskriminante darf nicht kleiner wie 0 sein wenn a Gerade ist!");
		}
	}
	@Override
	public void printResult(int[] nums, double result) {
		System.out.printf("Das Ergebnis von %d. Wurzel von %d  = %f.4 \n", nums[0], nums[1],result );
	}
}
