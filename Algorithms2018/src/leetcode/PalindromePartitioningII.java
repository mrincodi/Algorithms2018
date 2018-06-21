package leetcode;


import java.util.HashMap;

// https://leetcode.com/problems/palindrome-partitioning-ii/description/
// Typical problem (nice).

public class PalindromePartitioningII {


	HashMap < String, Integer > minNumPal = new HashMap < String, Integer > ();
	public int minCut(String s) {
		if ( minNumPal.containsKey ( s )) return minNumPal.get(s);

		if ( isPalindrome (s)){
			minNumPal.put ( s, 0 );
			return 0;
		}

		int result = s.length ();
		for ( int i = 1; i < s.length(); i++ ){
			String firstWord = s.substring ( 0 , i );
			if ( isPalindrome ( firstWord )){
				int rest = minCut (s.substring ( i ));
				result = Math.min ( result, rest + 1 );

			}
		}
		minNumPal.put ( s, result );
		return result;
	}

	public boolean isPalindrome ( String s ){
		for ( int i = 0; i < s.length() / 2; i++ ){
			if ( s.charAt ( i ) != s.charAt (s.length() -1 -i ))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
