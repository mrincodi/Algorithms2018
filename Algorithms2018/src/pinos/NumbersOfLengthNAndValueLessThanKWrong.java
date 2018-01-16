package pinos;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/
// A VERY CHALLENGING problem!! My solution doesn't work.

public class NumbersOfLengthNAndValueLessThanKWrong {

	    public int solve(ArrayList<Integer> A, int B, int C) {

	        int CLength = String.valueOf(C).length();
	        if ( B < CLength ) return 0;
	        if ( B > CLength ) {
	            if ( A.get(0) != 0)
	                return (int) Math.pow (A.size(),B);
	            else return (A.size() -1 ) * (int) Math.pow (A.size(),B-1);
	        }
	        
	        return recursive (A,B,C, true);
	    }
	   
	    int recursive (ArrayList<Integer> A, int B, int C, boolean first){
	        int result = 0;
	        if ( B == 1 ){
	            //Just count how many less than this number
	            for ( int val:A)
	                if ( val < C) result++;
	            
	            return result;
	        }
	        int howManyLess = 0;
	        boolean isDigitThere = false;
	        int digit = (C / ( (int) Math.pow (10,B-1)))%10;
	        
	        //Find how many less than this value
	        for ( int val:A){
	            if (first && val == 0) continue;
	            if ( val < digit) howManyLess++;
	            if ( val == digit ) isDigitThere = true;
	        }
	        
	        result += recursive (A, B -1, C, false) + howManyLess;
	        
	        return result;
	    }


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
