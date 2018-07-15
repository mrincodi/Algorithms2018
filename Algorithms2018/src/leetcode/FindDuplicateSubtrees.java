package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/find-duplicate-subtrees/description/
// My implementation. IMPORTANT. New way of serializing binary trees!!
public class FindDuplicateSubtrees{
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	HashMap <String, Integer> subtrees = new HashMap < String, Integer >  ();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode> ();

		if ( root == null ) return result;

		// Generate current tree.
		String inOrder = inOrder ( root );

		// If it is in the hashMap, save it!
		if ( subtrees.containsKey ( inOrder ) && subtrees.get ( inOrder ) == 1){
			result.add (root);
		}
		subtrees.put ( inOrder, subtrees.getOrDefault ( inOrder, 0) + 1);

		//Run the command in the subtrees.
		result.addAll ( findDuplicateSubtrees ( root.left) );
		result.addAll ( findDuplicateSubtrees ( root.right) );

		return result;

	}

	public String inOrder ( TreeNode root ){
		if ( root == null ) return "";

		String result = "(" + inOrder ( root.left ) + root.val + inOrder ( root.right ) + ")";

		return result;
	}


	// Driver code
	public static void main(String args[])
	{
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(4);
		root.right.right = new TreeNode(4);
		FindDuplicateSubtrees fds = new FindDuplicateSubtrees();
		List<TreeNode> result = fds.findDuplicateSubtrees(root);
		
		for ( int i = 0; i < result.size(); i++ ){
			System.out.println (result.get(i).val);
			
		}
		
	}





}
