package pinos;

import java.util.ArrayList;
import java.util.Collections;

// https://www.interviewbit.com/problems/largest-area-of-rectangle-with-permutations/
// Solve using the good old histogram technique (a simpler variation of it).
// Can be even enhanced using count sort for sorting instead of Collections.sort();

public class LargestAreaOfRectangleWithPermutations {

	public int solve(ArrayList<ArrayList<Integer>> A) {

		//Create the auxiliary matrix.
		ArrayList<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>> ();

		int height = A.size(), width = A.get(0).size();

		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int j = 0; j < width; j++ )
			row.add (A.get(0).get(j));

		aux.add(row);

		for ( int i = 1; i < height; i++){
			row = new ArrayList<Integer>();
			for (int j = 0; j < width; j++ ){
				int val = A.get(i).get(j);

				if ( val == 0)
					row.add(0);
				else
					row.add (aux.get(i-1).get(j) + 1);
			}
			aux.add(row);
		}

		//Now, generate values.
		int maxArea = 0;
		for (int i = 0; i < height; i++){
			row = aux.get(i);

			Collections.sort (row, Collections.reverseOrder ());
			for ( int j = 0; j < row.size(); j++){
				int thisArea = row.get(j)*(j+1);
				maxArea = Math.max (maxArea, thisArea);
			}
		}

		return maxArea;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
