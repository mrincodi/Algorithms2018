package triplebyte;

import java.util.Scanner;

// Test performed on 2018-08-12.
class TictacToeBoard {
	char [][] grid;
	int width = 3;
	int height = 3;

	TictacToeBoard ( ){
		grid = new char [ height ] [ width ];
		for ( int row = 0; row < height; row++){
			for ( int col = 0; col < width; col++){
				grid [ row ][ col ] = '-';
			}
		}
	}

	void add ( char token, int row, int col ) throws Exception{
		if ( !isValidChar ( token ) ) throw new Exception ( "Invalid character!");
		if ( !isValidPos (  row,  col ) ) throw new Exception ( "Invalid position!");
		if ( grid [ row ][col] != '-' ) throw new Exception ( "Position already occupied!");

		grid [ row ][col] = token;
	}

	void print (){
		// TODO: Currently only works with width and height equal to 3.
		for ( int row = 0; row < height; row++){
			System.out.print(grid[row][0]);
			System.out.print("|");
			System.out.print(grid[row][1]);
			System.out.print("|");
			System.out.print(grid[row][2]);
			System.out.println();
		}
	}

	private boolean isValidPos(int row, int col) {
		return row >= 0 && row < height && col >= 0 && col < height;
	}

	boolean isValidChar (char c ){
		if ( c != 'X' && c != 'O'){
			return false;
		}
		return true;
	}

	boolean isFull (){
		for ( int row = 0; row < height; row++){
			for ( int col = 0; col < width; col++){
				if ( grid [ row ][ col ] == '-') return false;
			}
		}
		return true;
	}

	void makeAMoveAI () throws Exception{
		// For now, just find the next available position!
		for ( int row = 0; row < height; row++){
			for ( int col = 0; col < width; col++){
				if ( grid [ row ][ col ] == '-'){
					grid [ row ][ col ] = 'O';
					return;
				}
			}
		}

		throw new Exception ("Board is full!");
	}


	void gameInstance ( ) throws Exception{

		System.out.println ("Your turn (X)");
		
		
		while ( !isFull()){
			makeAMoveHuman ();
			print();
			
			if ( isFull ()) return;

			System.out.println ("\nMy turn (O)");
			
			makeAMoveAI ();
			print();

		}
	}

	void makeAMoveHuman () {
		Scanner in = new Scanner ( System.in);
		int row = -1, col = -1;
		while ( !isValidPos ( row, col)){
			System.out.print("Enter a row: ");
			String rowS = in.next();
			System.out.print("Enter a col: ");
			String colS = in.next();
			
			try {
				row = Integer.parseInt(rowS);
				col = Integer.parseInt(colS);
			}
			catch ( Exception e){
				System.out.println ( "Row or pos is not a number!");
			}
			
			try {
				add ( 'X',  row, col);
			}
			catch ( Exception e ){
				System.out.println ( e.getMessage());
				System.out.println ( "Try again.\n");
				row = -1;	// So pos. is invalid. XXX
			}
		}

	}


}




public class TictacToe {

	public static void main ( String [] args ) throws Exception{
		TictacToeBoard tb = new TictacToeBoard ();

		tb.gameInstance();
//
//		for ( int i = 0 ; i < 10; i++){
//			tb.makeAMoveHuman();
//			tb.print();
//
//			System.out.println ();
//			if ( tb.isFull ()) return;
//			
//			tb.makeAMoveAI();
//			tb.print();
//			System.out.println ();
//
//		}
		//		
		//		tb.print();
		//		
		//		tb.add('X', 0, 1);
		//
		//		tb.print();
		//		
		//		tb.makeAMoveAI();
		//		
		//
		//		tb.print();

	}
}
