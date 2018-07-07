package interview_bit;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
// Typical solution, although this can be done in O(n) for space and time (!!).
public class KthRowOfPascalsTriangle {

	public ArrayList<Integer> getRow(int A) {

		ArrayList<Integer> prevResult = new  ArrayList<Integer> ();
		prevResult.add (1);
		if ( A == 0 ) return prevResult;
		ArrayList<Integer> result = new  ArrayList<Integer> ();

		for ( int i = 1; i <= A; i++ ){
			result = new  ArrayList<Integer> ();
			result.add (1);
			for ( int j = 0; j < prevResult.size() - 1; j++ ){
				result.add ( prevResult.get ( j ) + prevResult.get ( j + 1) );
			}
			result.add ( 1 );
			prevResult = result;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
