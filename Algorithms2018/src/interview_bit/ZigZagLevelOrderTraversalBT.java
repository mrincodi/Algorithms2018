package interview_bit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/
// Using the queue interface.

public class ZigZagLevelOrderTraversalBT {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
			left=null;
			right=null;
		}
	}

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
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		Queue <TreeNode> queue = new LinkedList<TreeNode> ();

		queue.add (A);
		queue.add (null);

		boolean leftToRight = true;
		ArrayList<Integer> row = new ArrayList<Integer> ();
		while (!queue.isEmpty()){
			TreeNode thisNode = queue.remove();
			if (thisNode == null){
				leftToRight = !leftToRight;

				result.add(row);

				//Reset the row.
				row = new ArrayList<Integer> ();

				if (!queue.isEmpty()) queue.add(null);

			}
			else {
				if (leftToRight) row.add(thisNode.val);
				else row.add (0, thisNode.val);

				if (thisNode.left != null) queue.add (thisNode.left);
				if (thisNode.right != null) queue.add (thisNode.right);

			}

		}

		return result;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
