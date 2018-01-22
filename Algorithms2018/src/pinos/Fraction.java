package pinos;

import java.util.HashMap;
//https://www.interviewbit.com/problems/fraction/

public class Fraction {
	public String fractionToDecimal(int A, int B) {

		if ( A == 0 ) return "0";

		long integer = Math.abs((long) A/ (long) B);
		String integerString=String.valueOf(integer);
		StringBuffer decimalPartBuffer = new StringBuffer();

		if ( ( A<0 && B>0) || (A>0 && B < 0 )) integerString= "-" + integerString;

		long remainder = (long) Math.abs(A%B);
		long positiveB = (long)Math.abs(B);

		if ( remainder == 0) return integerString;

		HashMap <Long, Integer> remaindersSeen = new HashMap <Long, Integer> ();
		remaindersSeen.put(remainder,0);

		int pos = 1;
		while (true){
			long newNumerator = remainder*10;
			long newDigit = Math.abs(newNumerator/positiveB);

			decimalPartBuffer.append(newDigit);

			remainder = newNumerator%positiveB;

			if (remainder==0) break;

			if (remaindersSeen.containsKey (remainder)){
				decimalPartBuffer.insert (remaindersSeen.get(remainder),"(");
				decimalPartBuffer.append(")");
				break; 
			}
			remaindersSeen.put(remainder,pos++);
		}
		return integerString + "." + decimalPartBuffer.toString();

	}
	public static void main(String[] args) {
		int A =87;
		int B = 22;
		
		String result = new Fraction().fractionToDecimal(A, B);
		System.out.println(result);
				

	}

}
