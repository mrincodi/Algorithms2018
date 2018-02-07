package pinos;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/kth-manhattan-distance-neighbourhood/
// It was failing because of an initialization of result as M:
// ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> (M);
// THIS IS WRONG!! DON'T DO IT!!
// NEVER INITIALIZE AN ARRAY OF ARRAYS FROM ANOTHER ONE, AGAIN!!

public class KthManhattanDistanceNeighbourhoodFirstAttempt {

	public ArrayList<ArrayList<Integer>> solve(int K, ArrayList<ArrayList<Integer>> M) {
		int height = M.size();
		int width  = M.get(0).size();

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> (M); // THIS IS WRONG!! DON'T DO IT!!
		for ( int i = 0; i < K; i++){
			//Get largest one of the immediate neighbors.
			for (int row = 0; row < height; row++){
				for ( int col = 0; col < width; col++){
					int north = row == 0          ? -1:M.get(row - 1).get(col);
					int south = row == height - 1 ? -1:M.get(row + 1).get(col);
					int east  = col == width - 1  ? -1:M.get(row).get(col + 1);
					int west  = col == 0          ? -1:M.get(row).get(col - 1);

					int max = Math.max (north, south);
					max     = Math.max (max, east);
					max     = Math.max (max, west);
					max     = Math.max (max, M.get(row).get(col));

					result.get(row).set(col,max);

				}
			}
			//Copy.
			for ( int qrow = 0; qrow < height; qrow++)
				for ( int qcol = 0; qcol < width; qcol++)
					M.get(qrow).set(qcol, result.get(qrow).get(qcol));

		}

		return result;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
