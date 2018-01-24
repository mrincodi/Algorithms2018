package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.interviewbit.com/problems/length-of-longest-subsequence/
// The fact that I have to look over all the previous nodes for each position (O (n^2) )
// makes me sad. No way to enhance this?

public class LengthOfLongestSubsequence {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int longestSubsequenceLength(final List<Integer> A) {

		if (A.size () <=1) return A.size();
		int [] longestIncreasing = new int [A.size()];
		int [] longestDecreasing = new int [A.size()];

		// Calculate the longest increasing subsequence that ends in each position.

		longestIncreasing[0]=1;

		for ( int i = 1; i <A.size(); i++){
			int MaxSeqSizeSoFar=0;
			for ( int j = 0; j < i; j++){
				if (A.get(j)<A.get(i) && longestIncreasing[j]> MaxSeqSizeSoFar)
					MaxSeqSizeSoFar = longestIncreasing[j];
			}
			longestIncreasing[i]=MaxSeqSizeSoFar+1;
		}

		// Calculate the longest decreasing subsequence that starts in each position.

		longestDecreasing[A.size()-1]=1;

		for ( int i = A.size()-2; i >=0; i--){
			int MaxSeqSizeSoFar=0;
			for ( int j = i+1; j < A.size(); j++){
				if (A.get(j)<A.get(i) && longestDecreasing[j]> MaxSeqSizeSoFar)
					MaxSeqSizeSoFar = longestDecreasing[j];
			}
			longestDecreasing[i]=MaxSeqSizeSoFar+1;
		}

		//Finally, calculate the max value of longestIncreasing[i]+longestIncreasing[i]-1.

		int max = 0;

		for ( int i = 0; i < A.size(); i++){
			max = Math.max (longestIncreasing[i] + longestDecreasing[i] - 1, max);
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList <Integer> A = new ArrayList <Integer> (Arrays.asList(1,2,3,2,1));
		int a = new LengthOfLongestSubsequence().longestSubsequenceLength(A);
		System.out.println(a);
	}

}
