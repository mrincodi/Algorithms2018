package pinos;

import java.util.HashMap;

public class PinoLRU {

	public static final int MAX_CAPACITY = 10; 
	public static final int NOT_FOUND = -1; 

	int capacity=0;
	HashMap <Integer, DoubleLinkedList > hashmap = new HashMap <Integer, DoubleLinkedList > ();

	DoubleLinkedList list = null;
	DoubleLinkedList listEnd = null;

	void set (int key, int value){

		if ( !hashmap.containsKey(key)){
			DoubleLinkedList newNode = new DoubleLinkedList(key, value);

			if (list == null){
				list = newNode;
				listEnd = newNode;
				hashmap.put(key, list);
				capacity=1;
			}
			else {
				DoubleLinkedList secondNode = list;
				list = newNode;
				list.next = secondNode;
				secondNode.previous=list;
				capacity++;

				hashmap.put(key, newNode);
				
				//What if we overflow?
				// I am supposing here that MAX_CAPACITY > 1.
				if ( capacity > MAX_CAPACITY){
					//First fix the HashMap.
					//I had to save the key inside the node in order to know what
					//node to remove from the hash.
					hashmap.remove(key);

					//Change the last value
					listEnd = listEnd.previous;

					listEnd.next=null;

				}
				
			}
		}
		else {
			DoubleLinkedList node = hashmap.get(key);
			node.value=value;

			if ( list != node ){//If the first one in the list is this node, do nothing.
				if ( listEnd == node ){
					listEnd=listEnd.previous;
					listEnd.next=null;
				}
				else {
					node.next.previous=node.previous;
					node.previous.next=node.next;
				}

				DoubleLinkedList secondNode = list;
				list = node;
				list.next = secondNode;
				secondNode.previous=list;

				hashmap.put(key, node);
			}
		}
		
		printLRU();


	}
	void printLRU (){
		DoubleLinkedList pointer = list;
		while (pointer != null){
			System.out.println(pointer.key + " -> " + pointer.value);
			pointer=pointer.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PinoLRU lru = new PinoLRU();

		lru.set(4, 100);
		lru.set(7, 120);
		//lru.printLRU();

		lru.set(4, 100);
		//lru.printLRU();

		lru.set(4, 100);
		lru.set(5, 200);
		lru.set(6, 300);
		lru.set(7, 400);
		lru.set(8, 500);
		lru.set(9, 600);

		
		lru.set(100, 400);
		lru.set(1, 600);
		lru.set(2, 500);
		lru.set(3, 400);
		lru.set(4, 300);
		lru.set(5, 200);
		lru.set(6, 600);
		lru.set(7, 500);
		lru.set(8, 400);
		lru.set(9, 300);
		lru.set(10, 200);
		
		//lru.printLRU();
	}
}

class DoubleLinkedList {
	int key;
	int value;
	DoubleLinkedList next = null;
	DoubleLinkedList previous = null;

	DoubleLinkedList (int key, int value){
		this.key = key;
		this.value=value;
	}
}
