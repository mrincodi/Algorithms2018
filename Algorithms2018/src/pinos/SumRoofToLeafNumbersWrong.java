package pinos;

import java.util.ArrayList;

import interview_bit.TreeNode;

// https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
// This doesn't work because sometimes numbers are too long even for Long.parseLong.
// Taking the last x digits doesn't work because % 1003 will give a wrong value
// if I just chop the head of a number.
public class SumRoofToLeafNumbersWrong {

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
	public int sumNumbers(TreeNode A) {
		int result = 0;
		long resultL = 0L;
		if ( A == null) return 0;
		ArrayList <String> strings = getStrings (A);
		for ( String string : strings){
			long numL = Long.parseLong (string) % 1003L;
			resultL = ( resultL + numL ) % 1003L;
		}
		resultL = resultL % 1003L;
		result = (int) resultL;
		return result;
	}

	public ArrayList <String> getStrings (TreeNode A){
		ArrayList <String> result = new ArrayList <String> ();
		ArrayList <String> resultTemp = new ArrayList <String> ();

		if ( A.left == null && A.right == null){
			result.add (A.val + "");
			return result;
		}

		if (A.left != null) {
			resultTemp = getStrings ( A.left );
			for ( String string : resultTemp){
				result.add ( A.val + string + "");
			}
		}

		if (A.right != null) {
			resultTemp = getStrings ( A.right );
			for ( String string : resultTemp){
				result.add ( A.val + string + "");
			}
		}

		return result;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
