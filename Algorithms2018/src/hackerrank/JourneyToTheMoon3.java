package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/journey-to-the-moon/problem
// This code solved this problem:
// I am only leaving this code here because the HashSet.remove method is failing
// and iterator.remove() is failing too. it's not me, it's Java.
// Some issue with equals and hashCode. So I will do it the ugly way:
// creating a new set of sets every time (terrible, but I don't see another option).
// It still fails because of timeout. The failing test case is rather large 
// (1000 pairs).
// It makes sense that it still fails because the solution without recopy is not working properly (blame Java)

public class JourneyToTheMoon3 {

	static int journeyToMoon(int n, int[][] astronaut) {

		int result = 0;

		HashSet < HashSet < Integer >> sets = new HashSet < HashSet < Integer >>();

		for ( int i = 0; i < n; i++){
			HashSet < Integer> newSet = new HashSet < Integer> ();
			newSet.add(i);
			sets.add(newSet);
		}

		for ( int [] pair: astronaut ){
			int small = pair [ 0 ];
			int big = pair [ 1 ];

			if ( small > big ){ // Swap them.
				small = small ^ big;
				big = small ^ big;
				small = small ^ big;
			}
			HashSet < HashSet < Integer >> newSets = new HashSet < HashSet < Integer >>();

			Iterator < HashSet <Integer >> setsIter = sets.iterator();

			HashSet <Integer > fromSet = new HashSet <Integer >();
			HashSet <Integer > toSet = new HashSet <Integer >();

			//Look for small value

			while ( setsIter.hasNext()){
				HashSet <Integer > set = setsIter.next();
				if ( !set.contains(small) && !set.contains(big)){
					HashSet <Integer > newSet = new HashSet <Integer > ();
					newSet.addAll(set);
					newSets.add(newSet);
				} else {
					if ( set.contains(small)){
						toSet = set;
					}
					if ( set.contains(big)){
						fromSet = set;
					}
				}
			}
			HashSet <Integer > newSet = new HashSet <Integer > ();
			newSet.addAll(fromSet);

			if ( fromSet != toSet ){
				newSet.addAll(toSet);
			}
			newSets.add(newSet);

			sets = newSets;
		}

		// Nice. Now, just calculate the pairs.

		ArrayList <Integer> numbers = new ArrayList < Integer>();

		Iterator < HashSet < Integer > > diffSetsIterator = sets.iterator();

		while ( diffSetsIterator.hasNext()){
			numbers.add(diffSetsIterator.next().size());
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

		int [][] q = {{0,2},{1,8}, {1,4}, {2,8}, {2,6}, {3,5}, {6,9}};
		//{{0,1},{2,3},{0,4}};

		int r = journeyToMoon(10, q);
		System.out.println (r);


		//		10 7
		//		0 2
		//		1 8
		//		1 4
		//		2 8
		//		2 6
		//		3 5
		//		6 9




		//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		//
		//		String[] np = scanner.nextLine().split(" ");
		//
		//		int n = Integer.parseInt(np[0]);
		//
		//		int p = Integer.parseInt(np[1]);
		//
		//		int[][] astronaut = new int[p][2];
		//
		//		for (int i = 0; i < p; i++) {
		//			String[] astronautRowItems = scanner.nextLine().split(" ");
		//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		//
		//			for (int j = 0; j < 2; j++) {
		//				int astronautItem = Integer.parseInt(astronautRowItems[j]);
		//				astronaut[i][j] = astronautItem;
		//			}
		//		}
		//
		//		int result = journeyToMoon(n, astronaut);
		//
		//		bufferedWriter.write(String.valueOf(result));
		//		bufferedWriter.newLine();
		//
		//		bufferedWriter.close();
		//
		//		scanner.close();
	}

}