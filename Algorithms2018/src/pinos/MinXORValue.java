package pinos;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/problems/min-xor-value/

public class MinXORValue {
	public int findMinXor(ArrayList<Integer> A) {
		Collections.sort(A);
		int result = Integer.MAX_VALUE;
		for (int i = 1; i < A.size(); i++){
			int xor = A.get(i) ^ A.get ( i - 1 );
			result = Math.min (result,xor);
		} 
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
