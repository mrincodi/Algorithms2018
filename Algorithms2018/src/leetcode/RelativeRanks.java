package leetcode;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/relative-ranks/description/
// Hey! Not that stupidly easy after all.
public class RelativeRanks {

	public String[] findRelativeRanks(int[] nums) {
		String[] result = new String[ nums.length ];
		int [] nums2 = Arrays.copyOf ( nums, nums.length );

		Arrays.sort ( nums2);

		// Now, make a hashmap from the numbers to the position
		HashMap < Integer, Integer > numberToPos = new HashMap < Integer, Integer >  ();

		for ( int i = 0; i < nums2.length; i++){
			int n = nums2 [ i ];
			numberToPos.put(n, nums2.length - i - 1);
		}

		for ( int i = 0; i < nums.length; i++){
			int n = nums [ i ];
			int pos = numberToPos.get( n );
			
			String s = "";
			
			if ( pos == 0 ) s =  "Gold Medal";
			else if ( pos == 1 ) s = "Silver Medal";
			else if ( pos == 2 ) s = "Bronze Medal";
			else {
				pos++;
				s = String.valueOf(pos);
			}
			
			result [ i ] = s; 
		}

		return result;

	}
}
