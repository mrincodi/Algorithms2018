package interv.g.i2;

// Give the result of a formula using a stack.
// This is the idea... (unfinished).
// Asked on 2018-07-24.

public class Formula {

	public double solveFormula ( String s ){
		double result = 0;

		java.util.Stack < String > stack = new java.util.Stack < String > ();

		String numS = ""; 
		int i = 0;
		
		while ( i < s.length()){
			char c = s.charAt(i);

			if ( c >= '0' && c <= '9'){

				numS = getNumber(s, i);
				
				stack.push(numS);
				
				i = i + numS.length();
			}

			else if ( c == '*' ){
				double num1 = Double.parseDouble(numS);

				// Get the second number.
				numS = stack.pop();
				
				i = i + numS.length();

			}
		}

		return result;
	}

	String getNumber ( String s, int i ){
		String result = "";
		
		while ( i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
			result = result + s.charAt(i);
			i++;
		}
		
		return result;
	}


	public static void main(String[] args) {


	}

}
