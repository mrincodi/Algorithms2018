package leetcode;

// https://leetcode.com/problems/merge-two-binary-trees/description/
// Shorter version.

public class MergeTwoBinaryTreesShorter {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if ( t1 == null && t2 == null ) return null;
        
        TreeNode result = new TreeNode (0);

        result.val = t2 == null ? t1.val : t1 == null ? t2.val : t1.val + t2.val;
        
        result.left =   t2 == null ? mergeTrees(t1.left, null) : 
                        t1 == null ? mergeTrees(null, t2.left) :
                        mergeTrees(t1.left, t2.left) ;

        result.right =  t2 == null ? mergeTrees(t1.right, null) : 
                        t1 == null ? mergeTrees(null, t2.right) :
                        mergeTrees(t1.right, t2.right) ;

        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
