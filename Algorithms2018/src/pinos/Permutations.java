package pinos;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/permutations/

public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
		if ( A.size() == 0 ){
			result.add (new ArrayList<Integer>());
			return result;
		}

		for ( int i = 0; i < A.size(); i++){
			//Create a new arraylist without that element.
			ArrayList<Integer> AClone = new ArrayList<Integer> (A);
			AClone.remove(i);
			ArrayList<ArrayList<Integer>> partialResult = permute (AClone);
			for ( ArrayList<Integer> partialResultSet : partialResult){
				partialResultSet.add(0,A.get(i));
				result.add(partialResultSet);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
