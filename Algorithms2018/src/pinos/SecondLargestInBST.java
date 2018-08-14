package pinos;

import interview_bit.TreeNode;

public class SecondLargestInBST {

	int getSecondLargest ( TreeNode t ){

		if ( t == null ) return -1;
		if ( t.left == null && t.right == null ) return -1;

		TreeNode pointer = t;

		if ( pointer.right == null ){
			// Go the left and then all the way to the right.
			pointer = pointer.left;
			while ( pointer.right != null ){
				pointer = pointer.right;
			}
			return pointer.val;
		}

		TreeNode prevPointer = pointer;
		pointer = pointer.right;

		while ( pointer.right != null ){
			prevPointer = pointer;
			pointer = pointer.right;	
		}

		if ( pointer.left == null )
			return prevPointer.val;
		else {
			pointer = pointer.left;
			while ( pointer.right != null ){
				pointer = pointer.right;
			}
			return pointer.val;
		}
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode ( 1000 );
		t.left = new TreeNode ( 10 );
		t.left.right = new TreeNode ( 27 );
		t.left.right.right = new TreeNode ( 47 );
		t.left.right.right.left = new TreeNode ( 45 );
		t.left.right.right.left.right = new TreeNode ( 46 );
		
		//		TreeNode t = new TreeNode ( 14 );
		//		TreeNode t = new TreeNode ( 14 );

		System.out.println (new SecondLargestInBST().getSecondLargest(t));


	}

}
