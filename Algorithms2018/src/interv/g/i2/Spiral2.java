package interv.g.i2;

// Asked on 2018-07-23. Enhancement.
// This is the decent, clean, organized way of doing things!!

public class Spiral2 {

	int [][] spiral ( int  side ){

		int [] [] result = new int [ side ][side ];

		int corner1Row = 0;
		int corner1Col = 0;
		int corner2Row = side - 1;
		int corner2Col = side - 1;

		int i = 1;
		while ( i <= side * side ){
			i = drawFrame ( i, result, corner1Row, corner1Col, corner2Row, corner2Col);
			corner1Row++;
			corner1Col++;
			corner2Row--;
			corner2Col--;
		}

		return result;
	}

	private int drawFrame(int start, int[][] matrix, int corner1Row, int corner1Col, int corner2Row, int corner2Col) {
	
		int n = start;

		for ( int i = corner1Col; i <= corner2Col; i++){
			matrix [ corner1Row ] [ i ] = n;
			n++;
		}
		
		for ( int i = corner1Row + 1; i <= corner2Row; i++){
			matrix [ i ] [ corner2Col ] = n;
			n++;
		}
		
		for ( int i = corner2Col - 1; i >= corner1Col; i--){
			matrix [ corner2Row ] [ i ] = n;
			n++;
		}
		
		for ( int i = corner2Row - 1; i > corner1Row; i--){
			matrix [ i ][corner1Col] = n;
			n++;
		}
		
		return n;
	}

	public static void main(String[] args) {
		int size = 9;
		int [][] spiral = new Spiral2().spiral(size);

		for ( int i = 0; i < size; i++ ){
			for ( int j = 0; j < size; j++ ){
				System.out.print(spiral [ i ][ j ] + " ");
			}
			System.out.println();

		}

	}

}
