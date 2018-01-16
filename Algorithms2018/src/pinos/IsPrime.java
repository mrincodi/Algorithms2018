package pinos;

// https://www.interviewbit.com/problems/palindrome-integer/

public class IsPrime {

	public int isPalindrome(int A) {
		int l = String.valueOf(A).length();
		if ( l == 1 ) return 1;

		for (int i = 0; i < l/2; i++){
			int lower = ( A / (int)Math.pow(10,i) ) % 10;;
			int upper = ( A / (int)Math.pow (10,l-i-1) ) % 10;
			if ( lower != upper ) return 0; 
		}
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
