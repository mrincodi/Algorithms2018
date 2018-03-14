package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/two-sum/description/
// Too verbose! Solution could be found before running over all the array.

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		HashMap <Integer, ArrayList<Integer>> positions= new HashMap <Integer, ArrayList <Integer>>();

		for ( int i = 0; i < nums.length; i++){
			if ( positions.containsKey (nums[i]))
				positions.get(nums[i]).add(i);
			else
				positions.put (nums[i], new ArrayList <Integer> ( Arrays.asList (i)));
		}

		Arrays.sort (nums);

		int head = 0;
		int tail = nums.length - 1;

		while (true){
			int sum = nums[head] + nums[tail];

			if (sum == target) {
				int [] result = new int [ 2 ];
				if ( nums[head] == nums[tail]){
					result[0] = positions.get(nums[head]).get(0);
					result[1] = positions.get(nums[head]).get(1);
					return result;
				}
				else {
					result[0]=positions.get(nums[head]).get(0);
					result[1]=positions.get(nums[tail]).get(0);
					return result;  
				}
			}
			if ( sum < target ) head++;
			else tail--;
		}
		//return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
