package interview_bit;

import java.util.List;

// https://www.interviewbit.com/problems/max-product-subarray/
// Wow, I got it on the first try!
// 2018-08-02
public class MaxProductSubarray {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int maxProduct(final List<Integer> A) {

		if (A.size() == 1 ) return A.get(0);

		int maxSoFar = A.get(0);
		int prevMin = A.get(0);
		int prevMax = A.get(0);

		for ( int i = 1; i < A.size(); i++ ){
			int n = A.get(i);

			int newMin, newMax;

			int nTimesPrevMin = n * prevMin;
			int nTimesPrevMax= n * prevMax;

			newMin = Math.min (nTimesPrevMin, nTimesPrevMax);
			newMin = Math.min (newMin, n);
			newMax = Math.max (nTimesPrevMin, nTimesPrevMax);
			newMax = Math.max (newMax, n);

			maxSoFar = Math.max ( maxSoFar, newMax );

			prevMin = newMin;
			prevMax = newMax;

		}

		return maxSoFar;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
