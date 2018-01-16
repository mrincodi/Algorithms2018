package pinos;

//https://www.interviewbit.com/problems/add-two-numbers-as-lists/

public class AddTwoNumbersAsLists {

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

	public ListNode addTwoNumbers(ListNode A, ListNode B) {
		ListNode result = new ListNode (0);
		ListNode resultPointer = result;
		int carry = 0;

		while ( A != null || B != null){
			int valA = 0;
			int valB = 0;


			if ( A != null){
				valA = A.val;
				A=A.next;
			}

			if ( B != null){
				valB = B.val;
				B=B.next;
			}

			int sum = valA + valB + carry;

			if ( sum > 9 ) {
				carry = 1;
				sum = sum % 10;
			}
			else carry = 0;

			resultPointer.next = new ListNode ( sum );
			resultPointer = resultPointer.next;
		}

		if ( carry == 1)
			resultPointer.next = new ListNode ( 1 );

		return result.next;
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
