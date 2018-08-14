package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
// Enhanced (whew!)

public class SherlockAndAnagrams2 {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
		int result = 0;
		if ( s == null || s.length () <= 1) return 0;
		for ( int length = 1; length < s.length (); length++ ){
			// length = length of substring to compare.

			HashMap < Character, Integer > mapWord1 = new HashMap < Character, Integer > ();
			HashMap < Character, Integer > mapWord2 = new HashMap < Character, Integer > ();

			mapWord1 = new HashMap < Character, Integer > ();
			for ( int charPointer = 0; charPointer < length; charPointer++ ){
				char c = s.charAt ( charPointer );
				mapWord1.put ( c, mapWord1.getOrDefault(c,0)+1);
			}
			
			for ( int i = 0; i <= s.length() - length - 1; i++ ){
				if ( i > 0 ){
					char c = s.charAt(i + length - 1);
					mapWord1.put ( c, mapWord1.getOrDefault(c, 0) + 1);
					
					c = s.charAt(i - 1);
					mapWord1.put ( c, mapWord1.get(c) - 1);
					if ( mapWord1.get(c) == 0)
						mapWord1.remove(c);
				}

				mapWord2 = new HashMap < Character, Integer > ();
				for ( int charPointer = i + 1; charPointer < i + length + 1; charPointer++ ){
					char c = s.charAt ( charPointer );
					mapWord2.put ( c, mapWord2.getOrDefault(c,0)+1);
				}
				
				
				for ( int j = i + 1; j <= s.length() - length; j++ ){
					
					if ( j > i + 1 ){
						char c = s.charAt(j + length - 1);
						mapWord2.put ( c, mapWord2.getOrDefault(c, 0) + 1);
						
						c = s.charAt(j - 1);
						mapWord2.put ( c, mapWord2.get(c) - 1);
						if ( mapWord2.get(c) == 0)
							mapWord2.remove(c);
					}


					// Now, compare the two hashMaps.
					if (  mapWord1.equals(mapWord2) ){
						result++;
					}
				}
			}
		}

		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int q = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int qItr = 0; qItr < q; qItr++) {
//			String s = scanner.nextLine();
//
//			int result = sherlockAndAnagrams(s);
//
//			bufferedWriter.write(String.valueOf(result));
//			bufferedWriter.newLine();
//		}
//
//		bufferedWriter.close();
//
//		scanner.close();

		String s = "kkkk";
		int r = sherlockAndAnagrams(s);
		System.out.println ( r );
		
	}

}
