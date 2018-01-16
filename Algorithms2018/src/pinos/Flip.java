package pinos;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/flip/
//Beautiful indeed!

public class Flip {

	public ArrayList<Integer> flip(String A) {
		int currentSum = 0;
		int maxSumSoFar = 0;
		int maxSumSoFarStart = -1;
		int maxSumSoFarEnd = -1;
		int currentStart = 0;

		ArrayList<Integer> result = new ArrayList<Integer> ();

		if ( A.length () == 0 ) return result;

		if ( A.charAt (0) == '1' )
			currentSum = -1;
		else {
			currentSum = 1;
			maxSumSoFarStart = 0;
			maxSumSoFarEnd = 0;
		}

		maxSumSoFar = currentSum;

		for (int i = 1; i < A.length(); i++){

			//Update value for our count.
			int val = 1;
			char realVal = A.charAt(i);
			if ( realVal == '1') val = -1;

			if ( val + currentSum >= val)
				currentSum = currentSum + val;
			else {
				currentSum = val;
				currentStart = i;
			}

			if ( currentSum > maxSumSoFar ){
				maxSumSoFar = currentSum;
				maxSumSoFarStart = currentStart;
				maxSumSoFarEnd = i;
			}

		}

		if (maxSumSoFarStart != -1){ 
			result.add (maxSumSoFarStart + 1);
			result.add(maxSumSoFarEnd + 1);
		}

		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1101010001"; //
		System.out.println( new Flip().flip(s));
	}

}
