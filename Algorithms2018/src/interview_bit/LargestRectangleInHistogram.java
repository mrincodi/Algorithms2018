package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
// Just checking this problem again.
// OJO: For hist[tp], the ‘left index’ is previous (previous to tp) item 
// in stack and ‘right index’ is ‘i’ (current index). See
// https://www.geeksforgeeks.org/largest-rectangle-under-histogram/

public class LargestRectangleInHistogram {

	public int largestRectangleArea(ArrayList<Integer> A) {

		if ( A == null || A.size() == 0 ) return 0;
		if ( A.size() == 1 ) return A.get(0);

		int result = A.get(0);

		A.add(0,0);
		A.add(0);

		Stack < Integer > stack = new Stack < Integer > ();
		stack.push (0);

		for ( int i = 1; i < A.size(); i++){
			if ( A.get(i) < A.get(i-1)){
				while (!stack.isEmpty() && ( A.get (stack.peek()) > A.get(i))){
					int pos = stack.pop();
					int val = A.get(pos);

					int leftIndex = stack.peek();
					
					int thisRectangle = val * (i - leftIndex -1);
					result = Math.max (result, thisRectangle);
				}
			}
			stack.push ( i );
		}

		return result;

	}
	
	public static void main ( String [] args){
		ArrayList < Integer > histo = new ArrayList <Integer> ( Arrays.asList(4,3,2,1));
		System.out.println( new LargestRectangleInHistogram().largestRectangleArea(histo));
	}

	
	
}
