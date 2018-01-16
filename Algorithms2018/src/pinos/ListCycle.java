package pinos;

// No hashes!
// https://www.interviewbit.com/problems/list-cycle/
// I could have started a pointer at the meeting point + 1
// And they would have met at the beginning of the cycle.
// See other solutions for this.

public class ListCycle {

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

	public ListNode detectCycle(ListNode a) {
		if ( a == null ) return null;

		ListNode p1 = a;
		ListNode p2 = a;

		do {
			p1 = p1.next;

			p2 = p2.next;
			if (p2 == null) return null;
			p2 = p2.next;
			if (p2 == null) return null;
		} while (p1 != p2);

		// Get the size of the cycle.
		int loopSize = 1;
		p1 = p1.next;
		while (p1 != p2){
			p1 = p1.next;
			loopSize++;
		}

		//Finally, get to the starting point.
		p1 = a;
		p2 = a;
		for ( int i = 0; i < loopSize; i++){
			p2 = p2.next;
		}
		while (p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
