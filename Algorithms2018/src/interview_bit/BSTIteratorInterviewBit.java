package interview_bit;

import java.util.Stack;

// https://www.interviewbit.com/problems/bst-iterator/
// An interesting solution, using a stack.

public class BSTIteratorInterviewBit {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	private Stack<TreeNode> stack;

	public BSTIteratorInterviewBit(TreeNode root) {
		stack = new Stack<>();
		TreeNode node = root;
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {

		if (!hasNext()) {
			return -1;
		}

		TreeNode node;
		node = stack.pop();
		int val = node.val;

		node = node.right;
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		return val;

	}


	/**
	 * Your Solution will be called like this:
	 * Solution i = new Solution(root);
	 * while (i.hasNext()) System.out.print(i.next());
	 */


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
