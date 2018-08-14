package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// https://www.interviewbit.com/problems/coin-sum-infinite/
// This is the perfect tricky exercise now that I think of it!
// This solution (whew!) works!!
public class CoinSumInfinite2 {

	public int coinchange2(ArrayList<Integer> c, int n) {
		
		int result = 0;
		int [] A = new int [ n + 1 ];
		
		A [ 0 ] = 1;
		
		for ( int coinPointer = 0; coinPointer < c.size(); coinPointer++ ){
			int coin = c.get(coinPointer);
			for ( int i = coin; i <= n; i++ ){
				A[i]=A[i]+A[i - coin] % 1000007;
			}
		}
		
		result = A[n];
		
		return result % 1000007;

	}


	public static void main(String[] args) {
		//ArrayList < Integer > al = new ArrayList < Integer > ( Arrays.asList(18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8));
		ArrayList < Integer > al = new ArrayList < Integer > ( Arrays.asList(1,2,3,4,5));
		
		int r = new CoinSumInfinite2().coinchange2(al, 10);
		System.out.println ( r );

	}

}
