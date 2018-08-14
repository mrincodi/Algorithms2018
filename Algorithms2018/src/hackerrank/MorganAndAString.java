package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/morgan-and-a-string/problem
// A problem seemingly easy but... no. I don't know what's wrong with this code.
// It may not be the fastest one, but all tests are failing. Hmm...
public class MorganAndAString {


	// Complete the morganAndString function below.
	static String morganAndString(String a, String b) {

		String result = "";

		int pointerA = 0, pointerB = 0;

		outer:
			while ( pointerA < a.length() || pointerB < b.length()){
				if ( pointerA == a.length()) {
					result = result + b.charAt(pointerB++);
				}
				else if ( pointerB == b.length()) {
					result = result + a.charAt(pointerA++);
				}
				else {
					char ca = a.charAt ( pointerA );
					char cb = b.charAt ( pointerB );

					if ( ca < cb ) {
						result = result + ca;
						pointerA++;
					}
					else if ( cb < ca ){
						result = result + cb;
						pointerB++;
					}
					else {
						// Find the smallest successor.
						int extraPointer = 1;
						while ( pointerA + extraPointer < a.length() && pointerB + extraPointer < b.length()){
							char cEa = a.charAt ( pointerA + extraPointer);
							char cEb = b.charAt ( pointerB + extraPointer);

							if ( cEa < cEb ){
								result = result + cEa;
								pointerA++;
								continue outer;
							}
							else if  ( cEb < cEa ){
								result = result + cEb;


								pointerB++;
								continue outer;
							}

							extraPointer++;
						}

						// We got to the point in which both are the same.
						if ( pointerA + extraPointer == a.length() && pointerB + extraPointer == b.length()){
							// Both are equal. It doesn't matter which one I take it from.
							result = result + ca;
							pointerA++;
						}
						else {
							if ( pointerA + extraPointer == a.length() ){
								// Compare the current one of B with the next letter.
								// If next letter is smaller than current one, cut from here.
								// else, cut from A.
								if ( b.charAt ( pointerB + extraPointer ) > b.charAt ( pointerB + extraPointer + 1)){
									result = result + cb;
									pointerB++;
								}
								else {
									result = result + ca;
									pointerA++;
								}
							}
							else {
								// The opposite.
								// Compare the current one of B with the next letter.
								// If next letter is smaller than current one, cut from here.
								// else, cut from A.
								if ( a.charAt ( pointerA + extraPointer ) > a.charAt ( pointerA + extraPointer + 1)){
									result = result + ca;
									pointerA++;
								}
								else {
									result = result + cb;
									pointerB++;
								}
							}

						}
					}
				}
			}

		return result;


	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String a = scanner.nextLine();

			String b = scanner.nextLine();

			String result = morganAndString(a, b);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
