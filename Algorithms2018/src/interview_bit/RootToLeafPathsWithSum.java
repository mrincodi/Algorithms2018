package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/

public class RootToLeafPathsWithSum {

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
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
		if (  A == null ) return null;

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		if ( A.left == null && A.right == null ){
			if ( A.val == B ){
				result.add ( new ArrayList < Integer > ( Arrays.asList ( B ) ) );
			}
			return result;
		}

		if ( A.left != null ){
			result.addAll ( pathSum ( A.left, B - A.val) );
		}

		if ( A.right != null ){
			result.addAll ( pathSum ( A.right, B - A.val) );
		}

		for ( ArrayList<Integer> pr: result ){
			pr.add (0, A.val );
		}

		return result;
	}    



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
