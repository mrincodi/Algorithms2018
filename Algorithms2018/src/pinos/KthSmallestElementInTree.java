package pinos;

public class KthSmallestElementInTree {





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

	public int kthsmallest(TreeNode A, int B) {

		int numberLeft = size(A.left);

		if ( B - numberLeft == 1) return A.val;
		if (B <= numberLeft) return kthsmallest(A.left, B);
		return kthsmallest (A.right, B - numberLeft - 1);
	}

	int size (TreeNode A){
		if (A == null) return 0;
		return size (A.left) + 1 + size (A.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
