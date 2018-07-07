package leetcode;

// https://leetcode.com/problems/number-of-segments-in-a-string/description/
// Easy.

public class NumberOfSegmentsInAString {

	public int countSegments(String s) {
		char prev = ' ';
		int result = 0;

		for ( int i = 0; i < s.length(); i++){
			char c = s.charAt ( i );
			if ( prev == ' ' && c != ' ') result++;
			prev = c;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
