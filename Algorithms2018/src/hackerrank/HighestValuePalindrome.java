package hackerrank;

// https://www.hackerrank.com/challenges/richie-rich/problem
// Such an annoying problem... Not easy.
public class HighestValuePalindrome {

	
    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        // I don't understand why we're given n when we're given s, but I
        // will start by filling it up with zeros to the left in case 
        // n > s.length().
        
        String result = "";
        
        if ( n < s.length() ) n = s.length(); // This shouldn't happen.
        if ( s.length () < n){
            for (int i = 1; i <= n - s.length(); i++){
                s = "0" + s;
            }
        }
        
        int [] numbers = new int [ s.length()];
        for ( int i = 0; i < s.length(); i++){
            numbers [ i ] = s.charAt(i) - '0';
        }
        
        // All-right. Now, find out how many differences are there.
        int diffCouples = 0;
        int diffFrom9 = 0;	// I ended not needing this variable in the end.
        int size = numbers.length;
        for ( int i = 0; i < size / 2; i++ ){
            if ( numbers [ i ] != numbers [ size - i - 1 ] ){
                diffCouples++;
                if ( numbers [ i ] != 9 ) diffFrom9++;
                if ( numbers [ size - i - 1  ] != 9 ) diffFrom9++;   
            }
        }
        // First check.
        if ( diffCouples > k) return "-1";
        
        // We will play with k, diffCouples and diffFrom9.
        for ( int i = 0; i < size / 2; i++){
            int j = size - i - 1;
            int a = numbers [ i ];
            int b = numbers [ j ];
            
            if ( a == b ){
                if ( a == 9 ) continue; // ideal case.
                
                // Should we change both to 9? Only if we will have changes left.
                if ( k >= diffCouples + 2){ // If we have at least 2 extra chances to spare here.
                    numbers [ i ] = 9;
                    numbers [ j ] = 9;
                    k -=2;
                }
                // else ignore them. We can't afford to make both of them 9's.
            }
            else {
                diffCouples--; // We are the different couple.
                // 3 possibilities:
                // Make both 9.
                // Make both the largest of the 2.
                // Return -1 if we're out of options.
                
                // First of all, if one of them is 9, just make the other one 9, and continue.
                if ( a == 9 || b == 9) {
                    numbers [ i ] = 9;
                    numbers [ j ] = 9;
                    k--;
                    diffFrom9--;
                }
                else {
                    diffFrom9 -= 2;
                    // Both are different among themselves, and different from 9.
                    // Can we afford to make both of them 9?
                    if (  k >= diffCouples + 2){ // If we have at least 2 extra tokens to spare here.
                        numbers [ i ] = 9;
                        numbers [ j ] = 9;
                        k -=2;
                    }
                    else {
                        // k == diffCouples + 1
                        // Bummer. We need to transform the smallest one into the largest one.
                        numbers [ i ] = Math.max ( a, b );
                        numbers [ j ] = Math.max ( a, b );
                        k -= 1;
                    }                    
                }
            }
            if ( diffCouples > k ) return "-1";
        }
        
        // We have to consider a last case: if n is odd and we still have tokens.
        if ( k > 0 && numbers [ size / 2 ] < 9) {
            numbers [ size / 2 ] = 9;
            k--;    // Not that it matters anymore.
        }
        
        // Make a new string.
        
        for ( int nn : numbers){
            result = result + nn;	// Yeah, it's better with StringBuffer.
        }
        return result;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
