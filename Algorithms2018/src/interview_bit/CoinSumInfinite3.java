package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// https://www.interviewbit.com/problems/coin-sum-infinite/
// This is the perfect tricky exercise now that I think of it!
// This solution, for example, doesn't work because it recounts!

public class CoinSumInfinite3 {

	public int coinchange2(ArrayList<Integer> c, int n) {
		
		int [] A = new int [ n + 1 ];
		
		A [ 0 ] = 1;
		
		for ( int i = 1; i <= n; i++){
			int r = 0;
			for ( int v: c){
				if ( i >= v){
					r = r + A [ i - v ];
				}
			}
			A[i]=r;
			System.out.print ("");
		}
		int result = A [ n ];
		
		result = result % 1000007;

		return result;

	}


	public static void main(String[] args) {
		//ArrayList < Integer > al = new ArrayList < Integer > ( Arrays.asList(18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8));
		ArrayList < Integer > al = new ArrayList < Integer > ( Arrays.asList(1,2,3,4));
		
		int r = new CoinSumInfinite3().coinchange2(al, 10);
		System.out.println ( r );

	}

}
