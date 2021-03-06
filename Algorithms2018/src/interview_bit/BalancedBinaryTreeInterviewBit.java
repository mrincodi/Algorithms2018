package interview_bit;

//https://www.interviewbit.com/problems/balanced-binary-tree/
// Simple and elegant.

public class BalancedBinaryTreeInterviewBit {

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

	public int isBalanced(TreeNode A) {
		if ( A == null) return 1;

		int leftHeight = calculateHeight (A.left);
		int rightHeight = calculateHeight (A.right);

		if ( Math.abs (leftHeight - rightHeight) > 1) return 0;

		if (isBalanced (A.left)==0) return 0;
		if (isBalanced (A.right)==0) return 0;

		return 1;
	}

	int calculateHeight ( TreeNode A){
		if ( A == null ) return 0;
		return 1 + Math.max (calculateHeight(A.left), calculateHeight(A.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
