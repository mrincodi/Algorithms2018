package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/description/
// Another typical problem.
// 2018-07-17
public class PathSumII {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List  < List  < Integer >> result = new ArrayList  < List  < Integer >> ();

		if ( root == null ) return result;

		if ( root.left == null && root.right == null ){
			if ( sum == root.val ){
				result.add ( new ArrayList < Integer > ( Arrays.asList ( root.val )));
			}
			return result;
		}

		if ( root.left != null ){
			result.addAll ( pathSum ( root.left, sum - root.val ));
		}

		if ( root.right != null ){
			result.addAll ( pathSum ( root.right, sum - root.val ));
		}                   

		for ( List < Integer > al : result ){
			al.add ( 0, root.val );
		}

		return result;             

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
