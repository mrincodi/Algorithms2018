package leetcode;

import java.util.ArrayList;
import java.util.List;

// BinarySearch meets tree traversal. Cool.
// 2018-08-23

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class PrintBinaryTree {
	public List<List<String>> printTree(TreeNode root) {
		List<List<String>> result = new ArrayList < > ();

		if ( root == null ) return result;

		int depth = getDepth ( root ); // TODO.

		int aLSize = 1;
		for ( int i = 1; i < depth; i++ ){
			aLSize = aLSize * 2 + 1;
		}

		for ( int i = 0; i < depth; i++ ){
			ArrayList < String > newEntry = new ArrayList < String > ();

			for ( int j = 0; j < aLSize; j++ ){
				newEntry.add ("");
			}

			result.add ( newEntry );
		}

		fillResult (result,root, 0, 0, aLSize - 1); // TODO

		return result;
	}

	int getDepth ( TreeNode root ){
		if ( root == null ) return 0;
		return 1 + Math.max ( getDepth ( root.left ), getDepth ( root.right ));
	}

	void fillResult (List<List<String>> result, TreeNode root, int level, int leftLimit, int rightLimit){
		if (root == null) return;

		int mid = (rightLimit + leftLimit ) / 2;

		result.get(level).set (mid, root.val + "" );

		fillResult ( result, root.left , level + 1, leftLimit, mid - 1    ); 
		fillResult ( result, root.right, level + 1, mid + 1  , rightLimit ); 
	}
}