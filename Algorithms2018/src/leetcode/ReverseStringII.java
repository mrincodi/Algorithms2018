package leetcode;

// https://leetcode.com/problems/reverse-string-ii/description/
// Easy and fun.

public class ReverseStringII {

	public String reverseStr(String s, int k) {
		if ( s == null ) return null;
		if ( k <= 1 ) return s;

		char [] chars = s.toCharArray ();

		if ( s.length() <= k){
			reverse (chars,0,s.length());
			return (new String ( chars) );
		}

		for (int i = 0; i < s.length(); i = i + 2*k){
			reverse (chars, i, Math.min (i + k, s.length()));
		}
		return ( new String ( chars ));
	}

	private void reverse ( char [] chars, int start, int end ){
		// End character is not included.
		int i = start;
		int j = end - 1;

		while ( i < j ){
			char temp = chars [ i ];
			chars [ i ] = chars [ j ];
			chars [ j ] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
