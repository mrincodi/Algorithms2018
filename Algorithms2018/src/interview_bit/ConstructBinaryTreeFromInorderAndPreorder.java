package interview_bit;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/
//Somewhat verbose answer, but OK.

public class ConstructBinaryTreeFromInorderAndPreorder {

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
	public TreeNode buildTree(ArrayList<Integer> pre, ArrayList<Integer> in) {

		if ( pre.size() == 0 ) return null;

		//Create node with the root.
		TreeNode result = new TreeNode (pre.get(0));

		//Look for node in "in" list.
		int i = 0;
		while (!(in.get(i).equals(pre.get(0)))) i++;

		//Now call the method again for left and right.

		if ( i > 0){
			ArrayList <Integer> leftIn = new ArrayList <Integer> ( in.subList(0, i) );
			ArrayList <Integer> leftPre = new ArrayList  <Integer> ( pre.subList(1, i + 1) );
			result.left = buildTree (leftPre, leftIn);
		}

		if ( i < pre.size() - 1 ){
			ArrayList <Integer> rightIn = new ArrayList  <Integer> ( in.subList(i + 1, in.size() ));
			ArrayList <Integer> rightPre = new ArrayList  <Integer> ( pre.subList(i + 1, pre.size() ));
			result.right = buildTree (rightPre, rightIn);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
