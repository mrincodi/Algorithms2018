package interv.g.i2;

// Asked on 2018-07-23
public class Spiral {

	int [][] spiral ( int  side ){

		int [] [] result = new int [ side ][side ];

		if ( side <= 0 ) return result;

		int leg = side - 1;
		int legWalk = 0;
		int row = 0;
		int col = 0;
		int dir = 0;

		for ( int i = 1; i <= side * side; i++ ){
			result [ row ] [ col ] = i;
			legWalk++;

			// Change of direction:
			if ( legWalk == leg + 1 || ( dir == 3 && legWalk == leg)){
				dir = dir + 1;
			}

			// Change of counter:
			if ( dir == 4 && legWalk == leg){
				legWalk = 0;
				leg=leg - 2;
				dir = 0; 
			} else if ( legWalk == leg + 1 )
				legWalk = 1;
			
			switch ( dir ){
			case 0:
				col++;
				break;

			case 1:
				row++;
				break;

			case 2:
				col--;
				break;

			case 3:
				row--;
				break;
			}

		}
		return result;

	}
	public static void main(String[] args) {
		int size = 10;
		int [][] spiral = new Spiral().spiral(size);

		for ( int i = 0; i < size; i++ ){
			for ( int j = 0; j < size; j++ ){
				System.out.print(spiral [ i ][ j ] + " ");
			}
			System.out.println();

		}

	}


}
