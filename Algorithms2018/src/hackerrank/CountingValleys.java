package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/counting-valleys
// Duh. Anyways, good job thinking through before the first line of code.
public class CountingValleys {

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		int result = 0;
		int sum = 0;
		for ( int i = 0; i < n; i++){
			char c = s.charAt(i);

			if ( sum == 0 && c == 'D') result++;

			if ( c == 'D' ) sum--;
			else sum++;
		}

		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int result = countingValleys(n, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
