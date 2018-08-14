package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/queens-attack-2/problem
// Good.
// 2018-07-31
// 44m
public class QueensAttack2 {


	// Complete the queensAttack function below.
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
		int result = 0;


		int [] dir = new int [ 8 ];

		dir [ 0 ] = Math.min ( n - r_q, n - c_q );
		dir [ 1 ] = n - c_q;
		dir [ 2 ] = Math.min ( r_q - 1, n - c_q );
		dir [ 3 ] = r_q - 1;
		dir [ 4 ] = Math.min ( r_q - 1, c_q - 1 );
		dir [ 5 ] = c_q - 1;
		dir [ 6 ] = Math.min ( n - r_q, c_q - 1);
		dir [ 7 ] = n - r_q;

		int val = 0;
		for (int [] obstacle: obstacles ){
			int row = obstacle [ 0 ];
			int col = obstacle [ 1 ];

			// Up Right.
			if (  row > r_q && col > c_q && ( row - r_q == col - c_q )){
				val = row - r_q - 1; // Same as col - c_q.
				dir [ 0 ] = Math.min ( dir [ 0 ], val );
			}

			// Right.
			else if ( row == r_q && col > c_q ){
				val = col - c_q - 1;
				dir [ 1 ] = Math.min ( dir [ 1 ], val );
			}

			// Down Right.
			else if (  row < r_q && col > c_q && ( r_q - row == col - c_q )){
				val = col - c_q - 1;
				dir [ 2 ] = Math.min ( dir [ 2 ], val );
			}

			// Down.
			else if ( row < r_q && col == c_q ){
				val = r_q - row - 1;
				dir [ 3 ] = Math.min ( dir [ 3 ], val );
			}

			// Down Left.
			else if (  row < r_q && col < c_q && ( r_q - row == c_q - col )){
				val = c_q - col - 1;
				dir [ 4 ] = Math.min ( dir [ 4 ], val );
			}

			// Left.
			else if ( row == r_q && col < c_q ){
				val = c_q - col - 1;
				dir [ 5 ] = Math.min ( dir [ 5 ], val );
			}

			// Up Left.
			else if (  row > r_q && col < c_q && ( row - r_q == c_q - col )){
				val = row - r_q - 1;
				dir [ 6 ] = Math.min ( dir [ 6 ], val );
			}

			// Up.
			else if ( row > r_q && col == c_q ){
				val = row - r_q - 1;
				dir [ 7 ] = Math.min ( dir [ 7 ], val );
			}
		}

		for ( int d: dir ){
			result = result + d;
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		String[] r_qC_q = scanner.nextLine().split(" ");

		int r_q = Integer.parseInt(r_qC_q[0]);

		int c_q = Integer.parseInt(r_qC_q[1]);

		int[][] obstacles = new int[k][2];

		for (int i = 0; i < k; i++) {
			String[] obstaclesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
				obstacles[i][j] = obstaclesItem;
			}
		}

		int result = queensAttack(n, k, r_q, c_q, obstacles);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}



