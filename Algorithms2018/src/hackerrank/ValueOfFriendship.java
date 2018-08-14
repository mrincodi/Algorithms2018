package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/value-of-friendship/problem
// First approach. Times out.
// 2018-07-31

public class ValueOfFriendship {

	/*
	 * Complete the valueOfFriendsship function below.
	 */
	static int valueOfFriendsship(int n, int[][] friendships) {
		int result = 0;
		ArrayList < HashSet < Integer >> setsArray = new ArrayList < HashSet < Integer >> ();

		for ( int i = 1; i <= n; i++ ){
			HashSet < Integer > set = new HashSet < Integer >();
			set.add(i);
			setsArray.add(set);
		}

		for ( int [] friendship : friendships ){
			int a = friendship [ 0 ];
			int b = friendship [ 1 ];

			// See to what sets they belong.
			int aSet = 0;
			int bSet = 0;
			while ( aSet < setsArray.size() && setsArray.get ( aSet ).contains(a)){
				aSet++;
			}

			while ( bSet < setsArray.size() && setsArray.get ( bSet ).contains(b)){
				bSet++;
			}

			//Possibilities.
			if ( aSet != bSet ){
				//Join both sets.

				Iterator < Integer > iter = setsArray.get ( aSet ).iterator();

				while ( iter.hasNext ()){
					int num = iter.next();
					setsArray.get ( bSet ).add(num);
				}

				setsArray.remove (aSet);
			}

			// Now, calculate the value.

			for ( int i = 0; i < setsArray.size(); i++){
				int size = setsArray.get(i).size();
				result = result + ( size * ( size - 1 ));
			}
		}

		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(scanner.nextLine().trim());

		for (int qItr = 0; qItr < q; qItr++) {
			String[] nm = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nm[0].trim());

			int m = Integer.parseInt(nm[1].trim());

			int[][] friendships = new int[m][2];

			for (int friendshipsRowItr = 0; friendshipsRowItr < m; friendshipsRowItr++) {
				String[] friendshipsRowItems = scanner.nextLine().split(" ");

				for (int friendshipsColumnItr = 0; friendshipsColumnItr < 2; friendshipsColumnItr++) {
					int friendshipsItem = Integer.parseInt(friendshipsRowItems[friendshipsColumnItr].trim());
					friendships[friendshipsRowItr][friendshipsColumnItr] = friendshipsItem;
				}
			}

			int result = valueOfFriendsship(n, friendships);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
	}
}
