package pinos;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/longest-common-prefix/

public class LongestCommonPrefix {


	public String longestCommonPrefix(ArrayList<String> A) {
		String result = "";
		if ( A.size() == 0 ) return result;

		for (int charIndex = 0; charIndex < A.get(0).length();charIndex++){
			char character = A.get(0).charAt(charIndex);

			//Look at the other words
			for ( int i = 1; i < A.size(); i++){

				if (A.get(i).length() == charIndex || A.get(i).charAt(charIndex) != character ) return result;
			}
			result += character;
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
