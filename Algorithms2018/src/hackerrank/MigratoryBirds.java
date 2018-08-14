package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MigratoryBirds {

	// Complete the migratoryBirds function below.
	static int migratoryBirds(int[] ar) {
		HashMap < Integer, Integer > birds = new HashMap < Integer, Integer > ();

		int maxType = -1;
		int maxNumber = 0;

		for (int b: ar ){
			birds.put ( b, birds.getOrDefault (birds.get(b), 0) + 1);

			if ( birds.get (b) > maxNumber){
				maxNumber = birds.get (b);
				maxType = b;
			}
		}
		return maxType;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int arCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[arCount];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < arCount; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = migratoryBirds(ar);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}



}
