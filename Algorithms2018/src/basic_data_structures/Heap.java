package basic_data_structures;

// TODO: NOT THROUGHLY TESTED.

public class Heap {
	java.util.ArrayList <Integer> heap = new java.util.ArrayList <Integer> ();

	Heap (){
		heap.add(0);
	}

	public void add ( Integer i){
		if ( heap.size() == 1 )
			heap.add (i);
		else{
			//Put in the end and "bubble up".
			int pos = heap.size();
			heap.add(i);

			boolean bubbleUp = true;
			while (bubbleUp){
				int parentPos = getParentPos (pos);
				int parentVal = heap.get(parentPos);
				if (i < parentVal){	
					java.util.Collections.swap (heap, pos, parentPos);
					pos = parentPos;
					if ( pos == 1 ) bubbleUp = false;
				}
				else bubbleUp = false;
			}
		}
	}

	public int remove () throws java.lang.Exception{

		int result = peek();

		int lastValue = heap.get ( heap.size() - 1 );

		heap.remove ( heap.size() - 1);

		if ( heap.size() > 1 ){	// Bubble down.
			heap.set ( 1, lastValue );
			int pos = 1;

			boolean bubbleDown = true;
			while (bubbleDown){
				int val = heap.get(pos);
				int leftChildPos = getLeftChildPos(pos);
				if ( leftChildPos < heap.size() ){
					int leftChildVal = heap.get(leftChildPos);
					if ( leftChildVal < val){
						java.util.Collections.swap (heap, leftChildPos, pos);
						pos = leftChildPos;
					}
					else { //consider right child.
						int rightChildPos = leftChildPos + 1;
						if ( rightChildPos < heap.size() ){
							int rightChildVal = heap.get(rightChildPos);
							if ( rightChildVal < val ) {
								java.util.Collections.swap (heap, rightChildPos, pos);
								pos = rightChildPos;
							}
							else {
								bubbleDown = false;
							}
						}
						else {
							bubbleDown = false;
						}
					}
				}
				else {
					bubbleDown = false;
				}
			}
		}
		return result;
	}


	public int peek () throws Exception{
		if ( heap.size() <= 1)
			throw new java.lang.Exception ("Heap is empty");

		return heap.get(1);
	}

	int getParentPos (int pos){
		return pos / 2;
	}


	int getLeftChildPos (int pos){
		return pos * 2;
	}

	public static void main ( String [] args ) throws Exception{
		Heap h = new Heap();
		h.add (5);
		h.add(7);
		h.add(9);
		h.add(3);
		h.add(6);

		int min = h.remove();
		System.out.println(min);
		
		min = h.peek();
		System.out.println(min);
		
		min = h.remove();
		min = h.peek();
		System.out.println(min);
		
		

	}

}

