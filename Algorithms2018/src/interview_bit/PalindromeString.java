package interview_bit;

//https://www.interviewbit.com/problems/palindrome-string/
//I didn't know there was a method "isLetterOrDigit" in Character.

public class PalindromeString {

	Character INVALID_CHAR = '*';
	public int isPalindrome(String A) {
		if (A.length() <= 1 ) return 1;

		int start = 0;
		int end = A.length () - 1;

		while ( start < end){
			Character cS = A.charAt (start);
			cS = validateChar (cS);
			if ( cS == INVALID_CHAR ){
				start++;
				continue;
			}

			char cE = A.charAt (end);
			cE = validateChar (cE);
			if ( cE == INVALID_CHAR ){
				end--;
				continue;
			}

			if ( cS != cE ) return 0;
			start++;
			end--;
		}

		return 1;

	}

	Character validateChar ( Character c ){
		Character result = INVALID_CHAR;

		if (c >= 'A' && c <= 'Z')
			return Character.toLowerCase(c);

		if ( ( c >= 'a' && c <= 'z' ) || (c >= '0' && c <= '9') )
			return c;

		return INVALID_CHAR;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
