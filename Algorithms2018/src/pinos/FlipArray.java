package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipArray {

	    // DO NOT MODIFY THE LIST. IT IS READ ONLY
	    public int solve(final List<Integer> a) {
	        int n = a.size();
	        int sum = a.stream().mapToInt(Integer::intValue).sum();
	        int half = sum / 2; // target sum is half total
	        int[][] dp = new int[n + 1][half + 1];
	        
	        // initialize no options dp[row] == 0
	        int maxInt = 10001; // sum of all elements will not exceed 10,000
	        // set initial option's output to int max
	        for (int h = 1; h <= half; h++) {
	            dp[0][h] = maxInt;
	        }
	        
	        // iterate from 1 to half sum
	        // decide whether to use option 
	        // (current sum - option value) + 1 < previous option
	        // or not
	        // dp[m + 1] will be updated since [m] may be carrying initial int max
	        for (int h = 1; h <= half; h++) {
	            for (int m = 0; m < n; m++) {
	                // memoize dp[m + 1][h]
	                
	                int now = a.get(m);
	                // sum is greater than current option's value
	                // so we can go back to that (sum - option's value) memoization
	                // and determine if plus one flip is better than 
	                // current carrying calculations
	                if (now <= h && dp[m][h] > dp[m][h - now] + 1) {
	                    dp[m + 1][h] = dp[m][h - now] + 1;
	                } else {
	                    dp[m + 1][h] = dp[m][h]; // carry previous calculation
	                }               
	            }
	        }
	        // utilities.MatrixUtilities.print2DArray(dp);
	        for (int h = half; h >= 0; h--) {
	            if (dp[n][h] != maxInt) {
	                return dp[n][h];
	            }            
	        }
	        
	        return dp[n][0];
	    }

		public static void main(String[] args) {
			//ArrayList < Integer> values = new ArrayList < Integer> (Arrays.asList( 11, 10, 8, 6, 8, 11, 1, 10, 2, 3, 8, 3, 8, 12, 11, 1, 7, 5, 5, 12, 9, 4, 10, 3, 3, 3, 8, 8, 8, 6, 7, 7, 7, 6, 4, 2, 5, 8, 11, 10, 10, 10, 12, 9, 2, 3, 9, 12, 7, 6, 11, 8, 9, 9, 10, 3, 3, 5, 2, 10, 10, 9, 4, 9, 6, 11, 10, 2, 6, 1, 4, 7, 10, 3, 4, 3, 9, 4, 3, 8, 1, 1, 3));
			ArrayList < Integer> values = new ArrayList < Integer> (Arrays.asList(7,9,2,1,5));
			int result = new FlipArray().solve(values);
			System.out.println(result);

		}


}
