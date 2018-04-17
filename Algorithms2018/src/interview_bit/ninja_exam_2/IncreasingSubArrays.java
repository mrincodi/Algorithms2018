package interview_bit.ninja_exam_2;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/increasing-subarrays/?test_id=4810
// Beautiful and a bit tricky.

/**
 * 
 * You are given an array of N positive integers, A1, A2 ,…, AN.

Let’s denote by A[i, j] the subarray Ai, Ai+1 ,…, Aj.

Count pairs (i, j) such that 1 ≤ i ≤ j ≤ N and subarray A[i, j] is increasing. Return the value modulo 109 + 7.

Notes

A subarray A1, A2 ,…, AN is increasing if Ai < Ai+1, for all 1 ≤ i < N.
For example,

A=[4, 5, 1, 2]

All subarrays of size 1 are increasing.

Subarrays A[1, 2], A[3, 4] of size 2 are increasing.

No subarray of size 3 and 4 is increasing.

So, total of 6 subarrays are increasing.

 * @author mrincodi
 *
 */
public class IncreasingSubArrays {

	public int cntInc(ArrayList<Integer> A) {

		int result = A.size();
		long resultL = A.size();

		if ( A.size() <= 1 ) return A.size();

		ArrayList <Integer> previousA = new ArrayList <Integer> ();

		//Creating the first set of pairs.

		for ( int i = 0; i < A.size() - 1; i++ ){
			if (A.get (i) < A.get ( i + 1 )){
				previousA.add (i);
				//System.out.println ("Holaaaa " + i);
			}
		}
		resultL += previousA.size();

		for ( int subArraySize = 3; subArraySize <= A.size(); subArraySize++ ){
			ArrayList <Integer> newA = new ArrayList <Integer> ();

			for ( int i = 0; i < previousA.size() - 1; i = i + 1 ){
				if ( previousA.get(i) + 1 == previousA.get(i + 1) ){
					newA.add(previousA.get(i));
				}
			}

			resultL += newA.size();
			previousA = newA;
		}

		result = (int) (resultL % 1000000007L);
		return result;            

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
