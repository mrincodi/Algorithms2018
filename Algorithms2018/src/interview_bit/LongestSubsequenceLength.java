package interview_bit;

import java.util.List;

// https://www.interviewbit.com/problems/length-of-longest-subsequence/
// 2018-07-18
public class LongestSubsequenceLength {
	public int longestSubsequenceLength(final List<Integer> A) {

		if ( A.size() == 0 ) return 0;
		int [] ups = new int [ A.size () ];
		int [] downs = new int [ A.size () ];

		ups [ 0 ] = 1;
		for ( int i = 1; i < A.size (); i++){
			int n = A.get(i);

			int up = 0;
			for ( int j = 0; j < i; j++ ){
				if ( A.get(j) < n ){
					up = Math.max (up, ups [ j ]);
				}
			}
			ups [ i ] = up + 1;
		}


		downs [ downs.length - 1 ] = 1;
		for ( int i = downs.length - 2 ; i >= 0; i--){
			int n = A.get(i);

			int down = 0;
			for ( int j = downs.length - 1; j > i; j-- ){
				if ( A.get(j) < n ){
					down = Math.max (down, downs [ j ]);
				}
			}
			downs[i] = down + 1;

		}        
		// Now, get the best of both worlds.

		int max = 0;
		for ( int i = 0; i < A.size(); i++ ){
			max = Math.max (max, ups [ i ] + downs [ i ] - 1);
		}
		return max;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
