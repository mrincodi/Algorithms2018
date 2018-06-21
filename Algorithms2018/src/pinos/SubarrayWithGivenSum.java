package pinos;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithGivenSum {

	public ArrayList < Integer > getSubarrayWithSum ( ArrayList < Integer > nums, int n ){
		ArrayList < Integer > result = new ArrayList < Integer > ();
		if (nums == null || nums.size() == 0 ) return result;

		int start = 0, end = 0;
		int thisSum = nums.get(0);

		while ( end < nums.size() ){
			if ( thisSum == n ){
				result = new ArrayList <Integer> ( java.util.Arrays.asList (start, end ) );
				return result;
			}
			if ( thisSum < n ){
				end++;
				if ( end == nums.size()) return result; //Return empty array.
				thisSum += nums.get(end);
			}
			else {
				if ( start < end ){
					thisSum -= nums.get(start);
					start++;
				}
				else { //start == end
					start++;
					end++;
					if ( end == nums.size()) return result; //Return empty array.
					thisSum = nums.get(start);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList < Integer > nums = new ArrayList < Integer > ( Arrays.asList (1, 4, 0, 0, 3, 10, 5));  
		int n =7;
		System.out.println(new SubarrayWithGivenSum().getSubarrayWithSum(nums, n));
	}

}
