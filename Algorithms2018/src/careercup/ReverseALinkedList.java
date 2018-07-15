package careercup;

// https://www.careercup.com/question?id=4919175997816832
// The O(n), O(1) way! OMG, mmorize this!

class Node {
	int val;
	Node next;
}
public class ReverseALinkedList {

	public Node reverse ( Node pointer ){

		Node head = null, nextPointer = null;
		
		while ( pointer != null){
			 nextPointer = pointer.next;
			 pointer.next = head;
			 head = pointer;
			 pointer = nextPointer;
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
