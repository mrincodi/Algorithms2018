package pinos;

import interview_bit.TreeNode;

// https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
// Yeah, so they calculated the numbers in the leaves, not in the root,
// and kept multiplying by 10 and adding the value in the node.

public class SumRoofToLeafNumbersInterviewBit {



	int dfs(TreeNode node, int sum) {
		if (node == null) return 0;
		sum = (sum * 10 + node.val) % 1003;
		if (node.left == null && node.right == null) {
			return sum;
		}
		return (dfs(node.left, sum) + dfs(node.right, sum)) % 1003;
	}

	public int sumNumbers(TreeNode A) {
		return dfs(A, 0);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
