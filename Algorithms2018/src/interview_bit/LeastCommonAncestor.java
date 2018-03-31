package interview_bit;

// https://www.interviewbit.com/problems/least-common-ancestor/
// Not my most beautiful code.
// For a start, I am checking for the existence of both nodes at every step.
// Also, this could be solved by creating a method that would give an arrayList to a
// Node, and then, looking for the node at which the 2 lists differ: 
// that's the common parent.
public class LeastCommonAncestor {


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

	public int lca(TreeNode A, int B, int C) {
		if ( A.val == B ){
			if ( B == C) return B;
			if ( isInTree (A.left, C) || isInTree (A.right, C)) return B;
			else return -1;
		}
		if ( A.val == C ){
			if ( isInTree (A.left, B) || isInTree (A.right, B)) return C;
			else return -1;
		}

		boolean isInTreeALeftB  = isInTree (A.left,  B);
		boolean isInTreeARightC = isInTree (A.right, C);

		if ( isInTreeALeftB && isInTreeARightC) return A.val;

		boolean isInTreeARightB = isInTree (A.right, B);
		boolean isInTreeALeftC  = isInTree (A.left,  C);

		if ( isInTreeALeftC && isInTreeARightB) return A.val;

		if (!isInTreeALeftB && !isInTreeARightB) return -1;
		if (!isInTreeALeftC && !isInTreeARightC) return -1;

		if (isInTreeALeftB  && isInTreeALeftC ) return lca (A.left,  B, C);
		if (isInTreeARightB && isInTreeARightC) return lca (A.right, B, C);

		return -1;
	}

	boolean isInTree (TreeNode A, int B){
		if (A==null ) return false;

		if (A.val ==B) return true;

		return isInTree (A.left, B) || isInTree(A.right, B);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
