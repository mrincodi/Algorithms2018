package pinos;

// https://www.interviewbit.com/problems/max-depth-of-binary-tree/
// Easiest problem "evah".

public class MaxDepthOfBinaryTree {

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

	public int maxDepth(TreeNode A) {
		if (A == null) return 0;
		return 1 + Math.max (maxDepth(A.left),maxDepth(A.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
