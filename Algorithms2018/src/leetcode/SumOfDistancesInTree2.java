package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/submissions/detail/163334110/
// Still takes too long.

public class SumOfDistancesInTree2 {

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
		ArrayList <ArrayList < Integer >> edgesAL = new ArrayList <ArrayList < Integer >> ();

		//Put the links in the arrayList.
		for ( int [] link: edges){
			edgesAL.add(new ArrayList < Integer> (Arrays.asList(link [ 0 ], link [ 1 ])));
		}
		
		while ( !q.isEmpty () ){
			Integer n = q.remove();

			if ( n != null ){
				result += distance;

				// Find neighbors.
				ArrayList < Integer > validNeighbors = findValidNeighbors ( n, edgesAL );

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

	private ArrayList < Integer> findValidNeighbors ( int from, ArrayList < ArrayList < Integer > > edges){
		ArrayList < Integer> result = new ArrayList < Integer> ();

		for ( int i = edges.size() - 1; i >= 0; i++){
			ArrayList < Integer> edge = edges.get(i);
			int a = edge.get(0);
			int b = edge.get(1);
			if ( a == from ) {
				result.add (b);
				edges.remove(i);
				}
			else if ( b == from ){
				result.add (a);
				edges.remove(i);
			}
		}

		return result;
	}


	public static void main(String[] args) {
		int [][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
		
		int[]  r = new SumOfDistancesInTree2().sumOfDistancesInTree(6, edges);
		
		System.out.println (r);

	}

}
