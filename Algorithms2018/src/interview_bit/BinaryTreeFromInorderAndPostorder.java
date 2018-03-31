package interview_bit;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/binary-tree-from-inorder-and-postorder/

public class BinaryTreeFromInorderAndPostorder {

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
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> posorder) {
		int rootValue = posorder.get(posorder.size() -1);
		TreeNode result = new TreeNode (rootValue);

		//System.out.println ("Inorder: " + inorder);
		//System.out.println ("Posorder: " + posorder);

		//Look for root in posorder.
		int posRootIninorder = 0;
		while ( inorder.get (posRootIninorder) != rootValue) posRootIninorder++;

		//Left side.
		if ( posRootIninorder > 0 ){
			ArrayList<Integer> leftSideInorder = new ArrayList <Integer> ( inorder.subList(0, posRootIninorder )); 
			ArrayList<Integer> leftSidePosorder = new ArrayList <Integer> ( posorder.subList (0, posRootIninorder )); 
			result.left = buildTree (leftSideInorder, leftSidePosorder);
		}

		//Right side.
		if ( posRootIninorder < inorder.size() -1 ){
			ArrayList<Integer> rightSideInorder = new ArrayList <Integer> ( inorder.subList (posRootIninorder + 1, posorder.size())); 
			ArrayList<Integer> rightSidePosorder = new ArrayList <Integer> ( posorder.subList (posRootIninorder, posorder.size() -1 )); 
			result.right = buildTree (rightSideInorder, rightSidePosorder);
		}

		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
