package interview_bit;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/capture-regions-on-board/
// Important exercise. Right way to do it was to start at the borders
// and just "paint" (BFS) the regions outside with a different character.
// Then repaint the 'O's left to 'X's and the different character 
// back to 'O' (duh).
// 2018-07-09.

public class CaptureRegionsOnBoard {

	public void solve(ArrayList<ArrayList<Character>> a) {

		for ( int row = 1; row < a.size() - 1; row++ ){
			for ( int col = 1; col < a.get ( 0 ). size() - 1; col++ ){
				char c = a.get ( row ).get( col );
				if ( c == 'O'){
					if ( isItInside (a, row, col ) ){ 
						cover ( a, row, col, 'X'); 
					}
					else {
						cover ( a, row, col, 'K');
					}
				}
			}
		}

		// Now, K's should become O's.
		for ( int row = 0; row < a.size(); row++ ){
			for ( int col = 0; col < a.get ( 0 ). size(); col++ ){
				if ( a.get ( row ).get( col ) == 'K' ){
					a.get( row ).set ( col, 'O' );
				}
			}
		}
	}

	private boolean isItInside (ArrayList<ArrayList<Character>> a, int row, int col ) {
		// DFS
		// Find neighbors that are 'O'
		// Precondition: this position is 'O'

		if ( row == 0 || row == a.size() - 1 || col == 0 || col == a.get(0).size() - 1 )
			return false;

		boolean result = true;
		a.get ( row ).set ( col, '?' );

		if ( a.get(row).get (col - 1) == 'O')
			result = result && isItInside (a, row, col - 1);

		if ( a.get(row).get (col + 1) == 'O')
			result = result && isItInside (a, row, col + 1);

		if ( a.get(row - 1).get (col) == 'O')
			result = result && isItInside (a, row - 1, col);

		if ( a.get(row + 1).get (col) == 'O')
			result = result && isItInside (a, row + 1, col);

		// a.get ( row ).put ( col, 'O' );

		return result;

	}

	private void cover (ArrayList<ArrayList<Character>> a, int row, int col, char c ) {
		// Change 'O's and '?'s to the c character.
		if ( row < 0 || row >= a.size() || col < 0 || col >= a.get ( 0 ).size() )
			return;


		char cc = a.get ( row ). get ( col );
		if ( cc == 'O' || cc == '?'){
			a.get ( row ).set ( col, c );

			cover ( a, row - 1, col, c);
			cover ( a, row, col - 1, c);
			cover ( a, row + 1, col, c);
			cover ( a, row, col + 1, c);

		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
