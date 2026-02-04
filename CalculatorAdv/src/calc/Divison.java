package calc;

public class Divison extends Operators {

	public Divison(int[] nums) {
		super(nums,"Division");
	}
	@Override
	public double calc(int[] nums) {
		check(nums);
		int result = nums[0] / nums[1];
		return result;
	}
	@Override
	public void check(int[] nums) {
		if(nums[1] == 0) {
			throw new IllegalArgumentException("Der Divisor darf nicht 0 sein");
		}
	}
	@Override
	public void printResult(int[] nums, double result) {
		System.out.printf("Das Ergebnis von %d / %d = %f.4 \n",nums[0], nums[1],result);
		
	}
}
