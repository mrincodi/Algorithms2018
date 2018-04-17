package interview_bit;

// https://www.interviewbit.com/problems/path-sum/
// Not hard. Just be careful to make sure if results are to be given when you get to a leaf
// or when you get to any null value (big difference).

public class PathSum {
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
	public int hasPathSum(TreeNode A, int B) {

		// if ( A == null){
		//     return B==0?1:0;
		// }

		if ( A.left == null && A.right == null ){
			return B == A.val?1:0;
		}

		if ( A.left != null && hasPathSum ( A.left, B - A.val ) == 1 ){
			return 1;
		}

		if ( A.right != null && hasPathSum ( A.right, B - A.val ) == 1 ){
			return 1;
		}

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
