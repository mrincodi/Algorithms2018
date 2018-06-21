package leetcode;

import java.util.HashSet;

// https://leetcode.com/problems/reconstruct-original-digits-from-english/description/
// This is a problem much harder than what it looks. The solution is not obvious.
// the reason my solution doesn't work is that one word can be mistakenly "included"
// in other words. For example "zeroseven" contains the letters of "one".
// This was my (wrong) approach.

public class ReconstructOriginalDigitsFromEnglishWrong {
	public String originalDigits(String s) {
		String result = "";
		String [] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

		outer:
			for ( int i = 0; i < numbers.length; i++ ){
				String word = numbers [ i ];
				HashSet < Integer > positions = new HashSet < Integer > ();

				inner:
					for ( int wordIndex = 0; wordIndex < word.length (); wordIndex++ ){
						char c = word.charAt ( wordIndex );
						boolean found = false;

						for ( int sIndex = 0; sIndex < s.length () && !found; sIndex++ ){
							if ( s.charAt ( sIndex ) == c && !positions.contains ( sIndex )){
								positions.add ( sIndex );
								found = true;
							}
						}

						if ( !found ) { continue outer; }   
					}

				result = result + i;
				i = i - 1;

				String newS = "";
				for ( int sIndex = 0; sIndex < s.length () ; sIndex++ ){
					if ( !positions.contains ( sIndex ) ){
						newS = newS + s.charAt ( sIndex );
					}
				}
				s = newS;
			}
		return result;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
