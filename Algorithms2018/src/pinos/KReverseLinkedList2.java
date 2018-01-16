package pinos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KReverseLinkedList2 {

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

		if ( B == 1 ) return A;
		ListNode APointer = A;

		ListNode result = new ListNode (0);
		boolean firstTime = true;
		ListNode first = APointer;
		
		while ( APointer != null){
			
			ListNode prev = APointer;
			ListNode newFirst = APointer;

			APointer = APointer.next;
			
			for ( int i = 1; i < B; i++){
				ListNode APointerNext = APointer.next;
				APointer.next = prev;
				prev = APointer;
				if (i == B - 1){
					if (firstTime ){
						result = APointer;
						firstTime = false;
					}
					else
						first.next=APointer;
						
					first = newFirst;
				}

				APointer = APointerNext;

			}
		}
		
		first.next = null;

		return result;
	}


	public static void main(String[] args) {

		KReverseLinkedList2 K = new KReverseLinkedList2();
		ListNode ln = K.new ListNode (1);
		ln.next = K.new ListNode (2);
		ln.next.next = K.new ListNode (3);
		ln.next.next.next = K.new ListNode (4);
		ln.next.next.next.next = K.new ListNode (5);
		ln.next.next.next.next.next = K.new ListNode (6);

		ListNode r = K.reverseList (ln, 1);
		while (r != null){
			System.out.println(r.val);
			r=r.next;
//			try {
//				new BufferedReader(new InputStreamReader(System.in)).readLine();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

}
