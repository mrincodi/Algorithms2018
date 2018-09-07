package leetcode;

// https://leetcode.com/problems/sort-colors/description/
// Cute. Could have been done (as always) less verbose.
// Counting the numbers was also constant space, but
// this is what they wanted.
// 2018-08-20
public class SortColors {

	    public void sortColors(int[] nums) {
	        int st1 = -1, st2 = -1;
	        
	        for ( int i = 0; i < nums.length; i++ ){
	            int n = nums [ i ];
	            
	            if ( n == 2 ) {
	                if ( st2 == -1 ) st2 = i;
	            }
	            else if ( n ==1 ){
	                if ( st1 == -1 ){
	                    st1 = i;
	                    if ( st2 != -1 ){
	                        nums [ i ] = 2;
	                        nums [ st2 ] = 1;
	                        st1 = st2;
	                        st2++;
	                    }
	                }
	                else {
	                    if ( st2 != -1 ){
	                        nums [ i ] = 2;
	                        nums [ st2 ] = 1;
	                        st2++;
	                    }
	                }
	            }
	            else { // It's 0.
	                if      ( st1 == -1 && st2 == -1 ) ;
	                else if ( st1 == -1 && st2 != -1) {
	                    nums [ i ] = 2;
	                    nums [ st2 ] = 0;
	                    st2++;
	                }
	                else if ( st1 != -1 && st2 == -1) {
	                    nums [ i ] = 1;
	                    nums [ st1 ] = 0;
	                    st1++;
	                }
	                else {
	                    nums [ i ] = 2;
	                    nums [ st2 ] = 1;  
	                    st2++;
	                    nums [ st1 ] = 0;
	                    st1++;
	                }
	            }
	        }
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
