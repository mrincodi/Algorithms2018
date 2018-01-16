package pinos;
//https://www.interviewbit.com/problems/reverse-link-list-ii/

public class ReverseLinkListII {

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     public int val;
	 *     public ListNode next;
	 *     ListNode(int x) { val = x; next = null; }
	 * }
	 */

	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}


	public ListNode reverseBetween(ListNode A, int m, int n) {

		if ( m == n) return A;

		ListNode beforeM = A;
		if ( m == 1 ) beforeM = null;
		else
			for ( int i = 1; i < m - 1; i++)
				beforeM = beforeM.next;

		ListNode atPosM = A;
		if ( m > 1) atPosM = beforeM.next;

		ListNode prev = atPosM;
		ListNode APointer = atPosM.next;
		ListNode APointerNext = atPosM.next.next;

		for ( int i = m + 1; i <= n; i++){
			APointerNext = APointer.next;
			APointer.next=prev;
			prev = APointer;
			APointer = APointerNext;
		}

		atPosM.next = APointer;

		if ( beforeM != null){
			beforeM.next = prev;
			return A;
		}
		else
			return prev;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
