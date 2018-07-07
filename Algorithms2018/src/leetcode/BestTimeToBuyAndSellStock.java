package leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// Typical and easy.
public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {

		if ( prices == null || prices.length <= 1) 
			return 0;

		int min = prices [ 0 ];
		int result = 0;

		for ( int i = 1; i < prices.length; i++ ){
			int price = prices [ i ];
			min = Math.min (min, price);
			result = Math.max ( result, price - min );
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
