package leetcode;

// https://leetcode.com/problems/maximum-binary-tree/description/
// Simple, yet interesting problem.
// 2018-07-11
public class MaximumBinaryTree {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public TreeNode constructMaximumBinaryTree(int[] nums) {

		return constructMaximumBinaryTree(nums, 0, nums.length - 1);
	}

	public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
		if ( start > end ) return null;

		if ( start == end ) {
			return new TreeNode ( nums [ start ] );
		}
		// Locate the maximum number.
		int maxPos = start;
		int maxVal = nums [ start ];
		for ( int i = start + 1; i <= end; i++){
			if ( nums [ i ] > maxVal ) {
				maxVal = nums [ i ];
				maxPos = i;
			}
		}

		TreeNode result = new TreeNode ( maxVal );

		result.left  = constructMaximumBinaryTree ( nums, start, maxPos - 1 );
		result.right = constructMaximumBinaryTree ( nums, maxPos + 1, end );

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
