package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum2 {

	public int[] twoSum(int[] nums, int target) {

		HashMap <Integer, ArrayList <Integer>> map = new HashMap <Integer, ArrayList <Integer>> ();

		for ( int i = 0; i < nums.length; i++){
			if ( !map.containsKey (nums [ i ] )){
				map.put (nums [ i ], new ArrayList <Integer> ( Arrays.asList ( i ) ) );
			}
			else {
				map.get (nums [ i ]).add ( i );
			}
		}

		int [] result = new int [ 2 ];
		int start = 0, end = nums.length - 1;


		Arrays.sort(nums);

		while (start < end){
			if ( nums [ start ] + nums [ end ] == target){
				result [ 0 ] = map.get( nums [ start ]).get ( 0 );
				if ( nums [ start ] != nums [ end ]){
					result [ 1 ] = map.get ( nums [ end ]).get ( 0 );
				}
				else {
					result [ 1 ] = map.get( nums [ end ]).get ( 1 );
				}
				return result;

			}
			else if ( nums [ start ] + nums [ end ] < target){
				start ++;
			}
			else {
				end--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
