package interview_bit;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/multiply-strings/
// Long and not complicated, yet important, problem.
// This can be done much less verbose!

public class MultiplyStrings {

	public String multiply(String A, String B) {

		// We create an array of arrays of digits.
		// After all the levels have
		// been multiplied, we'll add them up.

		if ( A.equals ("0") || B.equals ( "0") ) return "0";

		ArrayList < ArrayList < Integer > > levels = new ArrayList < ArrayList < Integer > > ();

		ArrayList < Integer > ADigits = new ArrayList < Integer > ();

		for ( int i = 0; i < A.length(); i++ ){
			int d = A.charAt (A.length () - i - 1 ) - '0';
			ADigits.add (d);
		}

		for ( int i = 0; i < B.length(); i++){

			int d = B.charAt (B.length () - i - 1 ) - '0';

			// Multiply level
			ArrayList < Integer > level = multiply ( d, ADigits, i );

			levels.add (level);
		}

		//Finally, add the levels.
		ArrayList < Integer > resultA = addLevels (levels);

		//Convert into String.
		String result = "";

		for (int i = 0; i < resultA.size(); i++ ){
			result = resultA.get(i ) + result;
		}

		// remove trailing zeroes (just in case).
		while ( result.charAt ( 0 ) == '0' )
			result = new String ( result.substring ( 1 ));

		if ( result.length() == 0 ) return "0"; //Shouldn't happen.

		return result;

	}

	ArrayList < Integer > multiply ( int b, ArrayList < Integer> ADigits, int l ){

		// Do the multiplication.
		ArrayList < Integer > result = new ArrayList < Integer > ();

		int carry = 0;

		for ( int i = 0; i < ADigits.size(); i++ ){
			int a = ADigits.get ( i );
			int r = (b * a) + carry;

			result.add (r % 10);
			carry = r / 10;
		}

		if ( carry > 0 ) result.add ( carry );

		// Add the 0's.
		for ( int i = 0; i < l; i++ ){
			result.add (0, 0);
		}

		return result;
	}

	ArrayList < Integer > addLevels (ArrayList < ArrayList <Integer > > levels){

		ArrayList < Integer > result = new ArrayList < Integer > ();
		// Let's calculate the max. length off all the levels.
		int maxSize = 0;
		for ( ArrayList <Integer > l : levels ){
			maxSize = Math.max ( maxSize, l.size());
		}

		// Add zeroes to the left of all the arrays, as needed.
		for ( ArrayList <Integer > l : levels ){
			for ( int i = l.size(); i < maxSize; i++ ){
				l.add ( 0 );
			}
		}

		//Add the values up.
		int carry = 0;
		for ( int i = 0; i < maxSize; i++ ){
			int r = 0;
			for ( int j = 0; j < levels.size(); j++ ){
				r += levels.get(j).get(i);
			}
			r = r + carry;

			result.add ( r % 10 );
			carry = r / 10;
		}

		if ( carry > 0 )
			result.add ( carry );

		return result;
	}







	public static void main(String[] args) {
		String a = "512";
		String b = "64";
		String res = new MultiplyStrings().multiply(a, b);
		
		System.out.println ( res);

	}

}
