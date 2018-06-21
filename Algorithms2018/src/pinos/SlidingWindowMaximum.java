package pinos;

import java.util.Arrays;

public class SlidingWindowMaximum {

	public java.util.ArrayList < Integer > gimmeTheMaxs ( java.util.ArrayList < Integer > numbers, int w){
		java.util.ArrayList < Integer > result = new java.util.ArrayList <Integer> ();

		if (numbers.size() == 0 || w <= 1 ) return result;

		w = Math.min(w, numbers.size());

		java.util.Deque < Integer> deq = new java.util.LinkedList < Integer > ();

		//Create the deque and get first value
		
		for ( int i = 0; i < w; i++){
			int n = numbers.get(i);
			
			// < or <=? is equivalent. We will just save redundant information if we use only <.
			while ( !deq.isEmpty() && numbers.get(deq.getLast()) <= n){
				deq.removeLast();
			}
			deq.addLast(i);
		}
		
		result.add(numbers.get(deq.getFirst()));
		
		for ( int i = 1; i < numbers.size() - w + 1; i++){
			
			//First, fix the deque.
			if ( deq.getFirst() == i - 1) 
				deq.removeFirst();
			
			int n = numbers.get(i + w - 1);
			while ( !deq.isEmpty() && numbers.get(deq.getLast()) <= n){
				deq.removeLast();
			}
			deq.addLast(i + w - 1);

			result.add(numbers.get(deq.getFirst()));
		}

		
		
		return result;
	}

	public static void main(String[] args) {
		java.util.ArrayList < Integer > numbers = new java.util.ArrayList < Integer > ( java.util.Arrays.asList(1,2,3,4,5,6,7,8,9,9,9,9,9,8,7,6,5,4,3,2,1,1,1,1,1,Integer.MAX_VALUE));
			int w = 4;
		java.util.ArrayList < Integer > seq = new SlidingWindowMaximum().gimmeTheMaxs(numbers, w);

		for ( int i: seq){
			System.out.println(i);
		}
	}

}
