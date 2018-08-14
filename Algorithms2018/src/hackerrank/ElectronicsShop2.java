package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/electronics-shop/problem?h_r=next-challenge&h_v=zen
// Yep, this was the right approach. O(nlog(n)) for the sorting. After that, O(n).
// 30m. Hmm...
public class ElectronicsShop2 {

	/*
	 * Complete the getMoneySpent function below.
	 */
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		int result = -1;

		Arrays.sort(keyboards);
		Arrays.sort(drives);

		int drivesPointer = drives.length - 1;
		for ( int keyboardsPointer = 0; keyboardsPointer < keyboards.length; keyboardsPointer++){

			int thisSum = keyboards [ keyboardsPointer ];

			drivesPointer = Math.min ( drivesPointer, ( drives.length - 1 ));
			drivesPointer = Math.max ( drivesPointer, 0 );

			thisSum = thisSum + drives [ drivesPointer ];

			if ( thisSum == b ) return b;

			if ( thisSum < b ){
				result = Math.max ( result, thisSum );
				break;
			}
			else {
				drivesPointer--;
				while (drivesPointer >= 0){

					thisSum = keyboards [ keyboardsPointer ] + drives [ drivesPointer ];
					if ( thisSum == b ) return b;

					if ( thisSum > b ){
						drivesPointer--;
					}
					else{
						result = Math.max ( result, thisSum );
						drivesPointer++;	// !OJO! Leave things as they should be!
						break;
					}
				}
			}
		}

		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] bnm = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int b = Integer.parseInt(bnm[0]);

		int n = Integer.parseInt(bnm[1]);

		int m = Integer.parseInt(bnm[2]);

		int[] keyboards = new int[n];

		String[] keyboardsItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
			int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
			keyboards[keyboardsItr] = keyboardsItem;
		}

		int[] drives = new int[m];

		String[] drivesItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		for (int drivesItr = 0; drivesItr < m; drivesItr++) {
			int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
			drives[drivesItr] = drivesItem;
		}

		/*
		 * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
		 */

		int moneySpent = getMoneySpent(keyboards, drives, b);

		bufferedWriter.write(String.valueOf(moneySpent));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}


