package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/description/
// The eternal problem
// 2018-08-19
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if ( nums.length < 3 ) return result;

		Arrays.sort ( nums );

		int lastA = 0, lastB = 0, lastC = 0;
		for ( int i = 0; i < nums.length - 2; i++ ){
			int val = nums [ i ];

			if ( i == 0 || val != nums [ i - 1 ]){
				int j = i + 1, k = nums.length - 1;

				while ( j < k ){
					int sum = nums [ j ] + nums [ k ];

					if ( sum > -val ){
						k--;
					}
					else if ( sum < -val){
						j++;
					}
					else {

						if ( result.size () == 0 || 
								( nums [ i ] != lastA ||
								nums [ j ] != lastB ||
								nums [ k ] != lastC )){
							result.add ( new ArrayList < Integer > ( Arrays.asList (nums [ i ], nums [ j ], nums [ k ])));
							lastA = nums [ i ];
							lastB = nums [ j ];
							lastC = nums [ k ];
						}
						j++;
						k--;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
