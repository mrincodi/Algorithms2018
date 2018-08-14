package hackerrank;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/the-birthday-bar/problem
// Another elementary one.
// 2018-07-17
public class BirthdayChocolate {

	// Complete the solve function below.
	static int solve(int[] s, int d, int m) {
		int result = 0;
		if ( s.length < m ) return 0;

		int start = 0, end = m - 1;

		int sum = 0;
		for ( int i = 0; i < m; i++){
			sum += s [ i ];
		}
		if (sum == d) result++;

		start++;
		end++;
		while ( end < s.length ){
			sum = sum - s [ start - 1] + s [ end ];
			if ( sum == d ) result++;
			start++;
			end++;
		}
		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] s = new int[n];

		String[] sItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int sItem = Integer.parseInt(sItems[i]);
			s[i] = sItem;
		}

		String[] dm = scanner.nextLine().split(" ");

		int d = Integer.parseInt(dm[0]);

		int m = Integer.parseInt(dm[1]);

		int result = solve(s, d, m);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}
