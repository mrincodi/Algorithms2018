package pinos;

//https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
//I don't know why this doesn't work for certain test case.


public class MaxSumPathInBinaryTree {

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


	int maxSumPathValue = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode A) {

		maxBranchSum (A);

		return maxSumPathValue;
	}

	public int maxBranchSum(TreeNode A) {
		int result = 0;
		if ( A == null ) return 0;

		if ( A.left == null && A.right == null) {
			result = A.val;
			maxSumPathValue = Math.max (maxSumPathValue, result);
		}
		else if ( A.left != null && A.right == null) {
			result = maxBranchSum (A.left);
			result = Math.max (A.val, A.val + result);
			maxSumPathValue = Math.max (maxSumPathValue, result);

		}
		else if ( A.left == null && A.right != null) {
			result = maxBranchSum (A.right);
			result = Math.max (A.val, A.val + result);
			maxSumPathValue = Math.max (maxSumPathValue, result);
		}
		else {
			int resultLeft  = maxBranchSum (A.left);
			int resultRight = maxBranchSum (A.right);
			result = Math.max (A.val + resultLeft, A.val + resultRight);
			result = Math.max (A.val, result);

			maxSumPathValue = Math.max (A.val + resultLeft + resultRight, result);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
