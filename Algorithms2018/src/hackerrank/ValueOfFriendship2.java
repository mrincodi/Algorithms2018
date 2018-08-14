package hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/value-of-friendship/problem
// Third approach. Still times out. I am clueless on how to speed this up. Maybe with Math?
// 2018-07-31

public class ValueOfFriendship2 {

	/*
	 * Complete the valueOfFriendsship function below.
	 */
	static int valueOfFriendsship(int n, int[][] friendships) {
		int result = 0;
		int prevSuma = 0;
		ArrayList < HashSet < Integer >> setsArray = new ArrayList < HashSet < Integer >> ();

		for ( int [] friendship : friendships ){
			int thisSuma = 0;
			int a = friendship [ 0 ];
			int b = friendship [ 1 ];

			// See to what sets they belong.
			int aSet = 0;
			int bSet = 0;
			while ( aSet < setsArray.size() && !setsArray.get ( aSet ).contains(a)){
				aSet++;
			}

			while ( bSet < setsArray.size() && !setsArray.get ( bSet ).contains(b)){
				bSet++;
			}

			if ( aSet == setsArray.size() && bSet == setsArray.size() ){
				// Create a new set with these two elements.
				HashSet < Integer > set = new HashSet < Integer > ();
				set.add(a);
				set.add(b);
				setsArray.add(set);
				thisSuma = prevSuma + 2;
			}
			else if ( aSet == setsArray.size()){
				//Just add a to bSet.

				int size = setsArray.get ( bSet ).size();	            	
				setsArray.get ( bSet ).add(a);
				thisSuma = prevSuma +  2 * size;
			}
			else if ( bSet == setsArray.size()){
				//Just add b to aSet.
				int size = setsArray.get ( aSet ).size();
				setsArray.get ( aSet ).add(b);
				thisSuma = prevSuma +  2 * size;
			}
			else if ( aSet != bSet ){
				//Join both sets.
				int sizeA = setsArray.get ( aSet ).size();
				int sizeB = setsArray.get ( bSet ).size();

				Iterator < Integer > iter = setsArray.get ( aSet ).iterator();

				while ( iter.hasNext ()){
					int num = iter.next();
					setsArray.get ( bSet ).add(num);
				}

				setsArray.remove (aSet);
				thisSuma = prevSuma + 2 * sizeA * sizeB;
			}
			else {
				thisSuma = prevSuma;
			}
			// Now, calculate the value.

			result = result + thisSuma;
			prevSuma = thisSuma;
			//System.out.println(result);
		}

		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = 5;
		int [][] friendships = new int [4][2];
		int [] a = { 1,2};
		int [] b = { 3,2};
		int [] c = { 4,2};
		int [] d = { 4,3};

		friendships[0]=a;
		friendships[1]=b;
		friendships[2]=c;
		friendships[3]=d;

		int result = valueOfFriendsship(n, friendships);

		System.out.println(result);

	}
}
