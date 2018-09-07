package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubstringAddsUpTo0 {

	public static ArrayList < Integer > substringAddsUpTo0 ( int [] numbers ){

		ArrayList < Integer > result = new ArrayList < Integer > ();
		HashMap <Integer, Integer > SumToPosition = new HashMap <>();

		int currentSum = 0;
		for ( int i = 0; i < numbers.length; i++ ){
			if ( numbers [ i ] == 0) return new ArrayList < Integer >  ( Arrays.asList (i, i));
			
			currentSum += numbers [ i ];
			if ( SumToPosition.containsKey(currentSum)) 
				return new ArrayList < Integer >  ( Arrays.asList (SumToPosition.get( currentSum ) + 1, i));
			else
				SumToPosition.put(currentSum, i);
			
		}

		return result;
	}

	public static void main(String[] args) {
		int [] numbers = { 9,-6,-8,7,2,-7,2,-5,-2,-1,-9,-8,-2,6,1,-4,-2,1,-5,-2,-1,5,-5,3,-8,-5,-2,5,7,-7,-3,7,7,5,6,-8,7,5,3,6,2,8,-2,-1,2,-1,6,6,6,-8,3,6,8,4,2,9,-7,8,4,8,-6,6,-2,6,6,-4,5,-8,9,-2,-1,7,-2,3,-2,2,4,1,-9,6,9,-5,6,-5,-1,1,-5,2,6,6,6,8,-9};
		
		System.out.println ( substringAddsUpTo0 ( numbers ));

	}

}
