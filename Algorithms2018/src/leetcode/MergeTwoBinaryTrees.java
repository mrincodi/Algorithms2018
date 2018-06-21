package leetcode;

// https://leetcode.com/problems/merge-two-binary-trees/description/
// Got it right on the first try! Can be done shorter.
public class MergeTwoBinaryTrees {
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

		if ( t1 != null && t2 != null ){
			result.val = t1.val + t2.val;
			result.left = mergeTrees (t1.left, t2.left);
			result.right = mergeTrees (t1.right, t2.right);

			return result;
		}

		if ( t1 != null && t2 == null ){
			result.val = t1.val;
			result.left = mergeTrees (t1.left, null);
			result.right = mergeTrees (t1.right, null);

			return result;
		}

		if ( t1 == null && t2 != null ){
			result.val = t2.val;
			result.left = mergeTrees (null, t2.left);
			result.right = mergeTrees (null, t2.right);

			return result;
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
