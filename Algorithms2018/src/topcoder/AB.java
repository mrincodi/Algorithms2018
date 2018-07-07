package topcoder;

// https://community.topcoder.com/stat?c=problem_statement&pm=13642
// This problem is   A M A Z I N G.

public class AB {

	public String createString ( int n, int k ){

		if ( ( n % 2 == 0 && k > (n/2)*(n/2) ) || k > (n/2)*((n/2) + 1 )){
			return "";
		}

		boolean [] array = new boolean [ n ];
		// false = A . true = B.

		if ( k <= 0 ){} // Result is fine as it is. 
		else {
			int numBs = 1;

			while ( numBs <= n / 2 ){
				int limit = numBs * ( n - numBs );
				if ( limit >= k ) break; 
				array [ n - numBs  ] = true;
				numBs++;
			}

			// Calculate the difference and put the missing B in the right place.
			numBs--;	// This should be the number of B's at the end.
			int val = k - ( numBs * ( n - numBs - 1) ); // This is the B that should be on.
			array [ val ] = true;

		}

		return toString ( array );
	}
	
	private String toString(boolean[] array) {
		String s = "";
		for ( boolean b: array ){
			char c = b?'B':'A';
			s=s+c;
		}
		return s;
	}
	
	public static void main(String[] args) {
		int n = 1000;
		int k = 50560;
		
		AB ab = new AB();
		
		System.out.println ( ab.createString(n, k));

	}

}
