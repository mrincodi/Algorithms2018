package leetcode;

import java.util.HashSet;

// https://leetcode.com/problems/magic-squares-in-grid/description/
// Simple.
public class MagicSquaresInGrid {

	public int numMagicSquaresInside(int[][] grid) {
		int result = 0;
		if ( grid.length < 3 || grid[0].length < 3 ) return 0;

		for ( int i = 0; i < grid.length - 2; i++ ){
			for ( int j = 0; j < grid[0].length - 2; j++ ){
				if ( isAMagicSquare (grid, i, j )) result++;
			}
		}
		return result;
	}

	private boolean isAMagicSquare (int[][]grid, int i, int j ){
		HashSet <Integer> digits = new HashSet <Integer>();
		for ( int row = i; row < 3 + i; row++){
			for ( int col = j; col < 3 + j; col++){
				int n = grid [ row ][ col ];
				if ( n == 0 || n > 9 ) return false;
				if ( digits.contains (n)) return false;
				digits.add ( n );
			}
		}

		//All-right! Let's add rows, cols and diagonals.
		int sum = 0; 
		int sum2 = 0;
		for ( int row = i; row < 3 + i; row++){
			sum += grid [ row ][ j ]; 
		}

		//Check the other cols.
		sum2 = 0;
		for ( int row = i; row < 3 + i; row++){
			sum2 += grid [ row ][ j + 1 ]; 
		}
		if (sum2 != sum ) return false;

		sum2 = 0;
		for ( int row = i; row < 3 + i; row++){
			sum2 += grid [ row ][ j + 2 ]; 
		}
		if (sum2 != sum ) return false;

		// Check the rows.
		sum2 = 0;
		for ( int col = j; col < 3 + j; col++){
			sum2 += grid [ i ][ col ]; 
		}
		if (sum2 != sum ) return false;

		sum2 = 0;
		for ( int col = j; col < 3 + j; col++){
			sum2 += grid [ i + 1 ][ col ]; 
		}
		if (sum2 != sum ) return false;

		sum2 = 0;
		for ( int col = j; col < 3 + j; col++){
			sum2 += grid [ i + 2 ][ col ]; 
		}
		if (sum2 != sum ) return false;

		// Check the diagonals
		sum2 = 0;
		for ( int q = 0; q < 3; q++){
			sum2 += grid [ i + q ][ j + q ]; 
		}
		if (sum2 != sum ) return false;

		sum2 = 0;
		for ( int q = 0; q < 3; q++){
			sum2 += grid [ i + q ][ j + 2 - q]; 
		}
		if (sum2 != sum ) return false;

		return true;
	}

	public static void main(String[] args) {
		MagicSquaresInGrid msig = new MagicSquaresInGrid();
		int [] [] grid = {{3,2,9,2,7},{6,1,8,4,2},{7,5,3,2,7},{2,9,4,9,6},{4,3,8,2,5}};
		int res = msig.numMagicSquaresInside(grid);
		System.out.println ( res );
	}

}
