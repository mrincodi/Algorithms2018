package pinos;

import java.util.List;

//https://www.interviewbit.com/problems/longest-arithmetic-progression/
//This is the O(n(3) solution.
// This can be enhanced in several ways:
// - When I get to a value, I could have a hashset with all the differences
// from previous elements to that element. Then, when I compare this element to
// the others forward, I can ignore them if the difference if it is in the hashset.
// - I could have an array of hashsets. Key: differences between this element and all the 
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

public class LongestArithmeticProgression {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int solve(final List<Integer> A) {

		//TODO: Enhance: we do not need to go to the last element
		//if we already have a sequence greater than 1.
		int  longestSeq = 0;

		if (A.size() <=2 )return A.size();

		for ( int i = 0; i < A.size(); i++){
			for ( int j = i+1; j<A.size(); j++){
				int difference = A.get(j)-A.get(i);
				int currentVal = A.get(j);
				int currentSeqCount = 2;
				int currentSeqCountMax = 0;
				for ( int k = j + 1; k < A.size();k++){
					if ( A.get(k) - currentVal == difference){
						currentSeqCount++;
						currentVal=A.get(k);
					}
				}
				longestSeq =Math.max (currentSeqCount,longestSeq);
			}
		}

		return longestSeq;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
