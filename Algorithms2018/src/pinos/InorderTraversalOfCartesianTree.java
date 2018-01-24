package pinos;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/
// Easy, despite the name.

public class InorderTraversalOfCartesianTree {



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

	public class Solution {
		public TreeNode buildTree(ArrayList<Integer> A) {
			//Find largest value.
			int maxPos = 0;
			for ( int i = 1; i < A.size(); i++){
				if (A.get(i) > A.get(maxPos)){
					maxPos = i;
				}
			}
			TreeNode result = new TreeNode (A.get(maxPos));
			if (maxPos != 0 ) result.left = buildTree (new ArrayList <Integer> (A.subList(0, maxPos)));
			if ( maxPos != A.size() -1) result.right = buildTree (new ArrayList <Integer> (A.subList( maxPos+1,A.size())));     

			return result; 

		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
