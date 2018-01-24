package pinos;

import java.util.ArrayList;
import java.util.HashMap;

// https://www.interviewbit.com/problems/distinct-numbers-in-window/
// Easy.
public class DistinctNumbersInWindow {


	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if ( B > A.size() ) return result;

		HashMap <Integer, Integer> diffNumbers = new HashMap <Integer, Integer> ();

		//Enter the values of the first window.
		for ( int i = 0; i < B; i++){
			if ( diffNumbers.containsKey(A.get(i))){
				diffNumbers.put(A.get(i), diffNumbers.get(A.get(i))+1);
			}
			else {
				diffNumbers.put(A.get(i),1);
			}
		}

		result.add (diffNumbers.keySet().size());

		for ( int i = 1; i < A.size() - B + 1; i++){
			//remove the first number.
			int toRemove = A.get(i-1);
			if ( diffNumbers.get(toRemove) == 1) diffNumbers.remove(toRemove);
			else diffNumbers.put(toRemove,diffNumbers.get(toRemove)-1);

			//Add the next number.
			int toAdd = A.get (i + B - 1);
			//TODO: Find out the intelligent get method that gives a default value if key is not in hashmap.
			if ( diffNumbers.containsKey(toAdd) ) {
				diffNumbers.put(toAdd, diffNumbers.get(toAdd) + 1);
			}
			else {
				diffNumbers.put(toAdd, 1);
			}
			result.add (diffNumbers.keySet().size());

		}

		return result;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
