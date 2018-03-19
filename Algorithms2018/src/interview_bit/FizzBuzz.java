package interview_bit;

//https://www.interviewbit.com/problems/fizzbuzz/
import java.util.ArrayList;

public class FizzBuzz {

	    public ArrayList<String> fizzBuzz(int A) {
	        
	        java.util.ArrayList <String> result = new java.util.ArrayList <String> ();
	        
	        for ( int i = 1; i <= A; i++){
	            String s = String.valueOf (i);
	            
	            if ( i % 3 == 0 ) s = "Fizz";
	            if ( i % 5 == 0 ) s = "Buzz";
	            if ( i % 3 == 0 && i % 5 == 0) s = "FizzBuzz";
	            
	            result.add (s);
	        }
	        
	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
