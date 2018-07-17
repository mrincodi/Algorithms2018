package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
// Too easy.
// 2018-07-15

class BreakingTheRecords {

	// Complete the breakingRecords function below.
	static int[] breakingRecords(int[] scores) {

		int [] result = new int [ 2 ];
		if ( scores.length == 0 ) return result;
		int min = scores [ 0 ];
		int max = scores [ 0 ];

		for ( int i = 1; i < scores.length; i++ ){
			int score = scores [ i ];
			if ( score < min ){
				min = score;
				result [ 1 ] = result [ 1 ] + 1;
			}
			if ( score > max ){
				max = score;
				result [ 0 ] = result [ 0 ] + 1;
			}
		}

		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[n];

		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
		}

		int[] result = breakingRecords(scores);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {
				bufferedWriter.write(" ");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

