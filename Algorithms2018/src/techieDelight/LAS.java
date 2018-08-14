package techieDelight;

import java.util.ArrayList;

public class LAS {



	public static int largestAlternatingSubsequence ( int [] numbers ){
		int result = 0;
		if ( numbers == null || numbers.length == 0 ) return 0;
		if ( numbers.length == 1 ) return 1;

		ArrayList < Integer > goingUp = new ArrayList < Integer > ();
		ArrayList < Integer > goingDown = new ArrayList < Integer > ();

		goingUp.add(1);
		goingDown.add(1);

		for ( int i = 1; i < numbers.length; i++){
			int n = numbers [ i ];

			int up = 1;
			for ( int j = i-1 ; j >= 0; j--){
				if (numbers [ j ] < n)
					up = Math.max(up,  goingDown.get(j) + 1);
			}

			int down = 1;
			for ( int j = i-1 ; j >= 0; j--){
				if (numbers [ j ] > n)
					down = Math.max(down,  goingUp.get(j) + 1);
			}

			result = Math.max ( result, up );
			result = Math.max ( result, down );

			goingUp.add(up);
			goingDown.add ( down);
			
			System.out.println ("");
		}

		return result;

	}









	public static void main(String[] args)
	{
		int[] A = { 8, 9, 6, 4, 5, 7, 3, 2, 4 };

		// lookup table to store solutions of subproblem
		// max(lookup[i][0], lookup[i][1]) stores longest sequence
		// till A[0..i]
		//int[][] lookup = new int[A.length][2];

		System.out.println("The length of Longest Subsequence is "
				+ largestAlternatingSubsequence(A)); // 8 9 6 7 3 4 
	}

}
