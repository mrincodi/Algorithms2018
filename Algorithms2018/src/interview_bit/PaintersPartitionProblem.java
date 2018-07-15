package interview_bit;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/painters-partition-problem/
// A DIFFICULT problem. The binary search solution is not obvious at all.
// This is InterviewBit's solution. understood, but still, it's not obvious
// to try a binary search approach.

public class PaintersPartitionProblem {

	private static final int MOD = 10000003;

	public int paint(int A, int B, ArrayList<Integer> C) {

		long res = Long.MAX_VALUE;
		long low = 0;
		long high = Long.MAX_VALUE;
		long mid;

		while (low <= high) {

			mid = low + ((high - low) >> 1);

			boolean status = possible(A, B, C, mid);

			if (status) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}


		return (int) (res % MOD);

	}

	private boolean possible(int A, int B, ArrayList<Integer> C, long time) {

		int n = C.size();
		int index = 0;
		long total;

		for (int i = 0; i < A && index < n; i++) {

			total = 0;

			while (total < time && index < n) {
				total += (1L * C.get(index) * B);
				if (total > time)
					break;
				index++;
			}
		}

		if (index != n)
			return false;

		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
