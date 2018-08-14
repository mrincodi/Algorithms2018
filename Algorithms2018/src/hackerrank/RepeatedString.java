package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/repeated-string
// Too easy. Seriously.
// 11m
// 2018-08-01

public class RepeatedString {


	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		long result = 0;
		long numAsInS = 0;

		if ( n > s.length()){
			for ( int i = 0; i < s.length(); i++){
				if (s.charAt(i) == 'a') numAsInS++;
			}
		}

		result = ( n / (long) s.length() ) * numAsInS;

		long rest = n % (long) s.length();
		for ( int i = 0; i < rest; i++){
			if (s.charAt(i) == 'a') result++;
		}

		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
