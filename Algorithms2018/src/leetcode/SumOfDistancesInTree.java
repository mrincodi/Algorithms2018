package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/submissions/detail/163334110/
// Very interesting graph problem. It fails one 
// Leetcode test because of time.
// In order to fix it, I want to remove links
// from parents to children once the links have been
// considered.
// Also, there has to be a relation between a value
// and all the rest, so an optimal code has to be 
// much shorter.

public class SumOfDistancesInTree {

	public int[] sumOfDistancesInTree(int N, int[][] edges) {

		int [] result = new int [ N ];
		for ( int i = 0; i < N; i++){
			result [ i ] = sumDistances ( i, edges );
		}        
		return result;
	}

	public int sumDistances ( int start, int[][] edges){
		Queue <Integer> q = new LinkedList < Integer >();
		HashSet < Integer > already = new HashSet < Integer > ();
		q.add (start);
		q.add (null);
		already.add ( start );
		int result = 0;
		int distance = 0;

		while ( !q.isEmpty () ){
			Integer n = q.remove();

			if ( n != null ){
				result += distance;

				// Find neighbors.
				ArrayList < Integer > validNeighbors = findValidNeighbors ( n, edges, already );

				for ( int m : validNeighbors ){
					q.add (m);
					already.add ( m );
				}

			}
			else {
				distance += 1;
				if ( !q.isEmpty()){
					q.add ( null );
				}
			}

		}

		return result;
	}

	private ArrayList < Integer> findValidNeighbors ( int from, int[][] edges,  HashSet < Integer > already){
		ArrayList < Integer> result = new ArrayList < Integer> ();

		for ( int [] edge: edges){
			int a = edge [ 0 ];
			int b = edge [ 1 ];
			if ( a == from && !already.contains (b)) result.add (b);
			if ( b == from && !already.contains (a)) result.add (a);
		}

		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
