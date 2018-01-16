package pinos;

import java.util.List;

/// https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/
// This works but InterviewBit complains regarding efficiency (??).

public class HammingDistanceInterviewBitDoesntLikeIt {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int hammingDistance(final List<Integer> A) {
		java.util.ArrayList < Integer> zeros = new java.util.ArrayList < Integer> ();
		java.util.ArrayList < Integer> ones  = new java.util.ArrayList < Integer> ();

		for ( int i = 0; i < 32; i++){
			zeros.add(0);
			ones.add (0);
		}

		for ( int i = 0; i < A.size(); i++){
			int number = A.get(i);

			for ( int pos = 0; pos < 32; pos++){
				int bit = number%2;
				if ( bit == 0)
					zeros.set (pos, zeros.get(pos) + 1);
				else
					ones.set  (pos, ones.get(pos)  + 1);

				number = number >> 1;
			}
		}

		long resultL = 0;
		for ( int i = 0; i < 32; i++){
			resultL += (zeros.get(i) * ones.get ( i ));
		}
		resultL = (resultL * 2);

		return (int) (resultL % 1000000007);
	}

}
