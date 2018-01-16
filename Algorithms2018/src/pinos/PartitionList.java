package pinos;

//https://www.interviewbit.com/problems/partition-list/

public class PartitionList {


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

	public ListNode partition(ListNode A, int B) {

		if ( B <= 0 ) return A;

		ListNode smallerThan = new ListNode (0);
		ListNode greaterOrEqualThan = new ListNode (0);
		ListNode smallerThanPointer = smallerThan;
		ListNode greaterOrEqualThanPointer = greaterOrEqualThan;


		while ( A != null){
			int val = A.val;

			if ( val < B ){
				smallerThanPointer.next = new ListNode (val);
				smallerThanPointer=smallerThanPointer.next;
			}
			else {
				greaterOrEqualThanPointer.next = new ListNode (val);
				greaterOrEqualThanPointer = greaterOrEqualThanPointer.next;
			}
			A=A.next;
		}

		//Remove the initial zeros.
		smallerThan = smallerThan.next;
		greaterOrEqualThan = greaterOrEqualThan.next;

		if ( smallerThan == null) return greaterOrEqualThan;

		smallerThanPointer.next = greaterOrEqualThan;
		return smallerThan;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
