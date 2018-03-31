package interview_bit;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
// An easy, typical problem. Why was this in the Graphs section?

public class ConvertSortedListToBinarySearchTree {


	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }

		public TreeNode sortedListToBST(ListNode a) {
			if ( a == null) return null;

			ArrayList <Integer> nodes = new  ArrayList <Integer> ();

			while (a != null){
				nodes.add(a.val);
				a=a.next;
			}

			return sortedListToBST (nodes, 0, nodes.size() - 1 );
		}

		TreeNode sortedListToBST(ArrayList <Integer> nodes, int start, int end) {
			if ( start == end){
				return new TreeNode (nodes.get(start));
			}

			if (start == end - 1){
				TreeNode result = new TreeNode(nodes.get(start));
				result.right = new TreeNode(nodes.get(end));
				return result;
			}

			int midPos = (start + end) / 2;
			TreeNode result = new TreeNode(nodes.get(midPos));
			result.left = sortedListToBST( nodes,  start,  midPos - 1);
			result.right = sortedListToBST( nodes,  midPos + 1,  end);

			return result;	    
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
