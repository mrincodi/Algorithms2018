package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/day-of-the-programmer/problem
// 2018-07-25

public class DayOfTheProgrammer {

	static int DAY_PROGRAMMER = 256;

	// Complete the solve function below.
	static String solve(int year) {

		int [] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		// Calculate days of February.

		if ( ( year < 1918 && year % 4 == 0 ) || 
				year > 1918 &&  ( year % 400 == 0 || ( year % 4 == 0 && year % 100 != 0) )){
			months [ 1 ] = 29;
		}

		if ( year == 1918 ) months [ 1 ] = 15;

		// Calculate month.
		int daysLeft = DAY_PROGRAMMER;
		int month = 0;

		int i = 0;
		while ( daysLeft >= months[i] ){
			daysLeft = daysLeft - months [ i ];
			i++;
		}

		i++;
		String monthS = String.valueOf ( i );
		if ( monthS.length() == 1 ) monthS = "0" + monthS;

		String daysLeftS = String.valueOf (daysLeft);
		if ( daysLeftS.length() == 1) daysLeftS = "0" + daysLeftS;

		String result = daysLeftS + "." + monthS + "." + year;

		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int year = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = solve(year);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}
