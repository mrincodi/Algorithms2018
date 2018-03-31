package interview_bit;

import java.util.List;
//https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/
//Another easy-peasy.

public class SortedArrayToBST {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public TreeNode sortedArrayToBST(final List<Integer> a) {

		return sortedArrayToBST (a, 0, a.size() - 1 );

	}

	public TreeNode sortedArrayToBST(final List<Integer> a, int inf, int sup) {
		if ( inf > sup ) return null;
		int mid = ( inf + sup ) / 2; 
		TreeNode t = new TreeNode (a.get(mid));

		if ( inf < sup ){
			t.left = sortedArrayToBST(a,inf,mid-1);
			t.right = sortedArrayToBST(a, mid+1, sup);
		}
		return t;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
