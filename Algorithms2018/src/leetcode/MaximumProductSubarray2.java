package leetcode;

// https://leetcode.com/problems/maximum-product-subarray/description/
// Beautifully crafted.
public class MaximumProductSubarray2 {

	public int maxProduct(int[] nums) {
		if ( nums.length == 1 ) return nums[0];
		int min = nums [ 0 ];   // Min. including last position.
		int max = nums [ 0 ];   // Max. including last position.
		int maxSoFar = max;

		for ( int i = 1; i < nums.length; i++){
			int num = nums [ i ];

			java.util.TreeSet <Integer > ts = new java.util.TreeSet <Integer > ();

			ts.add (num);
			ts.add (num * min);
			ts.add (num * max);

			min = ts.first();
			max = ts.last();

			if ( max > maxSoFar ){
				maxSoFar = max;
			}
		}

		return maxSoFar;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
