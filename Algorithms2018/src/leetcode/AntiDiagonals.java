package leetcode;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/anti-diagonals/
// Typical, important exercise.
public class AntiDiagonals {

	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();

		int n = A.size();

		for ( int i = 0; i < 2 * n - 1; i++){
			ArrayList<Integer> entry = new ArrayList<Integer> ();
			for ( int j = 0; j <= i; j++ ){
				if (  j < n && i - j < n )
					entry.add ( A.get ( j).get ( i - j ) );
			}
			result.add ( entry );
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
