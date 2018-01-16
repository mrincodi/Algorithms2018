package pinos;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		Collections.sort ( A );
		return subsets1 (A);
	}
	public ArrayList<ArrayList<Integer>> subsets1(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		if ( A.size() == 0){
			result.add (new ArrayList<Integer> ());
			return result;
		}
		else{
			//Copy array to new array minus the first element.
			ArrayList<Integer> AMinusFirst = new ArrayList<Integer>();
			for ( int i=1; i < A.size(); i++){
				AMinusFirst.add(A.get(i));
			}

			ArrayList<ArrayList<Integer>> subsetsMinusFirstElement = subsets1 (AMinusFirst);

			//Generate values that include the first element.

			result.add (new ArrayList<Integer> ()); // Empty set.
			for ( int i = 0; i < subsetsMinusFirstElement.size(); i++){
				ArrayList<Integer> thisSubsetsMinusFirstElement = new ArrayList<Integer> (subsetsMinusFirstElement.get(i));;
				thisSubsetsMinusFirstElement.add (0, A.get(0));
				result.add (thisSubsetsMinusFirstElement);
			}
			for ( int i = 1; i < subsetsMinusFirstElement.size(); i++){
				ArrayList<Integer> thisSubsetsMinusFirstElement = new ArrayList<Integer> (subsetsMinusFirstElement.get(i));;
				result.add (thisSubsetsMinusFirstElement);
			}
		}

		return result;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
