package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/split-array-with-same-average/description/
// VEERY difficult. This "solution" fails with array [10,29,13,53,33,48,76,70,5,5].

public class SplitWithSameAverageWRONG {

	public boolean splitArraySameAverage(int[] A) {
		if ( A.length <=1 ) return false;
		if ( A.length == 2 ) return A[0]==A[1];

		Arrays.sort (A);
		int inf = 0;
		int sup = A.length - 1;
		double outerSum = (double) ((double)(A[inf]) + (double)(A[sup]));
		double outerAverage = (double) outerSum / (double) ( (inf + 1 ) + (A.length - sup));

		double innerSum = 0;
		for ( int i = inf + 1; i < sup; i++ ){
			innerSum += A[i];
		}
		double innerAverage = innerSum / (double) (sup - inf - 1);

		while ( inf < sup - 1){
			if (outerAverage == innerAverage) return true;
			if (outerAverage < innerAverage){
				sup--;
				outerSum += (double)A[sup];
				innerSum -= (double)A[sup];
			}
			else {
				inf++;  
				outerSum += (double)A[inf];
				innerSum -= (double)A[inf];
			}
			outerAverage = outerSum / (double) ( (inf + 1 ) + (A.length - sup));
			innerAverage = innerSum / (double) (sup - inf - 1);
		}

		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
