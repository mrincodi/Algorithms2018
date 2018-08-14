package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/picking-numbers/problem?h_r=next-challenge&h_v=zen
// Cute.
// 2018-07-30
public class PickingNumbers {

	// Complete the pickingNumbers function below.
	static int pickingNumbers(int[] a) {

		int result = 0;

		HashMap < Integer, Integer > amounts = new HashMap < Integer, Integer > ();

		for ( int n: a){
			amounts.put (n, amounts.getOrDefault ( n, 0 ) + 1);
		}

		Iterator < Integer > iter = amounts.keySet ().iterator ();

		while ( iter.hasNext()){
			int n = iter.next();

			int setSize = amounts.get(n);
			if ( amounts.containsKey(n+1)) setSize = setSize + amounts.get(n+1);

			result = Math.max ( result, setSize );
		}

		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int result = pickingNumbers(a);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
