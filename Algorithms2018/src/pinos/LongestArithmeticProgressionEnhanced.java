package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://www.interviewbit.com/problems/longest-arithmetic-progression/
//This is the O(n(2) solution., with  an array of hashsets.
// Key: differences between this element and all the 
// previous ones. Values: number of elements with that difference. So at each position I
// have to look at the differences between this element and the previous ones. If
// in the hashmap for the previous one there was a key with that difference, the
// value for our element is 1 + that value.
// Example
// 9     4       7       2      10
// 
//       -5, 2   3, 2   -5, 2  -8, 2
//              -2, 2   -2, 2  -3, 3 <= Solution
//                      -7, 2   6, 2
//                              1, 2

public class LongestArithmeticProgressionEnhanced {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int solve(final List<Integer> A) {

		if (A.size() <= 2 ) return A.size();

		ArrayList <HashMap <Integer, Integer>> bestProgressions = new ArrayList <HashMap <Integer, Integer>> ();
		int maxSeqSoFar = 2;
		bestProgressions.add (new HashMap <Integer, Integer>());
		for ( int i = 1; i < A.size(); i++){
			bestProgressions.add( new HashMap <Integer, Integer>());
			for ( int j = i-1; j>=0; j--){
				int diff = A.get(j)-A.get(i);

				if (!bestProgressions.get(i).containsKey(diff)){
					if (bestProgressions.get(j).containsKey(diff)){
						bestProgressions.get(i).put(diff, bestProgressions.get(j).get(diff)+1);
						maxSeqSoFar = Math.max(maxSeqSoFar, bestProgressions.get(i).get(diff));
					}
					else 
						bestProgressions.get(i).put(diff, 2);
				}
			}
		}
		return maxSeqSoFar;
	}

	public static void main(String[] args) {
		ArrayList <Integer> A = new ArrayList <Integer> ( Arrays.asList(1,1,1,1,1,1,1));
		int num = new LongestArithmeticProgressionEnhanced().solve(A);
		System.out.println(num);

	}

}
