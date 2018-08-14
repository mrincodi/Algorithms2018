package hackerrank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/sock-merchant/problem?h_r=next-challenge&h_v=zen
// Too easy. I mean, these are the "learn to code" exercises.
// 2018-07-26

public class SockMerchant {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {

		int result = 0;
		HashSet <Integer> singleSockColors = new HashSet <Integer> ();

		for ( int i = 0; i < n; i++){

			int color = ar [ i ];
			if ( !singleSockColors.contains ( color)){
				singleSockColors.add(color);
			}
			else {
				singleSockColors.remove ( color );
				result = result + 1;
			}
		}

		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
