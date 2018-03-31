package interview_bit;


//https://www.interviewbit.com/problems/next-greater-number-bst/
// This works, but is very wordy!
// InterviewBit's solution goes down the tree until b is found,
// but keeping a pointer to the node found with the smallest value greater than b.


public class NextGreaterNumberBSTInterviewBit {
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
		TreeNode min = new TreeNode(Integer.MAX_VALUE);

		if(a == null)
			return null;

		while(a.val != b){
			if(a.val > b){
				if(min.val > a.val)
					min = a;
				a = a.left;
			}
			else
				a = a.right;

		}

		if(a.right == null){
			if(min.val == Integer.MAX_VALUE)
				return null;

			return min;
		}

		a = a.right;
		while(a.left != null)
			a = a.left;
		return a;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
