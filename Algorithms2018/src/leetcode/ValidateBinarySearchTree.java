package leetcode;

import java.util.ArrayList;

// https://leetcode.com/problems/validate-binary-search-tree/description/
// I already knew this one. ;)
// 2018-07-11

public class ValidateBinarySearchTree {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public boolean isValidBST(TreeNode root) {
		ArrayList < Integer > inOrder = inOrder ( root ); // TODO

		for ( int i = 1; i < inOrder.size(); i++ ){
			if ( inOrder.get ( i ) <= inOrder.get ( i - 1 )) return false;
		}

		return true;
	}

	ArrayList < Integer > inOrder ( TreeNode t ){
		ArrayList < Integer > result = new ArrayList < Integer > ();
		if ( t == null ) return result;
		result = inOrder (t.left);
		result.add (t.val);
		result.addAll(inOrder (t.right));

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
