package pinos;

//https://www.interviewbit.com/problems/next-greater-number-bst/
// This works, but is very wordy!
// InterviewBit's solution goes down the tree until b is found,
// but keeping a pointer to the node found with the smallest value greater than b.


public class NextGreaterNumberBST {
	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode getSuccessor(TreeNode a, int b) {
		TreeNode root = a;
		TreeNode pointer = a;

		while (root != null){
			if (root.val == b){
				// Return node to the right and all the way to the left.
				if ( root.right == null) return null; //It's the largest value in the tree.

				pointer = root.right;
				while (pointer.left != null){
					pointer = pointer.left;
				}
				return pointer;
			}
			else if (root.val < b){
				root = root.right; //The value is there, so it is never going to be null.
			}

			else {
				if (root.left.val > b) root = root.left;
				else if (root.left.val == b){
					if (root.left.right == null) return root;
					else root = root.left;
				}
				else {  //root.left.val < b.
					pointer = root.left;
					while (pointer.val < b) pointer = pointer.right;
					if ( pointer.val == b){
						if (pointer.right == null) return root;
						else root = pointer;
					}
					else //pointer.val > b 
						root = pointer; // It must be this node or one to the left of pointer.
				}
			}
		}

		return null;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
