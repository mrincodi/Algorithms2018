package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


// https://www.hackerrank.com/challenges/non-divisible-subset/problem
// First approach. Doesn't work. I was on the right path, though!
// 2018-08-01

public class NonDivisibleSubsetFirstApproach {

	// Complete the nonDivisibleSubset function below.
	static int nonDivisibleSubset(int k, int[] S) {
		int result = 0;

		ArrayList < ArrayList < Integer >> solutions = new ArrayList < ArrayList < Integer >>();
		ArrayList < HashSet < Integer >>     minSets = new ArrayList < HashSet   < Integer >>();

		solutions.add(new ArrayList <Integer > ( Arrays.asList ( S [ 0 ])));
		minSets.add  (new HashSet <Integer > ( ));
		minSets.get(0).add ( S [ 0 ] % k);


		// Go over all the numbers
		for ( int i = 1; i < S.length; i++ ){
			int n = S [ i ];    
			int m = S [ i ] % k;    // Number we will add to all the elements of all the minSets.

			// Go over all the minSets.
			// For each one, check that each element plus m is not divisible by k.

			boolean workedForASet = false;
			for ( int j = 0; j < minSets.size(); j++){
				// For each set, check all the elements of the set.

				HashSet < Integer > minSet = minSets.get(j);
				Iterator < Integer > iter = minSet.iterator();

				boolean works = true;
				while ( iter.hasNext() && works ){
					int num = iter.next();
					if ( (num + m) % k == 0 ){
						works = false;
						workedForASet = true;
					}
				}
				if ( works ){
					solutions.get(j).add(n);
					minSet.add(m);
				}
			}         

			if ( !workedForASet ){
				solutions.add(new ArrayList <Integer > ( Arrays.asList ( n )));
				minSets.add  (new HashSet <Integer > ( ));
				minSets.get  (minSets.size() - 1).add ( m ); 
			} 
		}

		// Find the solution with the most elements.

		for ( ArrayList <Integer > solution : solutions ){
			result = Math.max ( result, solution.size() );
			System.out.println ( solution );
		}

		if ( result == 1 ) result = 0;
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] S = new int[n];

		String[] SItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int SItem = Integer.parseInt(SItems[i]);
			S[i] = SItem;
		}

		int result = nonDivisibleSubset(k, S);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
