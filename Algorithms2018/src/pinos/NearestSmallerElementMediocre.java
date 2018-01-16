package pinos;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/nearest-smaller-element/
// Mediocre solution.

public class NearestSmallerElementMediocre {

	public ArrayList <Integer> prevSmaller(ArrayList<Integer> A) {
		java.util.Stack <Integer> stack = new java.util.Stack <Integer>();     
		ArrayList <Integer> result = new ArrayList<Integer> ();
		int resultValue = -1;

		java.util.Stack <Integer> stack2 = new java.util.Stack <Integer> ();

		for ( int i = 0; i < A.size(); i++ ){
			int thisValue = A.get(i);

			if ( stack.isEmpty() ) resultValue = -1;
			else {
				// Look for the value in the stack.
				//java.util.Stack <Integer> stack2 = (java.util.Stack <Integer>) stack.clone();

				boolean found = false;

				//First, look for the value.
				while ( !found && !stack.isEmpty ()){

					int stackValue = stack.pop();
					stack2.push(stackValue);
					if ( stackValue < thisValue){
						resultValue = stackValue;
						found = true;
					}
				}
				if ( !found ) resultValue = -1;

				//Now, put back the stack as it was.
				while (!stack2.isEmpty()){
					stack.push(stack2.pop());
				}
			}

			result.add (resultValue);
			stack.push (thisValue);

		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
