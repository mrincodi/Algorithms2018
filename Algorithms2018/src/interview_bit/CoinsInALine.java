package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// https://www.interviewbit.com/problems/coins-in-a-line/
// Wow, this was not obvious.
/*
 * Idea:
 * Rec(player = you, start, end) = 
	    |
	max | v(end) + Rec(opposite_player, start, end - 1)  
	    |
	    | v(start) + Rec(opposite_player, start + 1, end)
	    |
Rec(player = opposite, start, end) = 
	    |
	min | Rec(you, start, end - 1)
	    |
	    | Rec(you, start + 1, end)
	    |
 */
public class CoinsInALine {
	HashMap < String, Integer > calculated = new HashMap < String, Integer > ();

	public int maxcoin(ArrayList<Integer> A) {
		if ( A.size () == 0 ) return 0;
		return maxcoin ( A, 0, A.size() - 1, true );
	}

	private int maxcoin(ArrayList<Integer> A, int start, int end, boolean me ){
		int result = 0;
		if ( start == end ) return A.get(start);

		if ( start == end - 1 ) {
			
			if ( me ) return Math.max ( A.get (start ), A.get(end));
			else return Math.min ( A.get (start ), A.get(end));
		}
		
		String s = start + "_" + end + "_" + me;
		
		if ( calculated.containsKey(s)) return calculated.get(s);

		if ( me ){
			int ifITakeStart = A.get( start ) + maxcoin (A, start + 1, end, false);
			int ifITakeEnd   = A.get( end )   + maxcoin (A, start, end - 1, false);
			
			result = Math.max ( ifITakeStart, ifITakeEnd);
		}
		else {
			int ifHeTakesStart =  maxcoin (A, start + 1, end, true);
			int ifIHeTakesEnd  =  maxcoin (A, start, end - 1, true);
			
			result = Math.min( ifHeTakesStart, ifIHeTakesEnd);
		}

		calculated.put(s, result);
		return result;

	}

	public static void main(String[] args) {
		ArrayList < Integer > coins = new ArrayList < Integer > ( Arrays.asList( 1, 2, 3, 4));
		int result = new CoinsInALine().maxcoin(coins, 0, coins.size()-1, true);
		
		System.out.println ( result );

	}

}
