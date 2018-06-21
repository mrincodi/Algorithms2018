package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

// https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/
// Well, this one worked. And much more elegantly.
// Still, an easier way of doing this is to just try to detect if there is a loop. If
// there is, I cannot finish, and that's it.

public class PossibilityOfFinishingAllCoursesGivenPreRequisites2 {

	public int solve(int n, ArrayList<Integer> A, ArrayList<Integer> B) {
		if ( n == 0 ) return 1;

		java.util.HashMap < Integer, ArrayList < Integer >> graph = new java.util.HashMap < Integer, ArrayList < Integer >>();

		java.util.HashMap < Integer, Integer > howBusyNodes = new java.util.HashMap < Integer, Integer > ();

		java.util.HashSet < Integer > freeNodes  = new java.util.HashSet < Integer > ();

		// Initially, consider all the nodes as "free".
		for ( int i = 1; i <= n; i++ ){
			graph.put(i, new ArrayList < Integer >());
			howBusyNodes.put(i, 0);
			freeNodes.add(i);
		}

		//Fill out the graph:
		for ( int i = 0; i < A.size(); i++ ){
			int source = A.get(i);
			int dest = B.get(i);
			graph.get (source).add(dest);

			howBusyNodes.put(dest, howBusyNodes.get(dest) + 1);
			if ( freeNodes.contains(dest)) freeNodes.remove(dest);
		}

		for ( int i = 1; i <= n; i++ ){

			//Let's just take a free node.
			Iterator < Integer> iter = freeNodes.iterator();
			if ( ! iter.hasNext() ) return 0;
			int freeNode = iter.next();
			freeNodes.remove(freeNode); //Will be added to the sequence, so it's not free anymore.

			//Good. Now let's fix the graph and other numbers.

			for ( int d:graph.get(freeNode)){
				howBusyNodes.put(d, howBusyNodes.get(d) - 1);

				if ( howBusyNodes.get(d) == 0)
					freeNodes.add(d);
			}

			graph.remove(freeNode);	//Not really needed.
		}
		return 1;
	}


	public static void main(String[] args) {
		int r = 0;
				ArrayList < Integer > A = new ArrayList < Integer > (Arrays.asList( 67, 8, 48, 42, 35, 25, 37, 69, 31, 36, 7, 33, 2, 47, 42, 52, 31, 70, 29, 38, 36, 60, 15, 37, 33, 27, 4, 32, 43, 55, 49, 35, 21, 28, 62, 17, 2, 61, 54, 22, 9, 56, 12, 3, 60, 52, 21, 15, 54, 63, 33, 64, 38, 16, 59, 69, 49, 52, 10, 10, 6, 56, 43, 32, 41, 66, 6));
				ArrayList < Integer > B = new ArrayList < Integer > (Arrays.asList( 51, 43, 55, 27, 34, 8, 14, 5, 70, 64, 65, 57, 45, 19, 53, 50, 44, 51, 19, 41, 14, 68, 12, 58, 50, 66, 7, 47, 40, 62, 29, 5, 22, 39, 23, 34, 25, 4, 40, 26, 26, 45, 18, 28, 61, 59, 17, 46, 39, 46, 68, 24, 63, 59, 67, 53, 9, 11, 3, 44, 24, 37, 13, 1, 65, 18, 48));
		//ArrayList < Integer > A = new ArrayList < Integer > (Arrays.asList(1,2,3));
		//ArrayList < Integer > B = new ArrayList < Integer > (Arrays.asList(2,3,1));

		int n = 70;
		r = new PossibilityOfFinishingAllCoursesGivenPreRequisites2().solve(n, A, B);
		System.out.println( r);

	}

}
