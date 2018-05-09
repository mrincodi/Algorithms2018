package leetcode;

// https://leetcode.com/problems/champagne-tower/description/
// A beautiful problem indeed!!

public class ChampagneTower {

	public double champagneTower(int poured, int query_row, int query_glass) {
		double [] prevLevel = new double [ 1 ];
		double [] level     = new double [ 1 ];

		int rowCounter = 0;
		prevLevel[0]=poured;

		if ( query_row == 0 &&  query_glass == 0){
			return  poured > 0?1:0;
		}

		while (rowCounter < query_row){

			level = new double [ prevLevel.length + 1 ];

			for ( int i = 0; i < prevLevel.length; i++){
				if ( prevLevel [ i ] > 1 ){
					level [ i ] += (prevLevel [ i ] - 1) / 2;
					level [ i + 1 ] += (prevLevel [ i ] - 1) / 2;
				}
			}
			prevLevel = level;
			rowCounter++;
		}

		//Now, simply look for the glass.
		double result = level [ query_glass ];
				return result > 1?1:result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
