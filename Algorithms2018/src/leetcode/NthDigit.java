package leetcode;

// https://leetcode.com/problems/nth-digit/description/
// Easy? Not at all! Very tricky!

public class NthDigit {

    public int findNthDigit(int n) {
        
        if ( n <= 9 ) return n;
        
        //First, find out the "bucket".
 
        long bucket = 1;
        long m = (long) n;
        long prevM = m;

        while ( m > 0 ){
            prevM=m;
            m = m - 9 * (long) Math.pow (10,bucket-1) * bucket;
            bucket++;
        }
        
        bucket--;
        m = prevM - 1;
        long index = m / bucket;
        long digit = m % bucket;
        
        long num = (long) Math.pow (10,bucket - 1) + index;		
        int result = String.valueOf(num).charAt((int)digit) - '0';
        
        return result;
    }
    
	public static void main(String[] args) {
		NthDigit nd = new NthDigit();
		
		int d = nd.findNthDigit(1000000000	);
		System.out.println(d);

	}

}
