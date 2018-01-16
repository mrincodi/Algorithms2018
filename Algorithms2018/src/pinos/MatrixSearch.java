package pinos;

import java.util.ArrayList;

public class MatrixSearch {
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

		int numRows = a.size();
		int numCols = a.get(0).size(); 
		int startPos = 0;
		int endPos   = numRows*numCols - 1;

		while (startPos <= endPos ){
			int midPos = ( startPos + endPos) / 2;

			int val = valAt(midPos, a, numCols);
			if ( val == b ) return 1;
			if ( val <  b ) startPos = midPos + 1;
			else endPos = midPos - 1;
		}
		return 0;
	}

	public int valAt (int pos, ArrayList<ArrayList<Integer>> a, int numCols){
		int row = pos / numCols;
		int col = pos % numCols;
		return a.get(row).get(col);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
