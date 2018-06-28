package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// https://leetcode.com/problems/minimum-height-trees/description/
// A difficult problem. Not finished.
class MinimumHeightTrees_NOT_FINISHED {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {

		List<Integer> result = new ArrayList <Integer> ();
		if ( n == 1 ) return new ArrayList < Integer > ( Arrays.asList ( 0 ));
		if ( n == 2 ) return new ArrayList < Integer > ( Arrays.asList ( 0, 1 ));

		//Create list of edges.
		ArrayList < Edge > edgesList = new ArrayList < Edge > ();

		for ( int [] pair : edges){
			edgesList.add (new Edge (pair [ 0 ], pair [ 1 ]));
		}

		// Put all the nodes in a hashMap
		HashSet <Integer> nodes = new HashSet <Integer> ();

		for ( int i = 0 ; i < n ; i++ ){
			nodes.add(i);
		}

		// Start by the leaves.
		while (nodes.size() > 2){
			// Go over all the nodes in the list of nodes. If it is a leave, add it to a hashMap "leaves".
			// Then, remove the nodes in "leaves" from the "nodes" hashmap.

			Iterator <Integer> nodeIter = nodes.iterator();

			HashSet <Integer> leaves = new HashSet <Integer> ();

			while ( nodeIter.hasNext ()){
				int node = nodeIter.next();
				if ( isLeaf (node, edgesList)){  
					leaves.add (node);
				}
			}

			// After all the leaves are found, take them out from the HashSet of nodes.
			// Also remove the links!
			Iterator <Integer> leavesIter = leaves.iterator();

			while ( leavesIter.hasNext ()){
				int leaf = leavesIter.next();
				nodes.remove (leaf);
				removeEdgeOfLeaf (leaf, edgesList);
				//	                 for ( int i = 0; i < nodes.size(); i++){

				//	                 }
			}

		}

		Iterator <Integer> nodeIter = nodes.iterator();
		int x = nodeIter.next();
		result.add (x);
		if ( nodeIter.hasNext() ){
			x = nodeIter.next();
			result.add (x);
		}

		return result;
	}

	private void removeEdgeOfLeaf (int leaf, ArrayList < Edge > edgesList){
		for ( int i = 0; i < edgesList.size(); i++ ){
			Edge edge = edgesList.get(i);
			if ( edge.x == leaf || edge.y == leaf){
				edgesList.remove (i);
				return;
			}
		}
	}
	private boolean isLeaf (int node, ArrayList < Edge > edgesList){
		int count = 0;
		for ( int i = 0; i < edgesList.size(); i++ ){
			Edge edge = edgesList.get(i);
			if ( edge.x == node || edge.y == node) count++;
			if ( count > 1 ) return false;
		}
		return true;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

}

class Edge{
	int x;
	int y;
	Edge (int x, int y){this.x=x;this.y=y;}
}

