package leetcode;

import java.util.ArrayList;

// https://leetcode.com/problems/continuous-subarray-sum/description/
// Cute little problem.
public class ContinuousSubarraySum {

	public boolean checkSubarraySum(int[] nums, int k) {
		if ( nums.length <= 1 ) return false;


		ArrayList <Integer> sums = new ArrayList <Integer> ();

		// Initialize
		for ( int i = 0; i < nums.length - 1; i++){
			int sum = nums[i] + nums [i + 1];

			if ( k == 0){
				if ( sum == 0) return true;
			}
			else{
				if ( sum % k == 0) return true;
			}

			sums.add (sum);
		}

		if ( k == 0 ) return false;

		for ( int i = 2; i < nums.length; i++){
			sums.remove (sums.size() - 1);

			for ( int j = 0; j < sums.size(); j++ ){
				int sum = sums.get(j) + nums[j + i];
				if ( sum % k == 0 ) return true;
				sums.set ( j, sum);
			}
		}

		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
