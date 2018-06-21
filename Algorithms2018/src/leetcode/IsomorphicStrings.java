package leetcode;
import java.util.HashMap;

// https://leetcode.com/problems/isomorphic-strings/description/
// Works. A bit convoluted. It would have been cleaner
// to check that it's a function (in the Mathematical sense) 
// from s to t and then from t to s.

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		if ( s== null && t == null ) return true;
		if ( s== null || t == null ) return false;

		if ( s.length () != t.length() ) return false;

		HashMap <Character, Character> mapst = new HashMap <Character, Character> ();
		HashMap <Character, Character> mapts = new HashMap <Character, Character> ();

		for ( int i = 0; i < s.length (); i++ ){
			char c1 = s.charAt ( i );
			char c2 = t.charAt ( i );

			if ( !mapst.containsKey (c1) && !mapts.containsKey (c2)){
				mapst.put ( c1, c2 );
				mapts.put ( c2, c1 );
			}
			else if ( (!mapst.containsKey (c1) &&  mapts.containsKey (c2) ) || 
					(  mapst.containsKey (c1) && !mapts.containsKey (c2)) ){
				return false;
			}
			else { 
				if ( c2 != mapst.get (c1)) return false;
				if ( c1 != mapts.get (c2)) return false;

			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
