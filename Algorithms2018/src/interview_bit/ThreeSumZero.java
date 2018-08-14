package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumZero {


	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

		ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>> ();
		if (A == null ) return null;
		if ( A.size() < 3 ) return result;
		Collections.sort (A);

		for ( int i = 0; i < A.size() - 2 ; i++ ){
			int n = A.get ( i );
			if ( i > 0 && n == A.get(i - 1) ) continue;

			int j = i + 1;
			int k = A.size() - 1;

			while ( j < k ){
				int sum = A.get (j) + A.get(k);

				if ( sum == -n ){
					//ArrayList<Integer> r = new ArrayList < Integer > ( Arrays.asList ( n, A.get(j), A.get(k)));
					if ( result.size() == 0 )
						result.add ( new ArrayList < Integer > ( Arrays.asList ( n, A.get(j), A.get(k))));
					else {
						ArrayList<Integer> prev = result.get(result.size() - 1 );
						if ( ! ( prev.get(1) == A.get(j) && prev.get(2) == A.get(k))){
							result.add ( new ArrayList < Integer > ( Arrays.asList ( n, A.get(j), A.get(k))));
						}
					}
					j++;
					k--;
				}
				else if ( sum > -n ){
					k--;
				}
				else {
					j++;
				}



				// // fix j and k.
				// while ( j < k && A.get(j+1) == A.get(j) ){
				//     j = j + 1;
				// } 

				// while ( k > j && A.get(k - 1) == A.get(k) ){
				//     k = k - 1;
				// } 



			} 
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
