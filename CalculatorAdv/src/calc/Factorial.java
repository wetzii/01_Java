package calc;

public class Factorial extends Operators{

		public  Factorial(int[] nums) {
			 	super(nums, "Prozent Rechnung");
			}
			@Override
			public double calc(int[] nums) {
				check(nums);
				int result = nums[0] ;
				for (int i = nums[0]; i >= nums[1]; i++) {
					result *= nums[2];
				}
				return result;
			}
			@Override
			public void check(int[] nums) {
				if(nums[1] > nums[0]) {	
					throw new IllegalArgumentException("Die 1. Zahl kann nicht größer wie die 2. sein!");
				}
			}
			@Override
			public void printResult(int[] nums, double result) { 
				System.out.printf("%d! = %f.4% \n",nums[0] -  nums[1],result);
				
			}
	}



