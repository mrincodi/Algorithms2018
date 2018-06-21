package interview_bit;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/bst-iterator/
// The basic (and good) solution. A different (better?) solution involves a stack.

public class BSTIterator {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	private ArrayList < Integer > inOrder;
	private int index;

	public BSTIterator(TreeNode root) {
		inOrder = populateArray ( root );
		index = 0;
	}

	private ArrayList < Integer > populateArray ( TreeNode root ){
		ArrayList < Integer > result = new ArrayList < Integer > ();

		if ( root == null ) return result;

		result.addAll ( populateArray ( root.left ) );
		result.add (root.val);
		result.addAll ( populateArray ( root.right ) );

		return result;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return index < inOrder.size ();
	}

	/** @return the next smallest number */
	public int next() {
		int result = inOrder.get(index);
		index++;
		return result;
	}


	/**
	 * Your Solution will be called like this:
	 * Solution i = new Solution(root);
	 * while (i.hasNext()) System.out.print(i.next());
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
