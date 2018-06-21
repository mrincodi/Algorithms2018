package leetcode;

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
// Basic binary search problem (as long as I can use an ArrayList).
import java.util.ArrayList;

public class ConvertSortedListToBinarySearchTree {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if ( head == null ) return null;

		// Put linkedist on ArrayList:
		ArrayList < Integer > sortedAL = new ArrayList < Integer > ();
		ListNode listPointer = head;

		while ( listPointer != null ){
			sortedAL.add (listPointer.val );
			listPointer = listPointer.next;
		}

		TreeNode result = sortedListToBST ( sortedAL, 0, sortedAL.size() - 1);

		return result;
	}

	private TreeNode sortedListToBST ( ArrayList < Integer > sortedAL, int start, int end ){
		int midPos = ( start + end ) / 2;

		int val = sortedAL.get ( midPos );

		TreeNode result = new TreeNode ( val );

		if ( start == end ) return result;

		if ( end - start == 1 ){
			result.right = new TreeNode (sortedAL.get(end));
			return result;
		}

		result.left  = sortedListToBST ( sortedAL, start, midPos - 1 );
		result.right = sortedListToBST ( sortedAL, midPos + 1, end   );

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
