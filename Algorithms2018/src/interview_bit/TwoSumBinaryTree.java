package interview_bit;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/2sum-binary-tree/
// Stupidly easy (after the hint).

public class TwoSumBinaryTree {

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
	public int t2Sum(TreeNode T, int target) {
		if ( T == null ) return 0;

		//Just do inOrder and then two pointers.
		ArrayList <Integer> sorted = inOrder (T);

		int i = 0, j = sorted.size() - 1;

		while ( i < j ){
			int sum = sorted.get(i) + sorted.get(j);
			if (sum == target ) return 1;
			if ( sum < target ) i++;
			else j--;
		}
		return 0;
	}
	public ArrayList <Integer> inOrder ( TreeNode T ){

		ArrayList <Integer>  result = new ArrayList <Integer> ();
		if ( T == null ) return result;
		result.addAll (inOrder (T.left));
		result.add(T.val);
		result.addAll (inOrder (T.right));
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
