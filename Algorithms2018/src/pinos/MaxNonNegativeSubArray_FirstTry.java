package pinos;

import java.util.ArrayList;

public class MaxNonNegativeSubArray_FirstTry {

	public ArrayList<Integer> maxset(ArrayList<Integer> A) {

		int currentStartIndex = 0;
		long maxSumSoFar = -1L;
		long currentSum = 0L;
		java.util.ArrayList <Integer> currentSequence = new java.util.ArrayList <Integer> ();
		java.util.LinkedHashMap <Integer, ArrayList <Integer>> candidates = new java.util.LinkedHashMap <Integer, ArrayList <Integer>> ();

		boolean sequenceActive = false;
		A.add(-1);
		for ( int i = 0; i < A.size(); i++){
			int value = A.get(i);
			if ( value >= 0 ){
				if ( !sequenceActive ){
					currentStartIndex = i;
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
						candidates = new java.util.LinkedHashMap <Integer, ArrayList <Integer>> ();
						candidates.put (currentStartIndex, currentSequence);
					}
					else if ( currentSum == maxSumSoFar ){
						candidates.put (currentStartIndex, currentSequence);
					}
				}
			}
		}

		// Now return the right value.

		java.util.Iterator <Integer> iter = candidates.keySet().iterator();

		int longestCandidateSize = 0;
		ArrayList<Integer> result = new ArrayList<Integer> ();

		while (iter.hasNext()){
			ArrayList<Integer> thisCandidate = candidates.get(iter.next());
			if (thisCandidate.size() > longestCandidateSize){
				longestCandidateSize = thisCandidate.size();
				result = thisCandidate;
			}
		}

		return result;

	}

	public static void main(String[] args) {
		ArrayList <Integer> aL = new ArrayList <Integer> (java.util.Arrays.asList( 1967513926, 1540383426, -1303455736, -521595368));
		ArrayList <Integer> result = new MaxNonNegativeSubArray_FirstTry().maxset(aL);
		System.out.println(result);
	}

}
