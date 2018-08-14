import java.util.ArrayList;

public class MySudokuSolver {

	void solve ( int [][] grid ){
		// First, for each line, for each number, calculate if there is a unique position for it.
		outer:
		for ( int rowNum = 0; rowNum < 9; rowNum++ ){
			for ( int num = 1; num <= 9; num++ ){
				if ( !isNumInRow (grid, num, rowNum)){
					ArrayList < Integer > possiblePositions = findPossiblePositionsInRow ( grid, num, rowNum );
					if ( possiblePositions.size() == 1 ){
						int pos = possiblePositions.get(0);
						grid [rowNum][ pos ] = num;
						continue outer;
					}

				}
			}
		}
	}
	
	private ArrayList<Integer> findPossiblePositionsInRow(int[][] grid, int num, int rowNum) {
		for ( int i = 0; i < 9; i++ ){
			// Can num be positioned at position (rowNum, i)?
			
		}
		return null;
	}

	private boolean isNumInRow(int[][] grid, int num, int rowNum) {
		// For now, we follow the dumb approach of going over the row looking for the number.
		for ( int i = 0; i < 9; i++ ){
			if ( grid [ rowNum ] [ i ] == num) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
