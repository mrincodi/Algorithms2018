package pinos;

import java.util.HashMap;

// https://www.interviewbit.com/problems/palindrome-partitioning-ii/
public class PalindromePartitioningII {

	HashMap <String, Integer> minCuts = new HashMap <String, Integer> ();

	public int minCut(String A) {
		if (minCuts.containsKey (A)) return minCuts.get(A);

		int result = A.length();
		if ( isPalindrome (A)) {
			minCuts.put (A,0);
			return 0;
		}

		for ( int i = 1; i < A.length(); i++){
			String substring = A.substring (0,i);
			if ( isPalindrome (substring)){
				int partialResult = minCut(A.substring (i));
				result = Math.min (result, 1 + partialResult);
			}
		}

		minCuts.put (A,result);
		return result;
	}

	public boolean isPalindrome (String s){
		if ( s== null || s.length() <=1) return true;

		for ( int i = 0; i <s.length()/2; i++){
			if (s.charAt(i) != s.charAt (s.length() - 1 - i)) return false;
		}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
