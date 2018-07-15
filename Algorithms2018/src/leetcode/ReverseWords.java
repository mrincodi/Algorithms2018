package leetcode;

import java.util.ArrayList;

// https://leetcode.com/problems/reverse-words-in-a-string/description/
// Another typical one
// 2018-07-11

public class ReverseWords {

	public String reverseWords(String s) {
		String result = "";
		if ( s == null || s.length () == 0 ) return s;

		s = s + " ";
		ArrayList < String > words = new ArrayList < String > ();

		String word = "";

		for ( int i = 0; i < s.length(); i++){
			char c = s.charAt ( i );

			if (c != ' '){
				word = word + c;
			}
			else {
				if ( word.length () > 0 ){
					words.add ( word );
					word = new String ();
				}
			}
		}

		//Now, just add the words in reverse.
		for ( int i = words.size() - 1; i >= 0; i-- ){
			result = result + words.get ( i );
			result = result + " ";
		}

		if ( result.length() > 0 )
			return new String ( result.substring (0, result.length () - 1));
		else
			return result;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
