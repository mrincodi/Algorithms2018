package interview_bit;

import java.util.HashMap;
// https://www.interviewbit.com/problems/unique-binary-search-trees-ii/
// Easy. Look out in order to prevent infinite loops.

public class UniqueBinarySearchTreesII {

	HashMap <Integer, Integer> numTrees = new HashMap <Integer, Integer> ();
	public int numTrees(int A) {

		if ( A <= 1 ) return 1;

		if ( numTrees.containsKey (A)) return numTrees.get(A);
		int result = 0;

		for ( int i = 0; i <= A - 1; i++){
			result += numTrees (i) * numTrees (A - i - 1);
		}
		numTrees.put (A, result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTreesII ubst2 = new UniqueBinarySearchTreesII();

		int r = 0;
		for ( int i = 1; i < 10; i++){
			System.out.println(ubst2.numTrees(i));
		}
	}

}
