package interview_bit;

import java.util.ArrayList;
import java.util.HashMap;

// https://www.interviewbit.com/problems/coins-in-a-line/
// So this was my first try. It * works* if we don't suppose that the
// other player is also optimizing his result.
public class CoinsInALineFirstTry {
	HashMap < String, Integer > calculated = new HashMap < String, Integer > ();

	public int maxcoin(ArrayList<Integer> A) {
		if ( A.size () == 0 ) return 0;
		return maxcoin ( A, 0, A.size() - 1 );
	}

	private int maxcoin(ArrayList<Integer> A, int start, int end ){
		if ( start == end ) return A.get(start);

		if ( start == end - 1 ) return Math.max ( A.get (start ), A.get(end));

		String s = start + "_" + end;
		if ( calculated.containsKey ( s ) ) return calculated.get(s);

		//Opt. 1: both players take the 2 initial coins
		int rest = maxcoin (A, start + 2, end);
		int player1 = A.get ( start ) + rest;
		int player2 = A.get ( start + 1 ) + rest;

		int result_opt1 = Math.max ( player1, player2 );

		//Opt. 2 : player 1 takes the left one, player 2 takes the right one.
		rest = maxcoin (A, start + 1, end - 1);
		player1 = A.get ( start  ) + rest;
		player2 = A.get ( end ) + rest;

		int result_opt2 = Math.max ( player1, player2 );

		//Opt. 3 : player 1 takes the right one, player 2 takes the right one.
		rest = maxcoin (A, start , end - 2);
		player1 = A.get ( end  ) + rest;
		player2 = A.get ( end - 1 ) + rest;

		int result_opt3 = Math.max ( player1, player2 );

		int result = Math.max ( Math.max ( result_opt1, result_opt2 ), result_opt3 );

		calculated.put ( s, result );

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
