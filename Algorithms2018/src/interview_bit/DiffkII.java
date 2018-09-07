package interview_bit;

import java.util.HashSet;
import java.util.List;

// https://www.interviewbit.com/problems/diffk-ii/
// Seriously, easiest problem ever.
// 2018-09-03
public class DiffkII {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int diffPossible(final List<Integer> nums, int diff) {

		HashSet < Integer > set = new HashSet <> ();

		for ( int num: nums ){
			if ( set.contains ( num - diff) || set.contains ( num + diff) )
				return 1;

			set.add ( num );
		}

		return 0;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
