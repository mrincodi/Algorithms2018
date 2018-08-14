import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MySudokuSolver2 {
	Integer [][] grid;
	int remaining = 0;

	ArrayList < HashSet < Integer >> rows;
	ArrayList < HashSet < Integer >> cols;
	ArrayList < HashSet < Integer >> squs;


	MySudokuSolver2 ( Integer [][]grid ){
		this.grid = grid;
		prepareSudoku ();
	}

	private void prepareSudoku() {

		rows = new ArrayList < HashSet < Integer >> ();
		cols = new ArrayList < HashSet < Integer >> ();
		squs = new ArrayList < HashSet < Integer >> ();

		for ( int i = 0; i < 9; i++){
			rows.add( new HashSet < Integer >());
			cols.add( new HashSet < Integer >());
			squs.add( new HashSet < Integer >());

		}
		for ( int row = 0; row < 9; row++){
			for ( int col = 0; col < 9; col++){
				int squ = posToSqu(row,col);

				int n = grid [ row ][ col ];
				if ( n != 0 ){
					rows.get(row).add(n);	// TODO: Validate if sudoku is valid.
					cols.get(col).add(n);	// TODO: Validate if sudoku is valid.
					squs.get(squ).add(n);	// TODO: Validate if sudoku is valid.
				}
				else
					remaining++;
			}		
		}
		System.out.println ( "Blah.");

	}

	private int posToSqu(int row, int col) {
		return ( row / 3) * 3  + col / 3 ;
	}

	private int [] squToPos ( int num ){
		int [] result = {-1,-1};

		if ( num < 0 || num > 8 ) return result;
		result [ 0 ] = num / 3;
		result [ 1 ] = num % 3;
		return result;
	}


	void solve ( ){
		// Fill out the hashMaps.
		while (!isSolved ()){
			// This is the first approach. In the second one, the first thing I must do is to 
			// check in all the grid for positions in which only one particular number is possible.
			solveRows ();
			solveCols ();
			solveSquares();
		}
	}


	private void solveSquares() {
		int squ = 0;

		outer:
			while (squ < 9){ 
				int [] rowAndCol = squToPos(squ);
				int initialRow = rowAndCol [ 0 ] * 3;
				int initialCol = rowAndCol [ 1 ] * 3;

				//Let's try to locate the numbers, one by one.
				for ( int num = 1; num <=9; num++){
					if ( !squs.get(squ).contains(num)){
						//  The number is not in the square. Let's look where can it be located.

						ArrayList < Integer> possiblePoss = new ArrayList < Integer> ();
						for ( int pos = 0; pos < 9; pos++ ){
							int extraRow = pos / 3;
							int extraCol = pos % 3;
							int row = initialRow + extraRow;
							int col = initialCol + extraCol;

							if ( grid [ row ] [col ] == 0 && possible (row,col,num)) {
								possiblePoss.add(pos);
							}
						}
						if ( possiblePoss.size() == 1){ // Wooonderful!
							int pos = possiblePoss.get(0);
							addNumberToGrid (pos / 3, pos % 3, num);
							squ = 0;
							continue outer;
						}

					}
				}
				squ++;
			}
	}

	private void solveRows() {
		int row = 0;
		outer:
			while (row < 9){
				//Let's try to locate the numbers, one by one.
				for ( int num = 1; num <=9; num++){
					if ( !rows.get(row).contains(num)){
						//  The number is not in the row. Let's look where can it be located.
						ArrayList < Integer> possibleCols = new ArrayList < Integer> ();
						for ( int col = 0; col < 9; col++ ){
							if ( grid [ row ] [col ] == 0 && possible (row,col,num)) {
								possibleCols.add(col);
							}
						}
						if ( possibleCols.size() == 1){ // Wooonderful!
							addNumberToGrid (row, possibleCols.get(0), num);
							row = 0;
							continue outer;
						}

					}
				}
				row++;


			}

	}


	private void solveCols() {
		int col = 0;
		outer:
			while (col < 9){
				//Let's try to locate the numbers, one by one.
				for ( int num = 1; num <=9; num++){
					if ( !cols.get(col).contains(num)){
						//  The number is not in the row. Let's look where can it be located.
						ArrayList < Integer> possibleRows = new ArrayList < Integer> ();
						for ( int row = 0; row < 9; row++ ){
							if ( grid [ row ] [col ] == 0 && possible (row,col,num)) {
								possibleRows.add(row);
							}
						}
						if ( possibleRows.size() == 1){ // Wooonderful!
							addNumberToGrid (possibleRows.get(0), col, num);
							col = 0;
							continue outer;
						}

					}
				}
				col++;
			}
	}

	private void addNumberToGrid(int row, int col, int num) {
		// TODO: For now, stop.
		System.out.println ("Wow! " + row + "," + col + " -> " + num );
		grid [ row ][ col ] = num;
		rows.get(row).add(num);
		cols.get(col).add(num);
		squs.get(posToSqu(row,col)).add(num);
		remaining--;
	}

	private boolean possible(int row, int col, int num) {
		// Check hashMaps!
		if ( rows.get(row).contains(num)) return false;
		if ( cols.get(col).contains(num)) return false;
		if ( squs.get(posToSqu(row,col)).contains(num)) return false;

		return true;
	}

	private boolean isSolved() {
		return remaining == 0;
	}

	public static void main(String[] args) {
		Integer [][]grid = new Integer [9][9];
		// Shame on you, java, for not having a simpler way of initializing an array of arrays.
		// (or shame on me, for not knowing it).
		grid [ 0 ] = new ArrayList <Integer >( Arrays.asList(0,9,1,0,0,0,6,3,0)).toArray(new Integer [ 9 ]);
		grid [ 1 ] = new ArrayList <Integer >( Arrays.asList(6,7,0,0,0,2,0,0,0)).toArray(new Integer [ 9 ]);
		grid [ 2 ] = new ArrayList <Integer >( Arrays.asList(0,0,0,0,7,0,0,0,0)).toArray(new Integer [ 9 ]);
		grid [ 3 ] = new ArrayList <Integer >( Arrays.asList(9,0,0,1,0,0,0,0,0)).toArray(new Integer [ 9 ]);
		grid [ 4 ] = new ArrayList <Integer >( Arrays.asList(7,5,0,0,0,0,0,1,9)).toArray(new Integer [ 9 ]);
		grid [ 5 ] = new ArrayList <Integer >( Arrays.asList(0,0,0,0,0,8,0,0,6)).toArray(new Integer [ 9 ]);
		grid [ 6 ] = new ArrayList <Integer >( Arrays.asList(0,0,0,0,8,0,0,0,0)).toArray(new Integer [ 9 ]);
		grid [ 7 ] = new ArrayList <Integer >( Arrays.asList(0,0,0,3,0,0,0,4,2)).toArray(new Integer [ 9 ]);
		grid [ 8 ] = new ArrayList <Integer >( Arrays.asList(0,3,7,0,0,0,8,5,0)).toArray(new Integer [ 9 ]);

		MySudokuSolver2 mss = new MySudokuSolver2(grid);
		mss.solve();

	}

}
