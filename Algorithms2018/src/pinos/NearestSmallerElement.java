package pinos;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/nearest-smaller-element/
// The real deal. The variable "found" is not really needed.

public class NearestSmallerElement {

	public ArrayList <Integer> prevSmaller(ArrayList<Integer> A) {
		java.util.Stack <Integer> stack = new java.util.Stack <Integer>();     
		ArrayList <Integer> result = new ArrayList<Integer> ();
		int resultValue = -1;

		for ( int i = 0; i < A.size(); i++ ){
			int thisValue = A.get(i);


			// Look for the value in the stack.
			//java.util.Stack <Integer> stack2 = (java.util.Stack <Integer>) stack.clone();

			boolean found = false;

			//First, look for the value.
			while ( !found && !stack.isEmpty ()){
				int stackValue = stack.peek();

				if ( stackValue < thisValue){
					resultValue = stackValue;
					found = true;
				}
				else {
					stack.pop();
				}
			}

			if ( !found ) resultValue = -1;

			result.add (resultValue);
			stack.push (thisValue);

		}
		return result;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
