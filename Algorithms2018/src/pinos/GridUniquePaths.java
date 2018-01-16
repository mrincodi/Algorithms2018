package pinos;

public class GridUniquePaths {
	//https://www.interviewbit.com/problems/grid-unique-paths/
	// This is a combinatorics problem, as explained in https://leetcode.com/problems/unique-paths/discuss/22958
	// I solved it here with DP.

	public int uniquePaths(int rows, int cols) {
		int [][] m = new int [rows][cols];

		for ( int i = 0; i < rows; i++){
			for ( int j = 0 ; j < cols; j++){
				m [ i ] [ j ] = -1;
			}
		}
		m [ rows - 1] [ cols - 1] = 1;

		return calculate (0,0,rows,cols,m);


	}


	public int calculate ( int startRow, int startCol, int rows, int cols, int [][]m){
		if ( m [startRow][startCol] != -1) return m [startRow][startCol];
		int result = 0;
		if ( startRow < rows - 1){
			result += calculate ( startRow + 1,  startCol,  rows,  cols, m);
		}
		if ( startCol < cols - 1){
			result += calculate ( startRow,  startCol + 1,  rows,  cols, m);
		}

		m[startRow][startCol]= result;
		return result;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
