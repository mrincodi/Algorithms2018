package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.interviewbit.com/problems/max-distance/
// My first approach. Takes too long for InterviewBit.

public class MaxDistanceSlow {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int maximumGap(final List<Integer> A) {
		if ( A == null || A.size() == 0 ) return -1;
		int result = 0;
		int prevN = Integer.MAX_VALUE;
		for ( int i = 0; i < A.size() - 1; i++){
			if ( A.size() - i <= result ) break;

			int n = A.get(i);
			if ( n > prevN ) continue;
			for ( int j = A.size() - 1; j > i + result; j-- ){
				if ( A.get( j ) >= A.get ( i )){
					result = j - i;
					break;
				}
			}
			prevN = n;
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList < Integer > A = new ArrayList < Integer > ( Arrays.asList( 34, 8, 10, 3, 2, 80, 30, 33, 1 ));
		int result = new MaxDistanceSlow().maximumGap(A);
		System.out.println ( result );

	}

}
