package interview_bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://www.interviewbit.com/problems/2-sum/
// The most typical problem ever.
public class TwoSum {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
		HashMap < Integer, Integer > positions = new HashMap < Integer, Integer > ();
		ArrayList<Integer> result = new  ArrayList<Integer> ();

		for ( int i = 0; i < A.size(); i++ ){
			int n = A.get(i);
			if ( positions.containsKey (B - n )){
				result.add (positions.get ( B - n ));
				result.add (i+1);
				return result;
			}
			if ( ! positions.containsKey ( n ) )
				positions.put ( n, i+1 );
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
