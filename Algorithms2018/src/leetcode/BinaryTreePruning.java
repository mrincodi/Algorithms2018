package leetcode;

//https://leetcode.com/problems/binary-tree-pruning/description/
//Simple and beautiful.

public class BinaryTreePruning {

	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	    public TreeNode pruneTree(TreeNode root) {
	        if ( root == null ) return null;
	        
	        root.left = pruneTree (root.left);
	        root.right = pruneTree (root.right);
	        
	        if ( root.val == 0 && root.left == null && root.right == null ) return null;
	        
	        return root;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
