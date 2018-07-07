package interview_bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// https://www.interviewbit.com/problems/merge-overlapping-intervals/
// This is SUCH an important problem! Totally worth it.
// A better way to do this is to:
// - Sort the intervals first.
// - Implement the logic for sorting pair-wise, adding the intervals to
// "result" whenever the current interval is disjoint from the previous
//  one.

class CompareIntervals implements Comparator < Interval > {
	public int compare ( Interval a, Interval b){
		if ( a.start <= b.start ) return -1;
		if ( a.start == b.start ) return 0;
		return 1;
	}
}

public class MergeOverlappingIntervals {

	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		ArrayList < Interval > alreadyIntervals = new ArrayList < Interval > ();

		for (Interval interval : intervals){
			// Find if there is an intersection between an interval and
			// previous ones.

			boolean finish = false;

			inner:
				while ( !finish ){

					for ( int i = 0; i < alreadyIntervals.size(); i++ ){
						Interval alreadyInterval = alreadyIntervals.get ( i );
						if ( intersection ( interval, alreadyInterval ) ){ // TODO
							Interval newInterval = join ( interval, alreadyInterval ); // TODO
							alreadyIntervals.remove ( i );
							interval = newInterval;
							continue inner;
						}
					}

					alreadyIntervals.add(interval);
					finish = true;
				}
		}

		// Return result. They need to be sorted;
		return sort ( alreadyIntervals ); // TODO
	}

	private boolean intersection ( Interval a, Interval b ){
		//a before b
		if ( a.start < b.start ) return b.start <= a.end;
		if ( a.start == b. start ) return true;
		return b.end >= a.start;
	}

	private Interval join (  Interval a, Interval b ) {
		// Thinking goes here.
		Interval result = new Interval (
				Math.min (a.start, b.start),
				Math.max (a.end, b.end ));

		return result;
	}

	private ArrayList < Interval > sort ( ArrayList < Interval > a){
		Collections.sort ( a, new CompareIntervals() );
		return a;
	}

	public static void main(String[] args) {
		ArrayList < Interval > a = new ArrayList < Interval > ();
		a.add( new Interval  (1, 10));
		a.add( new Interval  (2, 9));
		a.add( new Interval  (3, 8));
		a.add( new Interval  (4, 7));
		a.add( new Interval  (5, 6));
		a.add( new Interval  (6, 6));

		ArrayList < Interval > b = new MergeOverlappingIntervals().merge(a);

		for ( Interval i: b)
			System.out.println ( i.start + " " + i.end);

	}

}
