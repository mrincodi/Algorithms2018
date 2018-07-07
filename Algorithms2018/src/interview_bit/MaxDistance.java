package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.interviewbit.com/problems/max-distance/
// WOW, this is a CRAZY problem with a very nice linear approach
// with two auxiliary arrays.
// I think I could make it more efficient space and time-wise, as the
// arrays repeat lots of values.

public class MaxDistance {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int maximumGap(final List<Integer> A) {
		if ( A == null || A.size() == 0 ) return -1;
		int result = 0;

		// Create two arrays (or, even better, two "intelligent" arrays).
		int [] mins = new int [ A.size()];
		int [] maxs = new int [ A.size()];

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for ( int i = 0; i < A.size(); i++ ){
			min = Math.min(A.get(i), min);
			mins [ i ] = min;
			
			max = Math.max(A.get(maxs.length - 1 - i), max);
			maxs [ maxs.length - 1 - i ] = max;
		}

		// Now go over the arrays!
		int iMins = 0, iMaxs = 0;
		while ( iMins < A.size() && iMaxs < A.size() ){
			min = mins[iMins];
			max = maxs[iMaxs];
			if ( min > max ) iMins++;
			else {
				//Go to the right on maxs all you can, until get to a value that
				// is smaller than min.
				if ( iMins <= iMaxs )
					result = Math.max(iMaxs - iMins, result);
				iMaxs++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		ArrayList < Integer > A = new ArrayList < Integer > ( Arrays.asList( 34, 8, 10, 3, 2, 80, 30, 33, 1 ));
		int result = new MaxDistance().maximumGap(A);
		System.out.println ( result );

	}

}
