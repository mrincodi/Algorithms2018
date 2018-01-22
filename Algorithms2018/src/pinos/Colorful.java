package pinos;

import java.util.ArrayList;
import java.util.HashSet;

// https://www.interviewbit.com/problems/colorful-number/
// Instead of using strings I could have gotten every digit with % and then divide the number over 10.

public class Colorful {

	    public int colorful(int A) {
	        String stringA = String.valueOf(A);
	        //Generate the subsequences.
	        ArrayList <String> substrings = new ArrayList <String> ();
	        
	        for (int size = 1; size <= stringA.length();size++){
	            for ( int i = 0; i <= stringA.length()-size; i++){
	                String substring = stringA.substring(i,i+size);
	                substrings.add(substring);
	            }
	        }
	        
	        //Now, calculate the products. For now, I will ignore overflows.
	        HashSet <Integer> products = new HashSet <Integer> ();
	        
	        for ( String substring: substrings){
	            int product = 1;
	            for (int i = 0; i < substring.length(); i++){
	                product *= Integer.parseInt (substring.charAt (i) + "");
	            }
	            if ( products.contains (product)) return 0;
	            products.add(product);
	        }
	        return 1;
	    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
