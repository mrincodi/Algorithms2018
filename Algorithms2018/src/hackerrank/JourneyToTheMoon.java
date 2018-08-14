package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/journey-to-the-moon/problem
// Nice little problem. Failing for timeout in one out of 16 tests
// No idea why (grr...).
// TODO: DO this with... Hashmaps! A hashmap <Integer, HashSet < Integer > > (!!!)

public class JourneyToTheMoon {


	// Complete the journeyToMoon function below.
	static int journeyToMoon(int n, int[][] astronaut) {

		int result = 0;

		ArrayList < HashSet < Integer >> sets = new ArrayList < HashSet < Integer >>();

		for ( int i = 0; i < n; i++){
			sets.add(new HashSet < Integer> ());
			sets.get(i).add(i);
		}

		// Start joining sets.
		for ( int [] pair: astronaut ){
			int small = pair [ 0 ];
			int big = pair [ 1 ];

			if ( small > big ){ // Swap them.
				small = small ^ big;
				big = small ^ big;
				small = small ^ big;
			}

			int dest = -1;
			int source = -1;

			// Look for location of the small number.
			int ii = 0;
			while ( ii < sets.size()){
				if ( sets.get(ii).contains (small))
					dest = ii;

				if ( sets.get(ii).contains (big))
					source = ii;

				if (source != -1 && dest != -1 ) break;

				ii++;
			}

			if ( source != dest ){
				// Put all elements of source in dest,
				// and get rid of dest.
				HashSet sourceSet = sets.get(source);
				HashSet destSet = sets.get(dest);

				Iterator < Integer > iter = sourceSet.iterator();

				while ( iter.hasNext ()){
					destSet.add (iter.next());
				}

				//Just get rid of the source set.
				sets.remove(source);
			}
		}

		// Nice. Now, just calculate the pairs.
		ArrayList <Integer> numbers = new ArrayList < Integer>();

		for ( HashSet <Integer> set: sets ){
			numbers.add(set.size());
		}

		if ( numbers.size() <= 1) return 0;

		for ( int i = 0; i < numbers.size() - 1; i++){
			for ( int j = i + 1; j < numbers.size(); j++){
				result = result + ( numbers.get(i) * numbers.get(j));
			}
		}

		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] np = scanner.nextLine().split(" ");

		int n = Integer.parseInt(np[0]);

		int p = Integer.parseInt(np[1]);

		int[][] astronaut = new int[p][2];

		for (int i = 0; i < p; i++) {
			String[] astronautRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int astronautItem = Integer.parseInt(astronautRowItems[j]);
				astronaut[i][j] = astronautItem;
			}
		}

		int result = journeyToMoon(n, astronaut);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}
