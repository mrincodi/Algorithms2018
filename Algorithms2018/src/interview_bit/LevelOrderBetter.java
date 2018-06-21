package interview_bit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.interviewbit.com/problems/level-order/
// A breadth-first search without adding the awkward null.
// Instead I go, well, level by level.

public class LevelOrderBetter {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) {
	 *      val = x;
	 *      left=null;
	 *      right=null;
	 *     }
	 * }
	 */




	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
		Queue < TreeNode > q = new LinkedList < TreeNode > ();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();

		q.add ( a );

		while ( !q.isEmpty () ){
			int n = q.size();
			ArrayList < Integer > level = new ArrayList < Integer >();
			for ( int i = 0; i < n; i++ ){
				TreeNode node = q.remove ();
				if ( node.left  != null ) q.add ( node.left  );
				if ( node.right != null ) q.add ( node.right );

				level.add ( node.val );
			}
			result.add (level );
		}
		return result;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
