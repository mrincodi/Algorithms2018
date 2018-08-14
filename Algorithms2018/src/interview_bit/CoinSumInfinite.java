package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// https://www.interviewbit.com/problems/coin-sum-infinite/
// This is a fairly easy issue, but for several reasons was driving me crazy.
// I have the issue of some tests failing because of stack overflow.

public class CoinSumInfinite {

	HashMap < String, Integer > already = new HashMap< String, Integer > ();
	public int coinchange2(ArrayList<Integer> c, int n) {
		String s = c.size()+"_"+n;

		if ( already.containsKey(s))return already.get(s);

		int result = 0;
		if ( n < 1 ) return 0;


		int v = c.get(0);

		if (c.size() == 1 ){
			if  ( n >= v && n % v == 0 ) return 1;
			else return 0;
		}

		ArrayList<Integer> c1 = new ArrayList < Integer > (c.subList(1, c.size()));
		result = coinchange2 (c1, n );

		if ( v == n ) result += 1;

		if ( v < n )
			result = result + coinchange2 ( c, n - v);


		already.put ( s, result);
		return result;

	}


	public static void main(String[] args) {
		ArrayList < Integer > al = new ArrayList < Integer > ( Arrays.asList(2));
		int r = new CoinSumInfinite().coinchange2(al, 412);
		System.out.println ( r );

	}

}
