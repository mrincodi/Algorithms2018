package interview_bit;

import java.util.ArrayList;
import java.util.HashMap;

//https://www.interviewbit.com/problems/min-jumps-array/
// O ( n^2) solution. Another try. Takes too long for InterviewBit.

public class MinJumpsArray1 {
	HashMap <Integer, Integer > jumpMap = new HashMap <Integer, Integer > ();
	public int jump(ArrayList<Integer> A) {
		if ( A== null || A.size () == 0 ) return 0;
		return jump (A, 0);
	}

	private int jump(ArrayList<Integer> A, int start){
		if ( start == A.size() - 1 ) return 0;
		if ( jumpMap.containsKey (start)) return jumpMap.get(start);
		if ( A.get(start) <= 0 ) return -1;

		int result = Integer.MAX_VALUE;
		for ( int i = start + 1; i <= Math.min ( start + A.get(start), A.size() - 1);i++){
			int thisResult = jump (A, i);

			if ( thisResult != -1 )
				result = Math.min ( result, thisResult );
		}

		if ( result == Integer.MAX_VALUE ) result = -1;
		else result = 1 + result;

		jumpMap.put ( start, result );
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
