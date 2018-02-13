package pinos;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/seats/
// Good exercise, but strategy/code is wrong.

public class SeatsWrong {

	public int seats(String A) {
		ArrayList <Integer> positions = new ArrayList <Integer> ();
		ArrayList <Integer> distances = new ArrayList <Integer> ();
		for ( int i = 0; i < A.length(); i++)
			if (A.charAt(i)=='x') positions.add(i);

		if (positions.size () <= 1 ) return 0;

		for ( int i = 1; i < positions.size(); i++)
			distances.add (positions.get(i)-positions.get(i-1));

		long minDistance = Integer.MAX_VALUE;
		int end = positions.size() -1;

		//d.get(i) = dist. from i to i+1
		for ( int axis = 0; axis < positions.size(); axis++){

			long factor1 = 0;
			for ( int i = 0; i < axis; i++){
				factor1 += (axis - i)*distances.get (i);
			}

			long factor2 = 0;
			for ( int i = axis + 1; i <= end; i++){
				factor2 += (end - i + 1)*distances.get (i-1);
			}

			long factor3 = axis*(axis +1)/2;

			long factor4 = (end - axis)*(end - axis +1)/2;

			long thisResult = factor1 + factor2 - factor3 - factor4;
			minDistance = Math.min (minDistance, thisResult);
		}

		return (int) (minDistance % 10000003);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
