package calc;

public class PercentCalc extends Operators{

	public  PercentCalc(int[] nums) {
		 	super(nums, "Prozent Rechnung");
		}
		@Override
		public double calc(int[] nums) {
			check(nums);
			int result = nums[0] / nums[1] * 100;
			return result;
		}
		@Override
		public void check(int[] nums) {
			if(nums[1] == 0) {	
				throw new IllegalArgumentException("Der Grundwert kann nicht 0 sein");
			}
		}
		@Override
		public void printResult(int[] nums, double result) { 
			System.out.printf("%d hat  von %d = %f.4% \n",nums[0], nums[1],result);
			
		}
	}

