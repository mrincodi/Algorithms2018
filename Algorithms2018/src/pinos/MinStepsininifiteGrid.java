package pinos;

import java.util.ArrayList;
public class MinStepsininifiteGrid {
	//https://www.interviewbit.com/problems/min-steps-in-infinite-grid/


	public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		int result = 0;
		if ( A.size () <= 1 ) return 0;

		int x = A.get(0);
		int y = B.get(0);

		for ( int i = 1; i < A.size(); i++){
			int distH = Math.abs (A.get(i) - x);
			int distV = Math.abs (B.get(i) - y);

			result += Math.max (distH, distV);

			x = A.get(i);
			y = B.get(i);
		}

		return result;




	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
