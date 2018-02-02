package pinos;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
//This is failing for array 
//A : 
//[
//  [16, 5, 54, 55, 36, 82, 61, 77, 66, 61]
//  [31, 30, 36, 70, 9, 37, 1, 11, 68, 14]
//]
// Gives 320. It should be 321.
// I don't know why it fails.

public class MaxSumWithoutAdjacentElement {

	public int adjacent(ArrayList<ArrayList<Integer>> A) {
		ArrayList <Integer> maximums = new ArrayList <Integer> ();

		if ( A.get(0).size()==0) return 0;

		maximums.add (Math.max(A.get(0).get(0),A.get(1).get(0)));
		if ( A.get(0).size()==1) return maximums.get(0);

		maximums.add (Math.max(A.get(0).get(1),A.get(1).get(1)));
		if ( A.get(0).size()==2) return Math.max (maximums.get(0), maximums.get(1));

		for ( int i = 2; i < A.get(0).size(); i++ ){
			int thisColMax = Math.max (A.get(0).get(i),A.get(1).get(i));

			int possibility = Math.max ( Math.max ( maximums.get(i-2), thisColMax ), maximums.get(i-2) + thisColMax);     
			maximums.add(Math.max(possibility, maximums.get(i-1)));
		}

		return maximums.get(maximums.size()-1);


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
