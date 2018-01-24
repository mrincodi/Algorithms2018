package pinos;

public class SymmetricBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
			left=null;
			right=null;
		}
	}

	public int isSymmetric(TreeNode A) {
		if ( A == null) return 1;
		return isSymmetric (A.left, A.right);
	}

	int isSymmetric(TreeNode A, TreeNode B) {
		if (A == null && B == null) return 1;
		if (A == null && B != null) return 0;
		if (A != null && B == null) return 0;

		if (A.val != B.val) return 0;

		if (isSymmetric (A.left, B.right ) == 0) return 0;
		if (isSymmetric (A.right, B.left ) == 0) return 0;

		return 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
