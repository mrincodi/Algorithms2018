package pinos;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/minimize-the-absolute-difference/
//This works, but I don't need to do so many crazy calculations. Whenever an array ends, the next increase
//will only increase the difference, so I can just stop right there.
public class MinimizeTheAbsoluteDifference {

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

		int [] index = new int [ 3 ];

		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < A.size() + B.size() + C.size(); i++){

			int valA = A.get(index[0]);
			int valB = B.get(index[1]);
			int valC = C.get(index[2]);
			
			int newMax = Math.max (Math.max (valA, valB), valC);
			int newMin = Math.min (Math.min (valA, valB), valC);
			minDiff = Math.min (newMax - newMin, minDiff); 
			if ( minDiff == 0) return 0;
			increaseIndex (A,B,C,index);
		}
		return minDiff;
	}
	void increaseIndex (ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C,int [] index ) {
		int valA = A.get(index[0]);
		int valB = B.get(index[1]);
		int valC = C.get(index[2]);

		if      (index [ 0 ] == A.size() - 1 && index [ 1 ] == B.size() - 1 && index [ 2 ] == C.size() - 1) return;
		if      (index [ 0 ] == A.size() - 1 && index [ 1 ] == B.size() - 1) index[2]++;
		else if (index [ 0 ] == A.size() - 1 && index [ 2 ] == C.size() - 1) index[1]++;
		else if (index [ 1 ] == B.size() - 1 && index [ 2 ] == C.size() - 1) index[0]++;
		else if (index [ 0 ] == A.size() -1){
			if ( valB <= valC)
				index [ 1 ]++;
			else
				index [ 2 ]++;
		}   
		else if (index [ 1 ] == B.size() -1){
			if ( valA <= valC)
				index [ 0 ]++;
			else
				index [ 2 ]++;
		}
		else if (index [ 2 ] == C.size() -1){
			if ( valA <= valB)
				index [ 0 ]++;
			else
				index [ 1 ]++;
		}
		else {
			if ( valA <= valB && valA <= valC )
				index [ 0 ]++;
			else if (valB <= valA && valB <= valC)
				index [ 1 ]++;
			else
				index [ 2 ]++;
		}
	}


	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,4,5,8,10));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(6,9,15));
		ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(2,3,6,6));
		
		int sol = new MinimizeTheAbsoluteDifference().solve(A, B, C);
		System.out.println(sol);
		
	}

}
