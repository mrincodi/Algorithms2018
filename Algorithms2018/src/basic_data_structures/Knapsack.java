package basic_data_structures;

import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack {

	public int maxValue ( ArrayList <Integer> weights,ArrayList <Integer> values, int W){
		int numElements = weights.size();

		//Create matrix.
		int [][]m = new int [numElements][W+1];

		//By default this is true:
		//		for ( int i = 0; i < W; i++)
		//			m[0][i] = 0;

		for ( int i = 1; i < values.size(); i++){
			int valueOfElement =   values.get(i);
			int weightOfElement = weights.get(i);

			for ( int j = 0; j <= W; j++ ){
				if ( j < weightOfElement ) m[i][j]=m[i-1][j];
				else
					m[i][j]=Math.max(m[i-1][j], m[i-1][j-weightOfElement]+valueOfElement);
			}
		}
		
		return m[numElements-1][W];
	}

	public static void main(String[] args) {
		int W = 165;
		ArrayList <Integer> weights = new ArrayList <Integer> (Arrays.asList(23,31,29,44,53,38,63,85,89,82));
		ArrayList <Integer> values = new ArrayList <Integer> (Arrays.asList(92,57,49,68,60,43,67,84,87,72));
		int maxVal = new Knapsack().maxValue(weights, values, W);
		System.out.println (maxVal);
				
		

	}

}
