package hackerrank;

// https://www.hackerrank.com/challenges/non-divisible-subset/problem
// First approach. Doesn't work. I was on the right path, though!
// 2018-08-01
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/non-divisible-subset/problem
// An AMAZING problem. Particularly given how small is the optimal solution.
// 2018-08-01

public class NonDivisibleSubset {

	// Complete the nonDivisibleSubset function below.
	static int nonDivisibleSubset(int k, int[] S) {
		int result = 0;

		int [] freqs = new int [ k ];

		for ( int n: S ){
			int mod = n % k;
			freqs [ mod ] ++;
		}

		if ( k % 2 == 0 )
			freqs [ k / 2 ] = Math.min (freqs [ k / 2 ], 1);

		result = Math.min(freqs[0], 1);
		for ( int i=1; i <= k / 2; i++ ){
			result = result + Math.max ( freqs [ i ], freqs [ k - i]);
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] S = new int[n];

		String[] SItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int SItem = Integer.parseInt(SItems[i]);
			S[i] = SItem;
		}

		int result = nonDivisibleSubset(k, S);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

