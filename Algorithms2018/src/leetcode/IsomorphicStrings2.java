package leetcode;
import java.util.HashMap;

// https://leetcode.com/problems/isomorphic-strings/description/
// Better and shorter.

public class IsomorphicStrings2 {

	public boolean isIsomorphic(String s, String t) {
		return isFunction (s,t) && isFunction (t,s);
	}

	private boolean isFunction ( String s, String t){

		if ( s== null && t == null ) return true;
		if ( s== null || t == null ) return false;

		if ( s.length () != t.length() ) return false;

		HashMap <Character, Character> map = new HashMap <Character, Character> ();

		for ( int i = 0; i < s.length (); i++ ){
			char c1 = s.charAt ( i );
			char c2 = t.charAt ( i );

			if ( !map.containsKey (c1)){
				map.put ( c1, c2 );
			}
			else if ( c2 != map.get (c1)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
