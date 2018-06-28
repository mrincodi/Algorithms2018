package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/min-jumps-array/
// O ( n^2) solution. Takes too long for InterviewBit.

public class MinJumpsArray2 {

	public int jump(ArrayList<Integer> A) {
		if ( A.size () <= 1 ) return 0;
		int [] helpArray = new int [ A.size() ];
		Arrays.fill ( helpArray, Integer.MAX_VALUE );
		helpArray [ helpArray.length - 1 ] = 0;

		for ( int i = A.size() - 2; i >= 0; i-- ){
			int n = A.get ( i );
			n = Math.min ( A.size() - i - 1, n );

			for ( int j = 1; j <= n; j++){
				if  ( helpArray [ i + j ] != Integer.MAX_VALUE)
					helpArray [ i ] = Math.min ( helpArray [ i + j ] + 1, helpArray [ i ] );  
			}
		}
		if ( helpArray [ 0 ] == Integer.MAX_VALUE ) return -1;
		return helpArray [ 0 ];
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
