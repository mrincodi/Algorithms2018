package leetcode;

public class AddTwoNumbers {
//https://leetcode.com/problems/add-two-numbers/description/
//Easy.

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;

		if ( p2 == null || (p2.val == 0 && p2.next == null)) return p1;
		if ( p1 == null || (p1.val == 0 && p1.next == null)) return p2;

		int carry = 0;

		//TODO: Remember to "next" result before giving it.
		ListNode result = new ListNode (0);
		ListNode resultP = result;


		while ( ! (p1 == null && p2 == null)){
			int val1 = 0;
			int val2 = 0;

			if (p1 != null){
				val1 = p1.val;
				p1 = p1.next;
			}

			if (p2 != null){
				val2 = p2.val;
				p2 = p2.next;
			}

			int val3 = (val1 + val2 + carry) % 10;
			carry = (val1 + val2 + carry) / 10;

			resultP.next = new ListNode (val3);
			resultP = resultP.next;
		}

		if ( carry > 0 ){
			resultP.next = new ListNode (carry);
		}

		result = result.next;
		return result;


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
