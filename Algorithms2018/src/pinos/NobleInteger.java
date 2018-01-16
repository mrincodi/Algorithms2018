package pinos;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/noble-integer/

public class NobleInteger {
	public int solve(ArrayList<Integer> A) {
		if ( A.size() == 0 ) return 1; 
		java.util.Collections.sort (A, java.util.Collections.reverseOrder());
		if (A.get(0) == 0 ) return 1;

		for (int i = 1; i < A.size(); i++)
			if (A.get(i)==i && A.get(i-1) != A.get(i))
				return 1;

		return -1;    
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
