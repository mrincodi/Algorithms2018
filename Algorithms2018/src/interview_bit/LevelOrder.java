package interview_bit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.interviewbit.com/problems/level-order/
// The typical breadth-first search.

public class LevelOrder {

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
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		Queue < TreeNode > q = new LinkedList < TreeNode > ();
		ArrayList < ArrayList  < Integer > > result = new ArrayList < ArrayList  < Integer > > ();  
		if ( A == null ) return result;
		q.add ( A );
		q.add ( null ); // Indicates new level.

		ArrayList < Integer > level = new ArrayList < Integer > ();
		while ( ! q.isEmpty () ){
			TreeNode node = q.remove();
			if ( node == null ){
				result.add ( level );
				level = new ArrayList < Integer > ();

				if ( !q.isEmpty ()){
					q.add ( null );
				}
			}
			else {
				level.add ( node.val );

				if ( node.left != null )
					q.add (node.left );

				if ( node.right != null )
					q.add ( node.right );

			}
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
