import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Solves easy sudokus. Fails for hard ones.
 * Basically fails whenever there is "guessing" needed.
 * @author mrincodi
 *
 */


public class MySudokuSolver3 {
	Integer [][] grid;
	int remaining = 0;

	ArrayList < HashSet < Integer >> rows;
	ArrayList < HashSet < Integer >> cols;
	ArrayList < HashSet < Integer >> squs;
	HashMap < String, HashSet < Integer>> possibles;

	MySudokuSolver3 ( Integer [][]grid ){
		this.grid = grid;
		prepareSudoku ();
	}

	private void prepareSudoku() {

		rows = new ArrayList < HashSet < Integer >> ();
		cols = new ArrayList < HashSet < Integer >> ();
		squs = new ArrayList < HashSet < Integer >> ();
		possibles = new HashMap < String, HashSet < Integer>> ();

		fillOutHashes();
		fillOutPossibles ();

		System.out.println ( "Blah.");

	}

	private void fillOutPossibles() {
		for ( int row = 0; row < 9; row++){
			for ( int col = 0; col < 9; col++){
				if ( grid [ row ][ col ] == 0){
					HashSet <Integer> possiblesHere = new HashSet <Integer> ();
					for ( int n = 1; n <= 9; n++){
						if ( 	!rows.get(row).contains(n) && 
								!cols.get(col).contains(n) &&
								!squs.get(posToSqu(row, col)).contains(n)){
							possiblesHere.add(n);
						}
					}
					possibles.put ( row + "_" + col, possiblesHere);
				}
			}
		}
	}

	private void fillOutHashes() {
		for ( int i = 0; i < 9; i++){
			rows.add( new HashSet < Integer >());
			cols.add( new HashSet < Integer >());
			squs.add( new HashSet < Integer >());
		}

		// TODO: MR: Put this in a method and create another one for filling out possibles and call it afterwards.
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

		while (!isSolved ()){

			fillUniques();
			// I need to change these methods so they take advantage of the "possibles" hashsets.
			// Also, start working in "possibilities", if this doesn't solve it.
			// (so, basically, recursion).

			boolean something = false;
			
			System.out.println ( "Voy con rows!!");
			boolean a = solveRows ();

			System.out.println ( "Voy con cols!!");
			boolean b = solveCols ();

			System.out.println ( "Voy con squares!!");
			boolean c = solveSquares();
			
			if ( !a && !b && !c ) {
				System.out.println ( "Ooops... Hasta aquí nos trajo el río?? :(");
				
				// TODO: Initial approach. Let's try with one position and let's see what happens.
				 /* The idea is:
				 * Go to the first empty position in the square:
				 * For each possible value:
				 * - Fill that position with that value.
				 * - If I  get to a dead end, try with the other value.
				 * - If this still doesn't work, enhance the program :)... To
				 *   look into the next position.
				 */
				
				// Find first zero in the first line. There must be one (I think, again,
				// this is just an approach.
				// TODO: MR: Continue here.
//				int guineaPigCol = -1;
//				
//				for ( int i = 0; i < 9; i++ ){
//					if ( it's zero... )
//				}
				
				
				return;
			}
		}
		System.out.println ( "Solved!!");
		printSudoku();
	}

	private void printSudoku() {
		for ( int row = 0; row < 9; row++){
			for ( int col = 0; col < 9; col++){
				System.out.print ( grid [ row ][ col ] + " ");
			}
			System.out.println();
		}
	}

	private void fillUniques() {
		// Easy as pie. Just find out those possibles which only have one element.
		Iterator <String> iter = possibles.keySet().iterator();
		ArrayList < String > toRemove = new ArrayList < String >();
		while (iter.hasNext()){
			String posS = iter.next();
			if ( possibles.get(posS).size()==1){
				// Sweet!
				String [] posA = posS.split("_");
				int row = Integer.parseInt(posA[0]);
				int col = Integer.parseInt(posA[1]);

				Iterator < Integer > iter2 = possibles.get(posS).iterator();
				int num =  iter2.next();
				toRemove.add(row + "_" + col + "_" + num);
			}
		}
		for ( String s: toRemove ){
			String [] parts = s.split("_");
			int row = Integer.parseInt(parts[0]);
			int col = Integer.parseInt(parts[1]);
			int num = Integer.parseInt(parts[2]);

			System.out.println ("Sweet!");
			addNumberToGrid (row, col, num);	
		}

	}

	private boolean solveSquares() {
		boolean result = false;
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

							System.out.println ("Squares!");
							addNumberToGrid (pos / 3, pos % 3, num);
							squ = 0;
							result = true;
							continue outer;
						}

					}
				}
				squ++;
			}
		return result;
	}

	private boolean solveRows() {
		boolean result = false;
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
							System.out.println ("Rows!");
							addNumberToGrid (row, possibleCols.get(0), num);
							row = 0;
							result = true;
							continue outer;
						}

					}
				}
				row++;
			}
		return result;
	}


	private boolean solveCols() {
		boolean result = false;
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
							System.out.println ("Cols!");
							addNumberToGrid (possibleRows.get(0), col, num);
							col = 0;
							result = true;
							continue outer;
						}

					}
				}
				col++;
			}
		return result;
	}

	private void addNumberToGrid(int row, int col, int num) {
		System.out.println ("Wow! " + row + "," + col + " -> " + num );
		grid [ row ][ col ] = num;
		rows.get(row).add(num);
		cols.get(col).add(num);
		squs.get(posToSqu(row,col)).add(num);
		possibles.remove(row + "_" + col);
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
		// Shame on you, Java, for not having a simpler way of initializing an array of arrays.
		// (or shame on me, for not knowing it).
		// Not solved with this program :( :
				grid [ 0 ] = new ArrayList <Integer >( Arrays.asList(0,9,1,0,0,0,6,3,0)).toArray(new Integer [ 9 ]);
				grid [ 1 ] = new ArrayList <Integer >( Arrays.asList(6,7,0,0,0,2,0,0,0)).toArray(new Integer [ 9 ]);
				grid [ 2 ] = new ArrayList <Integer >( Arrays.asList(0,0,0,0,7,0,0,0,0)).toArray(new Integer [ 9 ]);
				grid [ 3 ] = new ArrayList <Integer >( Arrays.asList(9,0,0,1,0,0,0,0,0)).toArray(new Integer [ 9 ]);
				grid [ 4 ] = new ArrayList <Integer >( Arrays.asList(7,5,0,0,0,0,0,1,9)).toArray(new Integer [ 9 ]);
				grid [ 5 ] = new ArrayList <Integer >( Arrays.asList(0,0,0,0,0,8,0,0,6)).toArray(new Integer [ 9 ]);
				grid [ 6 ] = new ArrayList <Integer >( Arrays.asList(0,0,0,0,8,0,0,0,0)).toArray(new Integer [ 9 ]);
				grid [ 7 ] = new ArrayList <Integer >( Arrays.asList(0,0,0,3,0,0,0,4,2)).toArray(new Integer [ 9 ]);
				grid [ 8 ] = new ArrayList <Integer >( Arrays.asList(0,3,7,0,0,0,8,5,0)).toArray(new Integer [ 9 ]);

		// Solved:
//		grid [ 0 ] = new ArrayList <Integer >( Arrays.asList(0,0,6,0,3,0,4,0,8)).toArray(new Integer [ 9 ]);
//		grid [ 1 ] = new ArrayList <Integer >( Arrays.asList(3,0,0,4,0,0,1,0,9)).toArray(new Integer [ 9 ]);
//		grid [ 2 ] = new ArrayList <Integer >( Arrays.asList(0,0,0,0,9,7,3,0,0)).toArray(new Integer [ 9 ]);
//		grid [ 3 ] = new ArrayList <Integer >( Arrays.asList(0,3,0,0,5,6,7,0,0)).toArray(new Integer [ 9 ]);
//		grid [ 4 ] = new ArrayList <Integer >( Arrays.asList(6,1,0,0,0,0,0,5,3)).toArray(new Integer [ 9 ]);
//		grid [ 5 ] = new ArrayList <Integer >( Arrays.asList(0,0,7,9,2,0,0,1,0)).toArray(new Integer [ 9 ]);
//		grid [ 6 ] = new ArrayList <Integer >( Arrays.asList(0,0,3,7,1,0,0,0,0)).toArray(new Integer [ 9 ]);
//		grid [ 7 ] = new ArrayList <Integer >( Arrays.asList(2,0,1,0,0,9,0,0,7)).toArray(new Integer [ 9 ]);
//		grid [ 8 ] = new ArrayList <Integer >( Arrays.asList(7,0,8,0,6,0,9,0,0)).toArray(new Integer [ 9 ]);
//		
		
	// Solved:	
//		grid [ 0 ] = new ArrayList <Integer >( Arrays.asList(0,0,5,1,0,0,0,4,2)).toArray(new Integer [ 9 ]);
//		grid [ 1 ] = new ArrayList <Integer >( Arrays.asList(1,9,0,7,0,0,0,0,0)).toArray(new Integer [ 9 ]);
//		grid [ 2 ] = new ArrayList <Integer >( Arrays.asList(7,0,3,0,8,0,0,0,1)).toArray(new Integer [ 9 ]);
//		grid [ 3 ] = new ArrayList <Integer >( Arrays.asList(5,0,0,9,7,0,1,0,0)).toArray(new Integer [ 9 ]);
//		grid [ 4 ] = new ArrayList <Integer >( Arrays.asList(0,8,6,0,0,0,9,7,0)).toArray(new Integer [ 9 ]);
//		grid [ 5 ] = new ArrayList <Integer >( Arrays.asList(0,0,1,0,4,6,0,0,3)).toArray(new Integer [ 9 ]);
//		grid [ 6 ] = new ArrayList <Integer >( Arrays.asList(4,0,0,0,3,0,8,0,5)).toArray(new Integer [ 9 ]);
//		grid [ 7 ] = new ArrayList <Integer >( Arrays.asList(0,0,0,0,0,9,0,6,7)).toArray(new Integer [ 9 ]);
//		grid [ 8 ] = new ArrayList <Integer >( Arrays.asList(6,1,0,0,0,8,4,0,0)).toArray(new Integer [ 9 ]);
//		
		
		MySudokuSolver3 mss = new MySudokuSolver3(grid);
		mss.solve();

	}

}
