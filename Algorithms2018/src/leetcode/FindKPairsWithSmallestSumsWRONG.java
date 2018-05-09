package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
// Forget it. This method doesn't work.

public class FindKPairsWithSmallestSumsWRONG {

	public List<int[]> kSmallestPairs(int[] A, int[] B, int k) {
		ArrayList <int[]> result = new ArrayList <int[]>();
        if ( A.length == 0 || B.length == 0 ) return result;
		int []array = { A[0], B[0] };
		result.add(array);
		
		if ( A.length == 1 && B.length == 1) return result;
		
		if (A.length == 1){
			for ( int i = 1; i < B.length; i++ ){
				array = new int [ 2 ];
				array [ 0 ] = A [ 0 ];
				array [ 1 ] = B [ i ];
				result.add ( array );
			}
			return result;
		}
		
		if (B.length == 1){
			for ( int i = 1; i < A.length; i++ ){
				array = new int [ 2 ];
				array [ 0 ] = A [ i ];
				array [ 1 ] = B [ 0 ];
				result.add ( array );
			}
			return result;
		}
		
		int posASum1 = 0;
		int posBSum1 = 1;
		int posASum2 = 1;
		int posBSum2 = 0;

		HashSet <String> already = new HashSet <String> ();
		already.add (A[0] + "_" + B[0]);

		for ( int i = 1; i < Math.min(k, A.length * B.length) ; i++){
			//Compare sums.
			//If pos. are the same, just add value and continue.

			boolean increasePosSum1 = false;
			boolean increasePosSum2 = false;

			if ( posASum1 == posASum2 && posBSum1 == posBSum2){
				array = new int [ 2 ];
				array [0]= A[posASum1];
				array [1]= B[posBSum1];
				result.add ( array );

				already.add (posASum1 + "_" + posBSum1);

				increasePosSum1 = true;
				increasePosSum2 = true;
			}
			else {
				int sum1 = A[posASum1] + B[posBSum1];
				int sum2 = A[posASum2] + B[posBSum2];

				if ( sum1 < sum2 ){
					array = new int [ 2 ];
					array [0]= A[posASum1];
					array [1]= B[posBSum1];
					result.add ( array );                    

					already.add (posASum1 + "_" + posBSum1);
					increasePosSum1 = true;
				}
				else {
					array = new int [ 2 ];
					array [0]= A[posASum2];
					array [1]= B[posBSum2];
					result.add ( array );    

					already.add (posASum2 + "_" + posBSum2);
					increasePosSum2 = true;
				}

				//Finally, increase positions.
				if ( increasePosSum1 ){
					int [] newPos1 = increasePos (1, A, B, posASum1, posBSum1, already);
					posASum1 = newPos1[0];
					posBSum1 = newPos1[1];
					
					if ( posASum1 == A.length || posBSum1 == B.length) 
						return result;
				}


				if ( increasePosSum2 ){
					int [] newPos2 = increasePos (2, A, B, posASum2, posBSum2, already);
					posASum2 = newPos2[0];
					posBSum2 = newPos2[1];
					

					if ( posASum2 == A.length || posBSum2 == B.length)
						return result;
				}
			}
		}     
		return result;
	}

	int [] increasePos (int whichSum, int [] A, int [] B, int posA, int posB, HashSet <String> already){

		int [] result = new int [ 2 ];
		int i = posA;
		int j = posB;    

		if ( whichSum == 1){

			i = posA;
			j = posB;            
			while ( i < A.length){
				while (j < B.length){

					if ( !already.contains (i + "_" + j)){
						result [ 0 ] = i;
						result [ 1 ] = j;
						return result;
					}
					j++;
				}
				i++;
				j = 0;
			}
		}
		else {
			i = posA;
			j = posB;            
			while (j < B.length){

				while ( i < A.length){

					if ( !already.contains (i + "_" + j)){
						result [ 0 ] = i;
						result [ 1 ] = j;
						return result;
					}
					i++;
				}
				j++;
				i = 0;
			}
		}            

		result [ 0 ] = i;
		result [ 1 ] = j;
		return result;

	}


	public static void main(String[] args) {

		FindKPairsWithSmallestSumsWRONG fk = new FindKPairsWithSmallestSumsWRONG();
		int [] A = { 1, 2, 3, 4, 5 };
		int [] B = { 3, 4 , 5, 6};
		int k = 300;
		List<int[]> res = fk.kSmallestPairs(A, B, k);
		
		for ( int [] pair: res){
			System.out.println(pair[0] + ", " + pair [ 1 ]);
		}


	}

}
