package pinos;

import java.util.Stack;

public class RedundantBraces {
	public int braces(String A) {
		Stack <Integer> s = new Stack <Integer> ();
		int prevPosOpenBracket = -1;
		int prevPosCloseBracket = -1;

		for ( int i = 0 ; i < A.length(); i++){
			char c = A.charAt(i);
			if ( c == '(')
					s.push(i);
			if ( c == ')'){
				int posOpenBracket = s.pop();
				int posCloseBracket = i;
				// System.out.println (prevPosOpenBracket + " " + posOpenBracket);
				// System.out.println (posCloseBracket + " " + prevPosCloseBracket);

				if (  prevPosOpenBracket - posOpenBracket == 1 && posCloseBracket - prevPosCloseBracket == 1) return 1;   
				if ( posCloseBracket - posOpenBracket <= 2) return 1;
				prevPosOpenBracket = posOpenBracket;
				prevPosCloseBracket = posCloseBracket;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
