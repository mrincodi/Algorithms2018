package interview_bit;

// https://www.interviewbit.com/problems/longest-palindromic-substring/
// Works but takes too long for InterviewBit. Perhaps because of the "#".

public class LongestPalindromicSubstring {

	public String longestPalindrome(String A) {

		if ( A == null || A.length() <= 1 ) return A;

		String result = A.charAt(0) + "";

		String AA = "#";

		for ( char c: A.toCharArray() ){
			AA = AA + c;
			AA = AA + '#';
		}

		for ( int i = 2; i < AA.length() - 2; i++){

			int legSize = i%2==0?1:2;

			String thisPalindrome = i%2==0?"":AA.charAt(i)+"";

			while ( legSize <= i && 
					legSize + i < AA.length () &&
					AA.charAt ( i - legSize ) == AA.charAt ( i + legSize ) ){

				thisPalindrome = AA.charAt ( i - legSize ) + thisPalindrome + AA.charAt ( i + legSize );
				legSize = legSize + 2;
			}

			if ( thisPalindrome.length() > result.length() )
				result = thisPalindrome;
		}

		String realResult = result;

		// for (char c: result.toCharArray()){
		//     if ( c != '#')
		//         realResult = realResult + c;
		// }

		/*
	        //Now, the even-sized palindromes.
	        for ( int i = 0; i < A.length() - 1; i++){

	            int legSize = 1;

	            String thisPalindrome = "";


	            while ( i - legSize + 1 >= 0 && 
	                legSize + i < A.length () &&
	                A.charAt ( i - legSize ) == A.charAt ( i + legSize ) ){

	                thisPalindrome = A.charAt ( i - legSize + 1 ) + thisPalindrome + A.charAt ( i + legSize );
	                legSize++;

	            }

	            if ( thisPalindrome.length() > result.length() )
	                result = thisPalindrome;
	        }
		 */

		return realResult;
	}

	public static void main(String[] args) {
		String s = "abb";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		
		System.out.println (lps.longestPalindrome(s));
		
	}

}
