package pinos;

import java.util.ArrayList;
import java.util.List;

// https://www.interviewbit.com/problems/median-of-array/#
// This solves the problem in the old "like mergesort merges" way.

public class MedianOfArrayBruteForce {
	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		ArrayList < Integer> resultArray = new ArrayList < Integer> ();

		int totalSize = a.size() + b.size();
		int midSize = totalSize / 2;

		int indexA = 0, indexB = 0;
		double result = 0, prevResult = 0;

		for ( int i = 0; i <= midSize; i++){
			prevResult = result;

			if ( indexA == a.size()){
				result = b.get(indexB);
				indexB++;
			}
			else if ( indexB == b.size()){
				result = a.get(indexA);
				indexA++;
			}
			else {
				if (a.get(indexA) < b.get(indexB)){
					result = a.get(indexA);
					indexA++;
				}
				else {
					result = b.get(indexB);
					indexB++;
				}
			}
		}

		if ( totalSize%2 == 0) result = (result + prevResult )/2; 

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
