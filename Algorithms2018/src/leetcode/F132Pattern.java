package leetcode;

//https://leetcode.com/problems/132-pattern/description/
// Not my most beautiful code. The value of min is not really used, only its existence.
public class F132Pattern {
	public boolean find132pattern(int[] nums) {
		if ( nums.length <= 2 ) return false;

		for ( int i = 0; i < nums.length - 2; i++ ){
			int num = nums [ i ];
			int min = num;
			int max = num;

			for ( int j = i + 1; j < nums.length ; j++ ){
				int num2 = nums [ j ];

				if ( num2 > num ){
					max = Math.max (max, num2);
					if ( min == num ){
						min = num2;
					}
					else {
						min = Math.min (min, num2);
						if ( num2 < max ) return true;
					}
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int [] nums = {1,2,4,2};
		
		System.out.println (new F132Pattern().find132pattern(nums));

	}

}
