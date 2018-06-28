package hackerrank;

import java.util.HashMap;
import java.util.Iterator;

// https://www.hackerrank.com/challenges/maximum-palindromes
// NOTE: NOT WORKING, but I have the idea clear.
public class MaximumPalindromes {


	static String s = "";
	// Complete the initialize function below.
	static void initialize(String S) {
		// This function is called once before all queries.
		s = S;
	}

	// Complete the answerQuery function below.
	static int answerQuery(int l, int r) {
		int result = 0;
		if ( l > r || l < 1 || r > s.length()) return 0;
		if ( l == r ) return 1;

		//Lets subtract 1 from l and r, in order not to go crazy.
		l--;
		r--;

		HashMap <Character, Integer> charCount = new HashMap <Character, Integer> ();
		for ( int i = l; i <= r; i++){
			char c = s.charAt (i);
			charCount.put ( c, charCount.getOrDefault(c,0)+1);
		}

		//Now, divide all the values over 2. If a value is 1, ignore it.
		Iterator <Character> iter = charCount.keySet().iterator();
		int placesLeft = ( r - l ) / 2;
		while ( iter.hasNext() ){
			char c = iter.next();
			int num = charCount.get(c);
			if ( num > 1 ){
				num = num / 2;
				int possibilities = ( factorial(placesLeft)/ ( factorial (placesLeft - num ) * factorial ( num ) ) ) % 1000000007;
				result += possibilities;
				placesLeft -= num;
			}
		}
		return result;
	}
	
    static int factorial ( int n ) {
        if ( n <= 1 ) return 1;
        return n * factorial ( n - 1 );
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
