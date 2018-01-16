package pinos;

import java.util.ArrayList;

public class MaxNonNegativeSubArray_OK {

	public ArrayList<Integer> maxset(ArrayList<Integer> A) {

		long maxSumSoFar = -1L;
		long currentSum = 0L;
		java.util.ArrayList <Integer> currentSequence = new java.util.ArrayList <Integer> ();
		java.util.ArrayList <Integer> maxSequenceSoFar = new java.util.ArrayList <Integer> ();
		
		boolean sequenceActive = false;
		A.add(-1);
		for ( int i = 0; i < A.size(); i++){
			int value = A.get(i);
			if ( value >= 0 ){
				if ( !sequenceActive ){
					sequenceActive = true;
					currentSum = 0L;
					currentSequence = new java.util.ArrayList <Integer> ();
				}

				currentSum += (long) value;
				currentSequence.add ( value );
			}
			else {
				if ( !sequenceActive )
					continue;
				else {
					sequenceActive = false;

					if ( currentSum > maxSumSoFar ){
						// This is the new greatest sum.
						maxSumSoFar = currentSum;
						maxSequenceSoFar = currentSequence;
					}
					else if ( currentSum == maxSumSoFar ){
						if ( currentSequence.size() > maxSequenceSoFar.size()){
							maxSequenceSoFar=currentSequence;
						}
							
					}
				}
			}
		}

		return maxSequenceSoFar;

	}

	public static void main(String[] args) {
		ArrayList <Integer> aL = new ArrayList <Integer> (java.util.Arrays.asList( 1967513926, 1540383426, -1303455736, -521595368));
		ArrayList <Integer> result = new MaxNonNegativeSubArray_OK().maxset(aL);
		System.out.println(result);
	}

}
