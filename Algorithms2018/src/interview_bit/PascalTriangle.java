package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.interviewbit.com/problems/pascal-triangle/
// Elementary.

public class PascalTriangle {

	public ArrayList<ArrayList<Integer>> generate(int A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		if ( A <= 0 ) return result;

		result.add ( new ArrayList < Integer > ( Arrays.asList ( 1 ) ) );

		for ( int i = 1; i < A; i++ ){
			ArrayList < Integer > prevLevel = result.get ( i - 1 );

			ArrayList < Integer > nextLevel = new ArrayList < Integer > ();

			nextLevel.add ( 1 );
			for ( int j = 0; j < prevLevel.size() - 1; j++ ){
				nextLevel.add ( prevLevel.get ( j ) + prevLevel.get ( j + 1 ) );
			}

			nextLevel.add ( 1 );
			result.add ( nextLevel );
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
