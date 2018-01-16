package pinos;

import java.util.ArrayList;

public class KReverseLinkedList {

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     public int val;
	 *     public ListNode next;
	 *     ListNode(int x) { val = x; next = null; }
	 * }
	 */

	private class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	public ListNode reverseList(ListNode A, int B) {

		ListNode APointer = A;
		ListNode result = new ListNode (0);
		ListNode resultPointer = result;

		while ( APointer != null){
			ArrayList <Integer> helper = new ArrayList <Integer> ();
			for ( int i = 0; i < B; i++){
				helper.add (0,APointer.val);
				APointer = APointer.next;
			}
			for ( int i = 0; i < B; i++){
				resultPointer.next = new ListNode(helper.get(i));
				resultPointer = resultPointer.next;
			}
		}
		result = result.next;
		resultPointer = result;
		while (resultPointer != null){
			System.out.print ( resultPointer.val + " ");
			resultPointer = resultPointer.next;
		}

		return null;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
