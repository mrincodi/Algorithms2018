package interview_bit;

import java.util.HashMap;

// https://www.interviewbit.com/problems/copy-list/
// OK, that was creepy.
// 2018-09-03
class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};

public class CopyList {


	/**
	 * Definition for singly-linked list with a random pointer.
	 * class RandomListNode {
	 *     int label;
	 *     RandomListNode next, random;
	 *     RandomListNode(int x) { this.label = x; }
	 * };
	 */
	public RandomListNode copyRandomList(RandomListNode head) {

		if ( head == null ) return null;

		HashMap < RandomListNode, RandomListNode > helpMap = new HashMap <>();

		RandomListNode pointer = head;

		while (pointer != null ){
			RandomListNode newNode = new RandomListNode ( pointer.label );
			helpMap.put ( pointer, newNode);
			pointer = pointer.next;
		}

		RandomListNode result = helpMap.get ( head );
		result.random = helpMap.get ( head.random );

		pointer = head;
		RandomListNode resultPointer = result;
		pointer = pointer.next;

		while ( pointer != null ){
			resultPointer.next = helpMap.get ( pointer );
			resultPointer = resultPointer.next;
			resultPointer.random = helpMap.get ( pointer.random );
			pointer = pointer.next;
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
