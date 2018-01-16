package pinos;

//No hashes!
//https://www.interviewbit.com/problems/list-cycle/

/*
 * 
 * 
 * Lets now look at the starting point. 
If we were using hashing, the first repetition we get is the starting point. Simple!

What happens with the 2 pointer approach ?

Method 1 : 
If you detect a cycle, the meeting point is definitely a point within the cycle.

Can you determine the size of the cycle ? ( Easy ) Let the size be k.
Fix one pointer on the head, and another pointer to kth node from head.
Now move them simulataneously one step at a time. They will meet at the starting point of the cycle.
Method 2 : 
This might be slightly more complicated. It involves a bit of maths and is not as intuitive as method 1. 
Suppose the first meet at step k,the distance between the start node of list and the start node of cycle is s, and the distance between the start node of cycle and the first meeting node is m. 
Then 
2k = (s + m + n1r) 
2(s + m + n2r) = (s + m + n1r) 
s + m = nr where n is an integer.
s = nr - m
s = (r - m) + (n-1)r

So, if we have one pointer on the head and another pointer at the meeting point. Note that since the distance between start node of cycle and the first meeting node is m, therefore if the pointer moves (r - m) steps, it will reach the start of the cycle. When the pointer at the head moves s steps, the second pointer moves (r-m) + (n-1)r steps which both points to the start of the cycle. In other words, both pointers meet first at the start of the cycle.
 * 
 */
public class ListCycleInterviewBit {

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
