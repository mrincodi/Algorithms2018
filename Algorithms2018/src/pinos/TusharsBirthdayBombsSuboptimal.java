package pinos;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/tushars-birthday-bombs/
// Works, but not efficient.

public class TusharsBirthdayBombsSuboptimal {

	public ArrayList<Integer> solve(int R, ArrayList<Integer> S) {

		//Find out what the maximum should be.
		int min = Integer.MAX_VALUE;
		for (int value:S)
			min = Math.min (min,value);

		int maxSize = R/min;

		//Without optimization, first.
		return solve (R, S, 0, maxSize);
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
