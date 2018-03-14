package pinos;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://www.interviewbit.com/problems/merge-k-sorted-lists/


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

class CompareNodes implements java.util.Comparator <ListNode> {
	public int compare (ListNode x, ListNode y){
		if (x.val > y.val) return  1;
		if (x.val < y.val) return -1;
		return 0;
	}
}

public class MergeKSortedLists {

	public ListNode mergeKLists(ArrayList<ListNode> a) {
		ListNode result = new ListNode (0);
		ListNode pointer = result;

		PriorityQueue <ListNode> heap = new PriorityQueue <ListNode> (new CompareNodes () );   

		for (int i = 0; i < a.size(); i++ ){
			heap.add (a.get(i));
		}

		while (!heap.isEmpty()){
			ListNode smallest = heap.remove();
			pointer.next = new ListNode (smallest.val);
			pointer = pointer.next;
			if ( smallest.next != null)
				heap.add(smallest.next);
		}

		return result.next;

	}
}


