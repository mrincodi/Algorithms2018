package pinos;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/ways-to-decode/
// My solution. Can be improved to remove some redundant code.
// Also, an array is not really needed for the result.
// Only having the two previous results at anytime is enough.

public class WaysToDecode {

	public int numDecodings(String A) {
		ArrayList <Integer> aux = new ArrayList <Integer> ();
		int i = 0;
		
		if ( A.length() == 0) return 0;
		if ( A.charAt(0)=='0') return 0;

		if ( A.length() == 1) return 1;
		
		while ( i < A.length()-1) {
			char thisChar = A.charAt(i);
			char nextChar = A.charAt(i+1);
			if ( thisChar == '0') return 0;
			if ( nextChar == '0') {
				if ( thisChar != '1' && thisChar != '2') return 0;
				int num = Integer.parseInt(thisChar + "0");
				aux.add(num);
				i=i+2;
			}
			else {
				int num = Integer.parseInt(thisChar + "");
				aux.add(num);
				i=i+1;
			}
		}
		
		//System.out.println();
		//Check the last entry.
		if ( i == A.length() -1) {
			if ( A.charAt(A.length()-1) == '0') return 0;
			aux.add(Integer.parseInt(A.charAt(A.length()-1)+""));
		}
		
		//Now, let's evaluate aux.
		ArrayList <Integer> result = new ArrayList <Integer> ();
		
		// First number.
		result.add(1);
		
		for ( i = 1; i < aux.size(); i++) {
			int num = aux.get(i);
			int prevNum = aux.get(i-1);
			
			if ( num < 10) {
				if ( prevNum < 10) {
					if ( prevNum * 10 + num <= 26) {
						if (i == 1)result.add(2);
						else result.add(result.get(i-1)+result.get(i-2));
					}
					else result.add(result.get(i-1));
				}
				else result.add(result.get(i-1));
			}
			else result.add(result.get(i-1));
		}
		
		
		return result.get(result.size()-1);
	}


	public static void main(String[] args) {
		String s = "92";
		
		WaysToDecode wtd = new WaysToDecode();
		
		int w = wtd.numDecodings(s);
		//2611055971756562
		
		System.out.println(w);

	}

}
