package calc;

public abstract class  Operators {

	private int[] nums;
	private String operator;
	
	public Operators(int nums[], String operator) {
		this.nums = nums;
		this.operator = operator;
		
	}
	public int[]  getNums() {
		return nums ;
	}
	public String getName() {
		return operator;
	}
	public int getNum(int i) {
		return nums[i];
	}

	public abstract double calc(int[] nums);
	public abstract void printResult(int[] nums, double result);
	public abstract void check();
}
