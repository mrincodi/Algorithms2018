package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

// https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/
// Works, but takes too long.

public class PossibilityOfFinishingAllCoursesGivenPreRequisites {

	public int solve(int n, ArrayList<Integer> A, ArrayList<Integer> B) {
		if ( n == 0 ) return 1;
		ArrayList < Integer > seq = new ArrayList < Integer >();

		HashSet < Integer > courses = new HashSet < Integer > ();

		for ( int i = 1; i <= n; i++ ){
			courses.add (i);
		}

		if ( courses.size () < n ) return 0;

		for ( int i = 1; i <= n; i++ ){
			int nodeInSeq = 0;
			try {
				nodeInSeq = findFreeNode ( courses, B );
			}
			catch ( Exception e ){
				return 0;
			}
			fixArrays ( A, B, nodeInSeq );
			courses.remove(nodeInSeq);
		}
		return 1;
	}

	int findFreeNode ( HashSet < Integer > courses, ArrayList < Integer > b) throws Exception {
		Iterator < Integer > iter = courses.iterator ();

		outer:
			while ( iter.hasNext ()){
				int possible = iter.next ();

				for ( int i = 0; i < b.size(); i++ ){
					if ( b.get ( i ) == possible ){
						continue outer;
					}
				}
				return possible;

			}
		throw new Exception ();
	}

	void fixArrays ( ArrayList < Integer > a, ArrayList < Integer > b, int n){
		for ( int i = a.size () - 1; i >= 0; i-- ){
			if ( a.get ( i ) == n ){
				a.remove ( i );
				b.remove ( i );
			}
		}
	}

	public static void main(String[] args) {
		int r = 0;
		ArrayList < Integer > A = new ArrayList < Integer > (Arrays.asList( 67, 8, 48, 42, 35, 25, 37, 69, 31, 36, 7, 33, 2, 47, 42, 52, 31, 70, 29, 38, 36, 60, 15, 37, 33, 27, 4, 32, 43, 55, 49, 35, 21, 28, 62, 17, 2, 61, 54, 22, 9, 56, 12, 3, 60, 52, 21, 15, 54, 63, 33, 64, 38, 16, 59, 69, 49, 52, 10, 10, 6, 56, 43, 32, 41, 66, 6));
		ArrayList < Integer > B = new ArrayList < Integer > (Arrays.asList( 51, 43, 55, 27, 34, 8, 14, 5, 70, 64, 65, 57, 45, 19, 53, 50, 44, 51, 19, 41, 14, 68, 12, 58, 50, 66, 7, 47, 40, 62, 29, 5, 22, 39, 23, 34, 25, 4, 40, 26, 26, 45, 18, 28, 61, 59, 17, 46, 39, 46, 68, 24, 63, 59, 67, 53, 9, 11, 3, 44, 24, 37, 13, 1, 65, 18, 48));

		int n = 70;
		r = new PossibilityOfFinishingAllCoursesGivenPreRequisites().solve(n, A, B);
		System.out.println( r);

	}

}
