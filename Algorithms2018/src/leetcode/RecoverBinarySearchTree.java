package leetcode;

import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/recover-binary-search-tree/description/
// Took too long for something so easy.
// Note that a solution with O(1) is hard. This is the easy O(n)
// solution. It can be enhanced a bit with a global variable
// indicating that the correction has taken place.
public class RecoverBinarySearchTree {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public void recoverTree(TreeNode root) {
		ArrayList < Integer > inOrder = inOrder (root);  // TODO
		ArrayList < Integer > inOrderOK = new ArrayList < Integer > ( inOrder );
		Collections.sort ( inOrderOK );

		// Find the misplaced elements.
		ArrayList < Integer > diffElements = new ArrayList < Integer > ();
		for ( int i = 0; i < inOrder.size(); i++){
			if ( inOrder.get ( i ) != inOrderOK.get(i)) { 
				diffElements.add ( inOrder.get ( i ) );
			}
		}

		// Correct the tree. The easy way is: just go over all the tree and change 
		// when you see the weird value.

		correctTree (root, diffElements);

	}

	private void correctTree ( TreeNode root, ArrayList < Integer > diffElements ){
		if (root == null) return;
		if  ( root.val == diffElements.get(0)) root.val = diffElements.get(1);
		else if ( root.val == diffElements.get(1)) root.val = diffElements.get(0);
		correctTree ( root.left,  diffElements );
		correctTree ( root.right, diffElements );
	}

	private ArrayList < Integer > inOrder ( TreeNode t ){
		ArrayList < Integer > result = new ArrayList < Integer > ();
		if ( t == null ) return result;

		result=inOrder (t.left);
		result.add(t.val);
		result.addAll (inOrder (t.right));

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
