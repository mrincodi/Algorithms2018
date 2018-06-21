package leetcode;

//https://leetcode.com/problems/number-of-digit-one/description/
// A very hard problem. Not even half-way here.
public class NumberOfDigitOneINCOMPLETE {

	public int countDigitOne(int n) {
		int result = 0;
		int numDigits = String.valueOf ( n ).length();
		int [] array = new int [ numDigits ];

		if ( numDigits == 1 ){
			return n>=1?1:0;
		}

		array [ 1 ] = 1;
		for ( int i = 2; i <= numDigits; i++ ){
			int k = array [ i ] - 1;
			array [ i ] = (int) Math.pow (10, i) + 9 * k; 
		}

		// Finally, for the rest...
		//TODO!!
		
		return 0;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
