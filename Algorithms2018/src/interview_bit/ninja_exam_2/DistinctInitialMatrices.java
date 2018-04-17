package interview_bit.ninja_exam_2;

import java.util.ArrayList;
import java.util.Arrays;


// https://www.interviewbit.com/problems/distinct-initial-matrices/?test_id=4810

/**
 * 
 * 
 * For a A * B matrix of all distinct numbers from 1 to A * B, we first sort each column and then concatenate all columns in increasing order of indices to form an array of size A * B. Columns are numbered in increasing order from left to right.

For example, if matrix is

[1 5 6]
[3 2 4]

We first sort all columns to get

[1 2 4]
[3 5 6]

Now, we concatenate columns in increasing order of indices to get an array

[1, 3, 2, 5, 4, 6]
Given this final array, you have to count how many distinct initial matrices are possible. Return the required answer modulo 109+7.

Two matrices are distinct if:

Either their dimensions are different.
Or if any of the corresponding row in two matrices are different.
Example:

If input array is [1, 3, 2, 4], distinct initial matrices possible are:

[1 3 2 4]
-----------------------
[1 2]
[3 4]
-----------------------
[1 4]
[3 2]
-----------------------
[3 2]
[1 4]
-----------------------
[3 4]
[1 2]
-----------------------

that is, a total of 5 matrices.

 * @author mrincodi
 *
 */

//  *** UNTESTED ***


public class DistinctInitialMatrices {


	public int cntMatrix(ArrayList<Integer> A) {
		int result = 1;

		for ( int colSize = 2; colSize <= A.size(); colSize++){
			if ( A.size() % colSize == 0 ){
				//Check if the values in the column are in ascending order. This may be optimizable.
				for ( int i = 0; i < A.size() / colSize; i++ ){
					int offset = i * colSize;
					int j = offset;
					boolean valid = true;
					while ( valid && j < offset + colSize - 1){
						if ( A.get(j) > A.get (j+1)) valid = false;
						j++;
					}
					if (valid){
						result += factorial (colSize);
					}
				}
			}
		}
		return result;
	}


	private int factorial(int colSize) {
		return colSize <= 1 ? 1: colSize * factorial (colSize - 1);
	}

	public static void main(String[] args) {
		DistinctInitialMatrices dim = new DistinctInitialMatrices ();
		//System.out.println(dim.factorial (4));
		
		ArrayList<Integer> A = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5,6,0));
		System.out.println(dim.cntMatrix(A));
		
		

	}

}
