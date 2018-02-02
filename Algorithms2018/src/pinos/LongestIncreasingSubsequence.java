package pinos;

import java.util.HashMap;
import java.util.List;

//https://www.interviewbit.com/problems/longest-increasing-subsequence/
// OK, but this could be optimized.
// I should have used an array instead of a HashMap.

public class LongestIncreasingSubsequence {

	
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int lis(final List<Integer> A) {
		HashMap <Integer, Integer> sequencesHM = new HashMap <Integer, Integer> ();

		if ( A.size()==1) return 1;

		sequencesHM.put(0,1);
		int maxSeqSoFar = 1;

		for ( int i = 1; i < A.size();i++){
			int val = A.get(i);
			int currentMaxSeqThatIncludesMe = 1;
			for ( int j = i-1; j >= 0; j--){
				if (A.get(j) < val ){
					currentMaxSeqThatIncludesMe = Math.max (currentMaxSeqThatIncludesMe, sequencesHM.get(j)+1);      
				}
			}
			sequencesHM.put (i,currentMaxSeqThatIncludesMe);
			maxSeqSoFar = Math.max (maxSeqSoFar,currentMaxSeqThatIncludesMe);
		}

		return maxSeqSoFar;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
