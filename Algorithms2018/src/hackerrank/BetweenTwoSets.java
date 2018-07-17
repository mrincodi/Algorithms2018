package hackerrank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/between-two-sets
// Easy enough for a brute force solution.
// 2018-06-15
public class BetweenTwoSets {

	/*
	 * Complete the getTotalX function below.
	 */
	static int getTotalX(int[] a, int[] b) {
		int result = 0;
		int start = Integer.MIN_VALUE, end = Integer.MAX_VALUE;

		for ( int n:a ){
			start = Math.max ( start, n );
		}

		for ( int n:b ){
			end = Math.min ( end, n);
		}

		// if min > max, return 0;
		if ( start > end ) return 0;

		outer:
			for ( int n = start; n <= end; n++ ){

				for ( int i=0; i < a.length; i++){
					if ( n % a[i] != 0 ) continue outer;
				}

				for ( int i=0; i < b.length; i++){
					if ( b[i] % n  != 0 ) continue outer;
				}

				result++;
			}
		return result;
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scan.nextLine().split(" ");

		int n = Integer.parseInt(nm[0].trim());

		int m = Integer.parseInt(nm[1].trim());

		int[] a = new int[n];

		String[] aItems = scan.nextLine().split(" ");

		for (int aItr = 0; aItr < n; aItr++) {
			int aItem = Integer.parseInt(aItems[aItr].trim());
			a[aItr] = aItem;
		}

		int[] b = new int[m];

		String[] bItems = scan.nextLine().split(" ");

		for (int bItr = 0; bItr < m; bItr++) {
			int bItem = Integer.parseInt(bItems[bItr].trim());
			b[bItr] = bItem;
		}

		int total = getTotalX(a, b);

		bw.write(String.valueOf(total));
		bw.newLine();

		bw.close();
	}
}
