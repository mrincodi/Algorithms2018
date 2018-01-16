package pinos;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {

	public ArrayList<Integer> maxset(ArrayList<Integer> A) {

		long maxSumSoFar = -1L;
		long currentSum = 0L;
		java.util.ArrayList <Integer> currentSequence = new java.util.ArrayList <Integer> ();
		java.util.ArrayList <Integer> maxSequenceSoFar = new java.util.ArrayList <Integer> ();

		for ( int i = 0; i < A.size(); i++){
			int value = A.get(i);
			if ( value >= 0 ){
				currentSum += (long) value;
				currentSequence.add ( value );
			}
			else {
				currentSequence = new java.util.ArrayList <Integer> ();
				currentSum=0;
			}

			if ( currentSum > maxSumSoFar || ( currentSum == maxSumSoFar && currentSequence.size() > maxSequenceSoFar.size())){
				// This is the new greatest sum.
				maxSumSoFar = currentSum;
				maxSequenceSoFar = currentSequence;
			}
		}
		return maxSequenceSoFar;
	}

	public static void main(String[] args) {
		ArrayList <Integer> aL = new ArrayList <Integer> (java.util.Arrays.asList(  756898537, -1973594324, -2038664370, -184803526, 1424268980 ));
		ArrayList <Integer> result = new MaxNonNegativeSubArray().maxset(aL);
		System.out.println(result);
	}

}
