package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
// 2018-07-20
public class LargestContinuousSequenceZeroSum {

	public ArrayList<Integer> lszero(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		ArrayList<Integer> resultMini = new ArrayList<Integer> ();


		if ( A == null || A.size() == 0 ) return result;
		if ( A.size() == 1){
			if ( A.get ( 0 ) == 0 ) { 
				result.add ( 0 );
			}
			return result;
		}
		int [] sums = new int [ A.size () ];

		sums [ 0 ] = A.get ( 0 );
		if ( A.get ( 0 ) == 0 )
			resultMini = new ArrayList < Integer > ( Arrays.asList ( 0, 0 ));

		for ( int i = 1; i < A.size(); i++ ){
			sums [ i ] = sums [ i  - 1 ] + A.get ( i );
			if ( sums [ i ] == 0 )
				resultMini = new ArrayList < Integer > ( Arrays.asList ( 0, i ));
		}

		for ( int i = 0; i <A.size() - 1; i++ ){
			for ( int j = i + 1; j < A.size(); j++ ){
				sums [ j ] = sums [ j ] - A.get(i);
				if ( sums [ j ] == 0){
					if ( resultMini.size () == 0 || j - ( i + 1 ) > resultMini.get ( 1 ) - resultMini.get ( 0 )){
						resultMini = new ArrayList < Integer > ( Arrays.asList ( i + 1, j ));
					}
				}
			}
		}


		// TODO: Last number by itself. It may be zero.

		if ( resultMini.size() == 0 ) return result;
		result = new ArrayList < Integer> ( A.subList ( resultMini.get(0), resultMini.get(1) + 1 ));
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
