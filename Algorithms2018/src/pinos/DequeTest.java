package pinos;

public class DequeTest {

	
	
	public static void main(String[] args) {
		java.util.Deque <Integer> deq = new java.util.LinkedList < Integer > ();
		
		deq.addLast(5);
		deq.addLast(7);
		deq.addFirst(4);
		
		for ( int i : deq){
			System.out.println(i);
		}
		
	}

}
