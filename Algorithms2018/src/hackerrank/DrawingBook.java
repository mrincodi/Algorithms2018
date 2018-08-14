package hackerrank;


// https://www.hackerrank.com/challenges/drawing-book/problem
// 18m. Good thinking before coding.
// 2018-07-29
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DrawingBook {

	/*
	 * Complete the pageCount function below.
	 */
	static int pageCount(int n, int p) {
		int maxNumTurns = ( n - 1 ) / 2 ;
		if ( n % 2 == 0 ) maxNumTurns++;

		int turnsFromStart = ( p - 1 ) / 2;
		if ( p % 2 == 0 ) turnsFromStart++;

		return Math.min ( maxNumTurns - turnsFromStart, turnsFromStart);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int p = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int result = pageCount(n, p);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}



