package interv.deedni;


import java.io.*;
import java.util.*;

public class Solution {


	// For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

	// 1   2   4
	//  \ /   / \     
	//   3   5   8   
	//    \ / \   \
	//     6   7   9

	// Write a function that, for a given individual in our dataset, returns their earliest known ancestor -- the one at the farthest distance from the input individual. If there is more than one ancestor tied for “earliest”, return any one of them. If the input individual has no parents, the function should return null (or -1).

	// 8 => 4
	// 7 => 4
	// 6 => 1, 2, or 4




	public static void main(String[] args) {
		int[][] parentChildPairs = new int[][] {
			{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
			{4, 5}, {4, 8}, {8, 9}, {6,10}
		};

		//	     ArrayList < ArrayList < Integer > > result = individuals ( parentChildPairs );


		//	     System.out.print (result);

		//	     boolean result = shareGrandParent ( 8, 10, parentChildPairs );

		//	     System.out.println ( result );

		int result = getOldestAncestor ( 10, parentChildPairs );

		System.out.println ( result );

	}

	public static ArrayList < ArrayList < Integer > > individuals ( int [] [] pairs ){

		ArrayList < ArrayList < Integer > > result = new ArrayList < ArrayList < Integer > > ();
		result.add ( new ArrayList < Integer > () );
		result.add ( new ArrayList < Integer > () );


		HashSet < Integer > elements = new HashSet < Integer > ();

		// Fill out the set.

		for ( int [] pair : pairs ){
			elements.add ( pair [ 0 ] );
			elements.add ( pair [ 1 ] );
		}

		Iterator < Integer > iter = elements.iterator();

		while ( iter.hasNext() ){
			int n = iter.next ();
			int numParents = 0;
			for ( int [] pair : pairs ){
				if ( pair [ 1 ] == n ) numParents++;
			}

			if ( numParents == 0 ){
				result.get(0).add(n);
			}

			if ( numParents == 1 ){
				result.get(1).add(n);
			}
		}

		return result;
	}

	public static boolean shareGrandParent ( int x, int y, int [] [] pairs ){
		HashSet < Integer> ancestorsX = getAncestors ( x, pairs );
		HashSet < Integer> ancestorsY = getAncestors ( y, pairs );

		Iterator < Integer > iter = ancestorsX.iterator();

		while ( iter.hasNext ()){
			int n = iter.next();
			if ( ancestorsY.contains ( n )) {
				return true;
			}
		}
		return false;
	}

	public static HashSet < Integer> getAncestors ( int x, int [] [] pairs ){
		HashSet < Integer> result = new HashSet < Integer> ();

		// Get initial set of parents.
		HashSet < Integer> parents = getParents ( x, pairs ); // TODO

		result.addAll ( parents );


		while (parents.size () != 0 ){
			HashSet < Integer> prevParents = (HashSet < Integer> ) parents.clone();
			parents = new HashSet < Integer> ();

			Iterator <Integer> iter = prevParents.iterator ();

			while ( iter.hasNext ()){
				int n = iter.next();
				parents.addAll ( getParents ( n, pairs ));
			}
			result.addAll ( parents );

		}

		return result;
	}

	public static HashSet < Integer> getParents ( int x, int [] [] pairs ){
		HashSet < Integer> result = new HashSet < Integer> ();

		for ( int [] pair: pairs ){
			if ( pair [ 1 ] == x ){
				result.add (pair [ 0 ]);
			}
		}
		return result;
	}

	public static int getOldestAncestor ( int x, int [] [] pairs ){
		int result = -1;

		HashSet < Integer> parents = getParents (x, pairs );

		if ( parents.size() == 0 ) return -1;

		HashSet < Integer> resultSet = parents;

		while (parents.size () != 0 ){
			HashSet < Integer> prevParents = (HashSet < Integer> ) parents.clone();
			parents = new HashSet < Integer> ();

			Iterator <Integer> iter = prevParents.iterator ();

			while ( iter.hasNext ()){
				int n = iter.next();
				parents.addAll ( getParents ( n, pairs ));
			}

			if ( parents.size () == 0 ){
				Iterator <Integer> iter2 = prevParents.iterator();
				return iter2.next();
			}

		}

		return -1;
	}

}

