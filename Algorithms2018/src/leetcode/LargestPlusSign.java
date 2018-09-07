package leetcode;

// https://leetcode.com/problems/largest-plus-sign/description/
// A beautiful problem.
// 2018-08-20
public class LargestPlusSign {
	public int orderOfLargestPlusSign(int N, int[][] mines) {
		int result = 0;
		if ( N == 0 ) return 0;

		int [][] m = new int [ N ][ N ];


		for ( int [] mine: mines ){
			int row = mine [ 0 ];
			int col = mine [ 1 ];
			m[row][col]=-1;
		}

		// Left-to-right.
		for ( int row = 0; row < N; row++ ){
			int counter = 0;
			for ( int col = 0; col < N; col++ ){
				if ( m [row][col] == -1) counter = 0;
				else{
					counter++;
					m [row][col] = counter;
				}
			}
		}

		// Right-to-left.
		for ( int row = 0; row < N; row++ ){
			int counter = 0;
			for ( int col = N-1; col >=0 ; col-- ){
				if ( m [row][col] == -1) counter = 0;
				else{
					counter++;
					m [row][col] = Math.min ( counter, m [row][col]);
				}
			}
		}

		// Up-to-down.
		for ( int col = 0; col < N ; col++ ){
			int counter = 0;
			for ( int row = 0; row < N; row++ ){
				if ( m [row][col] == -1) counter = 0;
				else{
					counter++;
					m [row][col] = Math.min ( counter, m [row][col]);
				}
			}
		}

		// Down-to-up.
		for ( int col = 0; col < N ; col++ ){
			int counter = 0;
			for ( int row = N-1; row >=0 ; row-- ){
				if ( m [row][col] == -1) counter = 0;
				else{
					counter++;
					m [row][col] = Math.min ( counter, m [row][col]);
					result = Math.max ( result, m [row][col]);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
