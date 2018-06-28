package pinos;

import java.util.ArrayList;
import java.util.Arrays;

// Just a version of Kadane's that gives you the indexes of the positions 
// that limit the array with the largest sum, and the actual sum.

public class KadaneExtended {

	public static int [] limitsForBestSum (ArrayList < Integer > numbers){
		int [] result = new int [ 3 ];
		if ( numbers.size() == 1){
			return result;
		}
		
		int maxSum = numbers.get(0);
		int maxStart = 0;
		int maxEnd = 0;
		int prevSum = maxSum;
		int prevStart = 0;
		
		for ( int i = 1; i < numbers.size(); i++){
			int thisSum = 0;
			int thisStart = 0;
			int thisEnd = 0;
			
			int number = numbers.get(i);
			
			if ( number > number + prevSum ){
				thisSum = number;
				thisStart = i;
				thisEnd = i;
			}
			else {
				thisSum = number + prevSum;
				thisStart = prevStart;
				thisEnd = i;
			}
			
			// Are we the largest sum so far?
			if ( thisSum > maxSum ){
				maxSum = thisSum;
				maxStart = thisStart;
				maxEnd = thisEnd;
			}
			
			System.out.println (maxSum);
			
			prevSum = thisSum;
			prevStart = thisStart;
		}
		
		result [ 0 ] = maxStart;
		result [ 1 ] = maxEnd;
		result [ 2 ] = maxSum;
		
		return result;
	}

	public static void main(String[] args) {
		ArrayList < Integer > numbers = new ArrayList < Integer > ( Arrays.asList( -80,-91,86,14,-58,-73,36,71,-22,92,-21,-89,-53,67,100,19,31,-100,3,-19,85,45,-21,-34,1,-24,8,10,-19,-9,-4,13,60,-22,-83,54,-46,-28,46,-45,-5,67,-67,91,40,-43,82,75,-94,-80,-48,55,41,83,16,-76,75,-39,-80,82,-84,32,-27,24,-73,-24,30,-40,-89,64,26,-56,4,32,-5,-13,-46,-54,1,28,11,77,94,-46,18,80,49,-9,34,-81,-34,89,-78,58,10,-20,65,67,-12,42));

		int [] result = KadaneExtended.limitsForBestSum(numbers);
		System.out.println ( result [ 0 ] + " to " + result [ 1 ] + ", which gives " + result [ 2 ]);
		
	}

}
