import java.util.ArrayList;
import java.util.Random;

public class MS {

	char [][] grid;
	int width;
	int height;
	int numMines;

	MS ( int width, int height, int numMines) throws Exception{
		if ( width <= 0 || height <= 0){
			throw new Exception ( "Wrong matrix dimensions!");
		}
		this.width  = width;
		this.height = height;

		grid = new char [ height ][ width ];

		if ( numMines > height * width){
			throw new Exception ( "Too many mines!");
		}

		// Put mines!
		// Generate possibilities.
		ArrayList < String > initialDist = new ArrayList < String > ();

		// Fill it out!
		for ( int row = 0; row < height; row++){
			for ( int col = 0; col < width; col++){
				initialDist.add(row + "_" + col);
				grid [ row ] [ col ] = '#';
			}

			int left = numMines;
			while ( left > 0){
				Random r = new Random (left);
				int pos = r.nextInt();
				String [] posArrayS = initialDist.get(pos).split("_");
				//int row = Integer.pa ...
				
				// TODO: FINISH.
			}
		}


	}

	void solve ( char [][] grid ){

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
