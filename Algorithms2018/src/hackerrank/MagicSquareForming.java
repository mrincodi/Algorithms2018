package hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

// https://www.hackerrank.com/challenges/magic-square-forming/problem
// Amazing!
// 2018-07-30
public class MagicSquareForming {

	// Complete the formingMagicSquare function below.
	static int formingMagicSquare(int[][] s) {
		HashSet < Integer > prevVals = new HashSet < Integer > ();
		return formingMagicSquare ( s, 0, 0, prevVals);
	}

	static int formingMagicSquare (int[][] s, int row, int col, HashSet < Integer > prevVals ) {
		//		System.out.println ( row + " " + col);
		//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//		try {
		//			String ss = in.readLine();
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		int result = Integer.MAX_VALUE;

		int originalValue = s [ row ] [ col ];
		//		if ( isMagicSquare (s)) 
		//			return 0;

		if ( row == 2 && col == 2 ){
			//System.out.println( "hey!");
			// Find the missing number.
			int n = 1;
			while ( n <= 9 ){
				if ( !prevVals.contains(n)) break;
				n++;
			}
			s [2][2] = n;
			if ( isMagicSquare (s)){
					System.out.println (Arrays.deepToString(s));
				s [2][2] = originalValue;
				return Math.abs( n - originalValue);
			}
			s [2][2] = originalValue;
			return -1;
		}

		int nextRow = 0, nextCol = 0;
		if ( col == 2 ) {
			nextRow = row + 1;
			nextCol = 0;
		}                
		else {
			nextRow = row;
			nextCol = col + 1;
		}

		for ( int n = 1; n <= 9; n++ ){
			if ( !prevVals.contains(n) ){

				s [ row ] [ col ] = n;

				int cost = Math.abs ( originalValue - n);
				prevVals.add(n);
				int rest = formingMagicSquare ( s, nextRow, nextCol, prevVals );
				if ( rest != -1 ){
					result = Math.min ( result, rest + cost);
				}
//				else
//					result = rest + cost;

				prevVals.remove(n);
			}
		}

		s [ row ] [ col ] = originalValue;

		if ( result == Integer.MAX_VALUE )return -1;
		return result;
	}

	static boolean isMagicSquare ( int [][] m ){
		// Rows.
		int sum = 0;
		for ( int col = 0; col <= 2; col++){
			sum = sum + m[0][col];
		}

		int thisSum = 0;
		for ( int col = 0; col <= 2; col++){
			thisSum = thisSum + m[1][col];
		}
		if ( thisSum != sum ) return false;

		thisSum = 0;
		for ( int col = 0; col <= 2; col++){
			thisSum = thisSum + m[2][col];
		}
		if ( thisSum != sum ) return false;

		// Cols.
		thisSum = 0;
		for ( int row = 0; row <= 2; row++){
			thisSum = thisSum + m[row][0];
		}
		if ( thisSum != sum ) return false;

		thisSum = 0;
		for ( int row = 0; row <= 2; row++){
			thisSum = thisSum + m[row][1];
		}
		if ( thisSum != sum ) return false;

		thisSum = 0;
		for ( int row = 0; row <= 2; row++){
			thisSum = thisSum + m[row][2];
		}
		if ( thisSum != sum ) return false;

		// Diagonals
		thisSum = 0;
		for ( int i = 0; i <= 2; i++){
			thisSum = thisSum + m[i][i];
		}
		if ( thisSum != sum ) return false;

		thisSum = 0;
		for ( int i = 0; i <= 2; i++){
			thisSum = thisSum + m[i][2 - i];
		}
		if ( thisSum != sum ) return false;

		return true;
	}

	public static void main(String[] args) throws IOException {

		int[][] s =    {{ 4, 9, 2 },
				{ 3, 5, 7 },
				{ 8, 1, 5 }};

		int fms = formingMagicSquare (s);

		System.out.println (fms);

	}
}
