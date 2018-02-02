package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://www.interviewbit.com/problems/tushars-birthday-bombs/
// Works, but still not efficient (!).

public class TusharsBirthdayBombsStillSuboptimal {

	public ArrayList<Integer> solve(int R, ArrayList<Integer> S) {

		//Find out what the maximum should be.
		int min = Integer.MAX_VALUE;
		for (int value:S)
			min = Math.min (min,value);

		int maxSize = R/min;

		//Let's take only the possible answers. shorterList has only the values, not the positions.
		ArrayList<Integer> shorterList = new ArrayList<Integer> ();

		//positions maps from the new shorterList to the original positions in S.
		HashMap <Integer, Integer> positions = new HashMap <Integer, Integer> ();

		min = S.get(0);
		shorterList.add(S.get(0));
		positions.put (0,0);

		for ( int i = 1; i < S.size(); i++){
			int currentValue = S.get(i);
			if (currentValue < min){
				shorterList.add(currentValue);
				positions.put (shorterList.size() - 1, i);
				min = currentValue;
			}
		}

		ArrayList<Integer> solutionsNotMapped = solve (R, shorterList, 0, maxSize);

		ArrayList<Integer> result = new ArrayList<Integer> ();

		for ( int pos:solutionsNotMapped){
			result.add(positions.get(pos));
		}

		return result;
	}

	public ArrayList<Integer> solve(int R, ArrayList<Integer> S, int index, int maxSize) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if ( index == S.size() ) return result;

		if ( S.get(index) <= R){
			if (maxSize == 1){
				result.add (index);
				return result;
			}

			//else:
			//Possibility one: with the element. 
			ArrayList<Integer> partialResult1 = solve (R-S.get(index),S,index,maxSize-1);
			if ( partialResult1.size() == maxSize - 1){
				partialResult1.add (0, index);
				return partialResult1;
			}
		}
		return solve (R,S, index + 1,maxSize);
	}

	public static void main(String[] args) {
		ArrayList <Integer> S = new ArrayList <Integer> (Arrays.asList(8, 8, 6, 5, 4));
		ArrayList <Integer> result = new TusharsBirthdayBombsSuboptimal().solve(10, S);
		System.out.println(result);


	}

}
