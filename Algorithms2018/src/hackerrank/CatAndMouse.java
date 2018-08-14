package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
// OK, this one was ridiculously easy.
// 5m
public class CatAndMouse {

	// Complete the catAndMouse function below.
	static String catAndMouse(int a, int b, int c) {
		int diffA = Math.abs ( a - c );
		int diffB = Math.abs ( b - c );

		if ( diffA == diffB ) return "Mouse C";
		if ( diffA <  diffB ) return "Cat A";
		return "Cat B";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] xyz = scanner.nextLine().split(" ");

			int x = Integer.parseInt(xyz[0]);

			int y = Integer.parseInt(xyz[1]);

			int z = Integer.parseInt(xyz[2]);

			String result = catAndMouse(x, y, z);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}

}
