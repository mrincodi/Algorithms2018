package interview_bit;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
// A classic.
// 15m.
// 2018-08-17

public class MergeTwoSortedListsII {
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int pA = 0, pB = 0;

		while ( pA < a.size() && pB < b.size() ){
			int valA = a.get(pA);
			int valB = b.get(pB);

			if ( valA > valB ) {
				a.add (pA, valB );
				pB++;
			}
			pA++;
		}

		for ( ; pB < b.size(); pB++ ){
			a.add(b.get(pB));
		}
	}
}
