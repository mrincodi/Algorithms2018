package interview_bit;

// https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
// A classic... with a twist.

public class RepeatingSubSequence {


	public int anytwo(String A) {
		int [][] matrix = new int [A.length()][A.length()];

		for ( int row = 1; row < A.length(); row++ ){
			if (  A.charAt ( 0 ) == A.charAt ( row ) ){
				matrix [ row ][ 0 ] = 1;
				matrix [ 0 ][ row ] = 1;
			}
		}

		for (int row = 1; row < A.length (); row ++ ){
			for (int col = 1; col < A.length (); col ++ ){

				if ( A.charAt (row ) == A.charAt (col) && row != col){
					matrix [ row ][ col ] = 1 + matrix [ row - 1 ][ col - 1 ];
				}
				else {
					matrix [ row ][ col ] = Math.max ( matrix [ row - 1 ][ col ], matrix [ row ][ col - 1 ] );
				}
				if ( matrix [ row ][ col ]  > 1 ) return 1;

			}
		}
		return 0;
	}



	public static void main(String[] args) {
		String s = "aabb";

		int r = new RepeatingSubSequence().anytwo(s);

		System.out.println(r);


	}

}
