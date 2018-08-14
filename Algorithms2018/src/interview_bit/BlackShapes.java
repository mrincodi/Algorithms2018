package interview_bit;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/black-shapes/
// 2018-07-20
public class BlackShapes {


	public int black(ArrayList<String> A) {
		int result = 0;
		for ( int row = 0; row < A.size(); row++ ){
			for ( int col = 0; col < A.get(row).length(); col++ ){
				if ( A.get(row).charAt(col) == 'X' ){
					cover ( A, row, col );
					result++;
				}
			}
		}  
		return result;
	}


	public void cover ( ArrayList<String> A, int row, int col ){
		String s = A.get ( row );
		s = s.substring ( 0,col) + "O" + s.substring (col + 1);
		A.set ( row, s );

		// Going up.
		if ( row > 0 && A.get(row - 1).charAt(col) == 'X'){
			cover ( A, row - 1, col);
		}

		// Going left.
		if ( col > 0 && A.get(row).charAt(col - 1) == 'X'){
			cover ( A, row, col - 1);
		}

		// Going down.
		if ( row < A.size() - 1 && A.get(row + 1).charAt(col) == 'X'){
			cover ( A, row + 1, col);
		}

		// Going right.
		if ( col < s.length() - 1 && A.get(row).charAt(col + 1) == 'X'){
			cover ( A, row, col + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
