package pinos;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/problems/3-sum/
//Worked!

public class ThreeSum {

	public int threeSumClosest(ArrayList<Integer> A, int B) {
		int result = Integer.MAX_VALUE;
		int result_diff_abs = Integer.MAX_VALUE;
		Collections.sort(A);
		for ( int i = 0; i < A.size()-2; i++){
			for (int j = i+1; j < A.size() -1; j++){
				boolean exitLoop = false;

				int k = j + 1;
				while (!exitLoop ){
					int ai = A.get(i);
					int aj = A.get(j);
					int ak = A.get(k);

					int sum = ai + aj + ak;
					int diff = sum - B;
					int diff_abs = Math.abs ( diff );

                    if (diff_abs == 0) return B;
					if ( diff_abs < result_diff_abs ) {
						result = sum;
						result_diff_abs = diff_abs;
					}
					if ( diff > 0 || k == A.size() - 1 ) exitLoop = true;
					else k++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
