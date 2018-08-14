package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
// 2018-07-26
public class ClimbingTheLeaderboard {

	// Complete the climbingLeaderboard function below.
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		ArrayList < Integer > scores2 = new ArrayList < Integer > ();

		scores2.add (scores [ 0 ]);

		for ( int i = 1; i < scores.length; i++){
			if ( scores [ i ] != scores [ i - 1 ]){
				scores2.add(scores [ i ]);
			}
		}

		int [] result = new int [ alice.length ];
		int scoresPointer = scores2.size() - 1;

		for ( int i = 0; i < alice.length; i++ ){
			int n = alice [ i ];
			int r = 0;

			// Scores is decreasing and alice is increasing.

			if ( n < scores2.get( scores2.size() - 1)){
				r = scores2.size() + 1;
			}
			else {
				while ( scoresPointer >= 0 && 
						scores2.get(scoresPointer) < n) scoresPointer--;

				if ( scoresPointer >= 0 ) {
					if ( n == scores2.get(scoresPointer)){
						r = scoresPointer + 1;
					}
					else 
						r = scoresPointer + 2;
				}
				else 
					r = 1;
			}
			result [ i ] = r;   
		}        
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int scoresCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[scoresCount];

		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < scoresCount; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
		}

		int aliceCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] alice = new int[aliceCount];

		String[] aliceItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < aliceCount; i++) {
			int aliceItem = Integer.parseInt(aliceItems[i]);
			alice[i] = aliceItem;
		}

		int[] result = climbingLeaderboard(scores, alice);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}



}
