package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
// Not the optimal solution, as we are not leveraging the creation of the
// hashmaps on previous hashmaps.
// Also (duh), I could have used "equals" for comparing the hashmaps.

public class SherlockAndAnagrams {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
		int result = 0;
		if ( s == null || s.length () <= 1) return 0;
		for ( int length = 1; length < s.length (); length++ ){
			// length = length of substring to compare.

			HashMap < Character, Integer > mapWord1 = new HashMap < Character, Integer > ();
			HashMap < Character, Integer > mapWord2 = new HashMap < Character, Integer > ();

			for ( int i = 0; i <= s.length() - length - 1; i++ ){

				mapWord1 = new HashMap < Character, Integer > ();
				for ( int charPointer = i; charPointer < i + length; charPointer++ ){
					char c = s.charAt ( charPointer );
					mapWord1.put ( c, mapWord1.getOrDefault(c,0)+1);
				}

				for ( int j = i + 1; j <= s.length() - length; j++ ){
					mapWord2 = new HashMap < Character, Integer > ();
					for ( int charPointer = j; charPointer < j + length; charPointer++ ){
						char c = s.charAt ( charPointer );
						mapWord2.put ( c, mapWord2.getOrDefault(c,0)+1);
					}

					// Now, compare the two hashMaps.
					if ( compare ( mapWord1, mapWord2) ){
						result++;
					}
				}
			}
		}

		return result;

	}

	static boolean compare ( HashMap <Character, Integer > h1, HashMap <Character, Integer > h2){
		if ( h1.keySet().size() != h2.keySet().size()) return false;
		Iterator <Character> iter = h1.keySet().iterator();

		while (iter.hasNext()){
			Character c = iter.next();

			if (!h2.containsKey(c) || h2.get(c) != h1.get(c)) return false;
		}

		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = sherlockAndAnagrams(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();

	}

}
