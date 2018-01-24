package pinos;

// https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
// A hard problem if you don't have some hint.

public class FlattenBinaryTreeToLinkedList {


	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public TreeNode flatten(TreeNode a) {

		TreeNode pointer = a;
		TreeNode pointerLeft = a;

		while (pointer != null){
			if ( pointer.left != null){
				pointerLeft = pointer.left;
				while (pointerLeft.right != null)
					pointerLeft = pointerLeft.right;

				pointerLeft.right = pointer.right;
				pointer.right = pointer.left;
				pointer.left = null;
			}
			pointer = pointer.right;
		}

		return a;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
