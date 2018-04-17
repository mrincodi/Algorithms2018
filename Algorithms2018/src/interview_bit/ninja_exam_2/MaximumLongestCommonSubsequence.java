package interview_bit.ninja_exam_2;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/maximum-longest-common-subsequence/?test_id=4810

// *** NOT DONE ***

/**
 * 
 * 
 * 
 * Defining substring 
For a string P with characters P1, P2 ,…, Pq, let us denote by P[i, j] the substring Pi, Pi+1 ,…, Pj.

Defining longest common subsequence(LCS) 
A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. LCS(A, B) of 2 sequences A and B is a subsequence, with maximal length, which is common to both the sequences.

Given a string S with small alphabet characters S1, S2 ,…, SN, return an array with two elements. First is the smallest j (1 ≤ j < N) for which LCS(S[1, j], rev(S[j + 1, N])) is maximal and second is the maximal value of LCS(S[1, j], rev(S[j + 1, N])). 
Here, rev(A) denotes reverse of string A.

For example,

S="abba"

LCS(S[1, 1], rev(S[2, 4])) = LCS("a", "abb") = 1
LCS(S[1, 2], rev(S[3, 4])) = LCS("ab", "ab") = 2
LCS(S[1, 3], rev(S[4, 4])) = LCS("abb", "a") = 1

Hence, we return [2, 2].

 * @author mrincodi
 *
 */
public class MaximumLongestCommonSubsequence {

    public ArrayList<Integer> maxLCS(String A) {
		return null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
