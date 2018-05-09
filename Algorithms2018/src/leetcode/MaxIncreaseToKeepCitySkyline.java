package leetcode;

// https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
// Easy peasy.

public class MaxIncreaseToKeepCitySkyline {

	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int [] maxWest = new int [ grid.length ];
		int [] maxSouth = new int [ grid [ 0 ].length ];

		//Filling out the arrays
		for ( int i = 0; i < grid.length; i++ ){
			for ( int j = 0; j < grid [0].length; j++ ){
				int num = grid [ i ][ j ];
				maxWest  [ i ] = Math.max ( maxWest [ i ], num);
				maxSouth [ j ] = Math.max ( maxSouth [ j ] , num);
			}
		}

		//Now, calculate the result.
		int result = 0;


		for ( int i = 0; i < grid.length; i++ ){
			for ( int j = 0; j < grid [0].length; j++ ){
				int num = grid [ i ][ j ];
				result += Math.min (maxWest [ i ], maxSouth [ j ]) - num;
			}
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
