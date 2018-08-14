package leetcode.SmallestSubarrayWithAtleastKSum;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
// This is the only solution that work with negatives.
// Good luck understanding it.
// I copied it from https://leetcode.com/articles/shortest-subarray-with-sum-atleast-k/
// The rest of the text was my other attempts. The problem is very manageable when it's all positives.

public class SubarrayWithSumAtLeastKLeetCode {

	/*
	public int shortestSubarray(int[] array, int n) {

		// Find smallest number. If it's negative, fix all numbers.
		//             int min = 0;
		//             for ( int v: array )
		//                 min = Math.min (min, v);

		//             if ( min < 0 ){
		//                 for ( int i = 0; i < array.length; i++ ){
		//                     array [ i ] = array [ i ] + (-min);
		//                 }
		//                 n = n + (-min);
		//             }

		int start = 0, end = 0, sum = array [ 0 ];
		int result = Integer.MAX_VALUE;

		// Initially, get to the first non-negative position.

		while (array [ start ] < 0 && start < array.length)
			start++;

		end = start;
		sum = array [ start ];
		while ( end < array.length ){

			// if ( sum < n ){
			//     end++;
			//     if ( end == array.length ) break;
			//     sum = sum + array [ end ];
			// }
			if ( sum < n ){
				end++;
				if ( end == array.length ) break;
				sum = sum + array [ end ];

				while ( array [ end ] < 0){
					end++;
					if ( end == array.length ) break;
					sum = sum + array [ end ];
				}

			}
			else {
				result = Math.min (result, end - start + 1 );

				sum = sum - array [ start ];
				start++; 
				if ( start == array.length ) break;

				// Move start to the right until you find the next
				// non-negative number.

				while ( end <= start && array [ start ] < 0){
					sum = sum - array [ start ];
					start++;
				}

				if ( start > end ) {

					// All-right.
					// We need to move start to the right until we find a non-negative number.
					while ( start < array.length && array [ start ] < 0){
						start++;
					}
					if ( start == array.length ) break;

					end = start;
					sum = array [ end ];
				}


			}
		}

		if ( result == Integer.MAX_VALUE ) return -1;
		else return result;
	}
	 */

	// Solution that works for some strange reason.
	public int shortestSubarray(int[] A, int K) {
		int N = A.length;
		long[] P = new long[N+1];
		for (int i = 0; i < N; ++i)
			P[i+1] = P[i] + (long) A[i];

		// Want smallest y-x with P[y] - P[x] >= K
		int ans = N+1; // N+1 is impossible
		Deque<Integer> monoq = new LinkedList <Integer> (); //opt(y) candidates, as indices of P

		for (int y = 0; y < P.length; ++y) {
			// Want opt(y) = largest x with P[x] <= P[y] - K;
			while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
				monoq.removeLast();
			while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
				ans = Math.min(ans, y - monoq.removeFirst());

			monoq.addLast(y);
		}

		return ans < N+1 ? ans : -1;
	}

	public static void main(String[] args) {
		int [] array = {-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6};
		int n = 151;

		int r = new SubarrayWithSumAtLeastKLeetCode().shortestSubarray(array, n);
		System.out.println(r);

	}

}
