package leetcode;

// https://leetcode.com/problems/valid-palindrome-ii/description/
// Simple. Could have been less verbose.

public class ValidPalindromeII {

	public boolean validPalindrome(String s) {
		int posDiff = -1;
		for (int i = 0; i < s.length () /2 && posDiff == -1 ; i++){
			if ( s.charAt ( i ) != s.charAt ( s.length () -i - 1)) {
				posDiff = i;
			}
		}
		if ( posDiff == -1) return true;

		//Now, check removing 1 char left and 1 char right.

		String s2 = s.substring ( posDiff + 1, s.length() - posDiff );

		boolean diffChars = false;
		for (int i = 0; i < s2.length () /2 && !diffChars ; i++){
			if ( s2.charAt ( i ) != s2.charAt ( s2.length () - i - 1)) {
				diffChars = true;
			}
		}
		if ( !diffChars ) return true;

		//Finally...
		s2 = s.substring ( posDiff, s.length() - posDiff - 1 );

		for (int i = 0; i < s2.length () /2 ; i++){
			if ( s2.charAt ( i ) != s2.charAt ( s2.length () - i - 1)) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
