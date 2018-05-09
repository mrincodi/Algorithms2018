package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public List<Integer> largestValues(TreeNode root) {
		ArrayList<Integer> result = new ArrayList <Integer> ();
		largestValues( root, 0, result );
		return result;
	}

	private void largestValues(TreeNode root, int level, ArrayList <Integer> result) {
		if ( root == null ) return;

		if (level == result.size () ){
			result.add (root.val);
		}

		result.set ( level, Math.max ( result.get(level), root.val));

		largestValues ( root.left,  level + 1, result);
		largestValues ( root.right, level + 1, result);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
