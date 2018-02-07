package pinos;

import java.util.ArrayList;
import java.util.Collections;

// https://www.interviewbit.com/problems/highest-product/
// Easy after checking the possibilities for a while.

public class HighestProduct {

	public int maxp3(ArrayList<Integer> A) {
		Collections.sort(A);
		if ( A.get(A.size() - 1) > 0  ) return A.get(A.size() - 1) * Math.max (A.get(A.size() - 2) * A.get(A.size() - 3), A.get(0) * A.get(1));   
		if ( A.get(A.size() - 1) == 0  ) return 0;
		return A.get(A.size() - 1) * A.get(A.size() - 2) * A.get(A.size() - 3); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
