package leetcode;

// https://leetcode.com/problems/longest-palindromic-substring/description/
// Elementary solution. As always, a bit too verbose.
// TODO: DO it in the DP way with a matrix, although this one is also DP).

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {

		if ( s.length() <= 1) return s;
		String result = s.charAt(0) + "";

		//First, let's check the odd-sized palindromes that may exist.
		for ( int i = 0; i < s.length(); i++){ //This is the location of the 'middle' letter.
			int j = 1;
			while ( i + j < s.length() && i - j >= 0 ){

				if ( s.charAt ( i - j ) != s.charAt ( i + j ) ) break;
				j++;

			}
			j--;

			if ( 1 + 2 * j > result.length())
				result = s.substring ( i - j, i + j + 1 );
		}

		//Now, the even-sized strings.
		for ( int i = 0; i < s.length() - 1; i++){ //This is the location of the center letter at the left.
			int j = 0;
			while ( i - j >= 0 && i + j + 1 < s.length()){
				if ( s.charAt ( i - j ) != s.charAt ( i + j + 1) ) break;
				j++;
			}

			// if ( j > 0 ){ // There is at least 2 letters.
			if ( 2 * j > result.length())
				result = s.substring ( i - j + 1 , i + j + 1 );
			// }

		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
