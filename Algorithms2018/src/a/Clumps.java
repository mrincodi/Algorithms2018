package a;

import interview_bit.TreeNode;

public class Clumps {

	public int countClumps ( TreeNode t){
		int result = countClumps ( t, 1 );		
		return result;
	}



	private int countClumps(TreeNode t, int n) {
		int result = 0;
		if ( t == null ) return result;

		int clumpsLeft = 0, clumpsRight = 0;
		if (t.left != null ){
			if (t.left.val == t.val){
				n++;
				clumpsLeft = countClumps ( t.left, n) - 1;
			}
			else {
				clumpsLeft = countClumps ( t.left, 1) ;
			}
		}
		if ( t.right != null ){
			if (t.right.val == t.val){
				n++;
				clumpsRight = countClumps ( t.right, n) - 1;
			}
			else {
				clumpsRight = countClumps ( t.right, 1) ;
			}
		}

		if ( n > 1 )
			result = 1;

		result += clumpsLeft;
		result += clumpsRight;

		return result;


	}



	public static void main(String[] args) {
		TreeNode t = new TreeNode ( 4 );
		t.left  = new TreeNode (8);
		t.right = new TreeNode (4);
		t.left.left   = new TreeNode (8);
		t.left.right  = new TreeNode (8);
		t.right.left  = new TreeNode (4);
		t.right.right = new TreeNode (8);

		System.out.println(new Clumps().countClumps(t));


	}

}
