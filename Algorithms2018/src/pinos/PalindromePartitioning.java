package pinos;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/palindrome-partitioning/

public class PalindromePartitioning {

	public ArrayList<ArrayList<String>> partition(String a) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if ( a.length() == 0 ){
			return result;
		}
		for ( int i = 1; i < a.length();i++){
			String substring = a.substring (0,i);
			if ( isPalindrome (substring)){
				// Calculate the rest of substrings:
				ArrayList<ArrayList<String>> partialResult = partition (a.substring(i));

				for (int subsetsIndex = 0; subsetsIndex < partialResult.size(); subsetsIndex++){
					partialResult.get(subsetsIndex).add(0,substring);
					result.add (partialResult.get(subsetsIndex));
				}
			}
		}

		//Now, for the whole word.
		if (isPalindrome(a)){
			result.add(new ArrayList<String>(Arrays.asList(a)));
		}
		return result;
	}

	boolean isPalindrome (String s){
		for ( int i = 0; i < s.length() /2; i++)
			if (s.charAt(i) != s.charAt (s.length() - 1 - i)) return false;

		return true;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
