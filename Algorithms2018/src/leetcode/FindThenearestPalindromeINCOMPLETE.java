package leetcode;

//https://leetcode.com/problems/find-the-closest-palindrome/description/
// Hard problem.
// Specially if the number is already a palindrome.
// For example: 110000011 -> 109999901.

public class FindThenearestPalindromeINCOMPLETE {

	class Solution {
	    public String nearestPalindromic(String n) {
	        if ( n.length() == 1) {
	            if ( n.equals("0")) return "1";
	            int d = n.charAt(0) - '0';
	            d=d-1;
	            return d + "";
	            
	        }
	        
	        char [] nA = n.toCharArray ();
	        
	        for ( int i = 0; i < nA.length/2; i++){
	            int big = nA [ i ] - '0';
	            int small = nA [ nA.length - i - 1 ] - '0';
	            if ( big != small){
	                nA [ nA.length - i - 1 ] = nA [ i ];
	            }
	        }
	        return new String ( nA );
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
