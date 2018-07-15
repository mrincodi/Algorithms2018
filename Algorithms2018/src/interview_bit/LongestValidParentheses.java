package interview_bit;

// https://www.interviewbit.com/problems/longest-valid-parentheses/
// NOT WORKING. DISMISS.
public class LongestValidParentheses {

	    public int longestValidParentheses(String A) {
	        
	        int [] array = new int [ A.length () ];
	        
	        int result = 0;
	        for ( int i = 0; i < A.length (); i++ ){
	            char c = A.charAt ( i );
	            if ( c == ')'){
	                if ( i == 1 ) {
	                    if ( A.charAt (0) == '(' ) array [ 1 ] = 2;
	                }
	                else if ( i > 1 ){
	                    if ( A.charAt ( i - 1 ) == '(' ){
	                        array [ i ] = array [ i - 2 ] + 2;
	                    }
	                    else {
	                        
	                        // Else if s[i-1] is ‘)’ and s[i-longest[i-1]-1] == ‘(‘, longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]    
	                        if ( A.charAt ( i - 1 ) == ')' && 
	                            array [ i - array [ i - 1 ] - 1 ] == '(' ){
	                            array [ i ] = array [i-1] + 2 + array[i-array[i-1]-2];
	                        }
	                    }
	                }
	            }
	            result = Math.max ( array [ i ], result );
	        }
	        
	        return result;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
