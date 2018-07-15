package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.interviewbit.com/problems/search-for-a-range/
// Typical. I feel the need to add the "if ( start == end - 1)"
// or I may get infinite loops. Check why solutions don't do this
// extra check.

public class SearchForARange {

	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> list, int x) {
		int left = searchRange ( list, x, true);
		if ( left == -1 ) return new ArrayList<Integer> (Arrays.asList ( -1, -1 ));
		int right = searchRange ( list, x, false);

		return new ArrayList<Integer> (Arrays.asList ( left, right ));
	}

	public int searchRange(final List<Integer> list, int x, boolean isStart) {

		int start = 0;
		int end = list.size() - 1;

		if ( isStart ){
			while ( start < end ){
				if ( list.get(start) == x ) return start;

				if ( start == end - 1) {
					if (list.get(end ) == x  ) return end;
					return -1;
				}
				
				int mid = ( start + end ) / 2;

				if ( list.get ( mid ) < x ) start = mid + 1;
				else end = mid;
			}
		}

		else { 
			while ( start < end ){
				if ( list.get(end) == x ) return end;

				if ( start == end - 1) {
					if (list.get(start ) == x  ) return start;
					return -1;
				}
				
				int mid = ( start + end ) / 2;

				if ( list.get ( mid ) <= x ) start = mid;
				else end = mid - 1;
			}
		}

		if ( start == end && list.get(start) == x ) return start;

		return -1;
	}



	public static void main(String[] args) {
		ArrayList < Integer > list = new ArrayList < Integer > ( Arrays.asList(1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10 ));
		ArrayList < Integer > sol = new SearchForARange().searchRange(list, 1);
		
		System.out.println ( sol.get(0) + " " + sol.get( 1 ));
	}

}
