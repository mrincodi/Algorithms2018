package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/flip-array/
// An interesting and difficult problem.
// This solution is failing for some examples.
// I realize that in this knapsack every number's value should be "1".

public class FlipArrayWrong {

	public int solve(final List<Integer> A) {
		int W = 0;
		for ( int val: A){
			W += val;
		}
		
		int half_W = (W%2 == 0?W/2:W/2+1);
		int numChanges = myKnapsack (A,half_W);
		
		return Math.min(numChanges, A.size() - numChanges);
	}

	private int myKnapsack(List<Integer> list, int W) {
		int [][] m = new int [list.size()][W + 1];
		
		for (int w = 0; w <= W; w++)
			m[0][w] = w < list.get(0)?0:list.get(0);
		
		for ( int i = 1; i < list.size();i++){
			for (int w = 0; w <= W; w++){
				if ( w < list.get(i) )
					m[i][w] = m[i-1][w];
				else
					m[i][w] = Math.max(m[i-1][w], m[i-1][w-list.get(i)] + list.get(i));
			}
		}
		
		//Calculate number of changes. From end to beginning.
		int numChanges = 0;
		int currentMaxWeight = W;
		for ( int i = list.size()-1; i >0; i--){
			if (m[i][currentMaxWeight]!=m[i-1][currentMaxWeight]){
				numChanges++;
				currentMaxWeight = currentMaxWeight - list.get(i);
			}
		}
		if (m[0][currentMaxWeight] != 0 ) numChanges++;
		
		return numChanges;
	}

	public static void main(String[] args) {
		ArrayList < Integer> values = new ArrayList < Integer> (Arrays.asList( 11, 10, 8, 6, 8, 11, 1, 10, 2, 3, 8, 3, 8, 12, 11, 1, 7, 5, 5, 12, 9, 4, 10, 3, 3, 3, 8, 8, 8, 6, 7, 7, 7, 6, 4, 2, 5, 8, 11, 10, 10, 10, 12, 9, 2, 3, 9, 12, 7, 6, 11, 8, 9, 9, 10, 3, 3, 5, 2, 10, 10, 9, 4, 9, 6, 11, 10, 2, 6, 1, 4, 7, 10, 3, 4, 3, 9, 4, 3, 8, 1, 1, 3));
		int result = new FlipArrayWrong().solve(values);
		System.out.println(result);

	}

}
