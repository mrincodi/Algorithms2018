package leetcode;

// https://leetcode.com/problems/counting-bits/description/
// Cool answer: from:
// https://www.programcreek.com/2015/03/leetcode-counting-bits-java/

public class CountBits {

	    public int[] countBits(int num) {
	        int [] result = new int [ num + 1 ];
	        for ( int i = 0; i <= num; i ++){
	            int n = i;
	            while ( n > 0 ){
	                int bit = n % 2;
	                result [ i ] = result [ i ] + bit;
	                n = n / 2;
	            }
	        }
	        return result;
	    }
	    
	    public int[] countBitsCool(int num) {
	        int[] result = new int[num+1];
	     
	        int p = 1; //p tracks the index for number x
	        int pow = 1;
	        for(int i=1; i<=num; i++){
	            if(i==pow){
	                result[i] = 1;
	                pow <<= 1;
	                p = 1;
	            }else{
	                result[i] = result[p]+1;
	                p++;
	            }
	     
	        }
	     
	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
