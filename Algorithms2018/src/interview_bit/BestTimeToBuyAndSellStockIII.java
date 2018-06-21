package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/
// A very nice way to solve this one, from 
// https://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/

public class BestTimeToBuyAndSellStockIII {

	public int maxProfit(final List<Integer> A) {
		int result = 0;

		if (A.size() < 2) return 0;
		//Get the profit from left to right.

		int [] left = new int [ A.size()];
		int [] right = new int [ A.size()];

		int min = A.get(0);
		left[0]=0;

		for ( int i = 1; i < left.length; i++){
			min = Math.min(A.get(i), min);
			left[i]= Math.max( left[i-1], A.get(i) - min );
		}

		int max = A.get(A.size()-1);
		right[right.length-1]=0;

		for ( int i = A.size() - 2; i >=0; i--){
			max = Math.max(A.get(i), max);
			right[i] = Math.max(right [ i + 1 ], max - A.get(i));
		}

		result = 0;

		for ( int i = 0; i < left.length - 1; i++){
			result = Math.max(result, left [ i ] + right[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		ArrayList < Integer > input = new ArrayList < Integer > ( Arrays.asList(4,3,2,1));

		System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(input));
	}

}
