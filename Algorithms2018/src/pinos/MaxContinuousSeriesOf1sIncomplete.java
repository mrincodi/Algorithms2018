package pinos;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/max-continuous-series-of-1s/
// My other solution works. This is not elegant, and doesn't work.

public class MaxContinuousSeriesOf1sIncomplete {


	public ArrayList<Integer> maxone(ArrayList<Integer> A, int m) {

		int i = 0, j = 0;
		int numZeros=0;
		int maxSize = 0;
		int maxStart = 0;
		int maxEnd = 0;

		while ( j < A.size()){
			if (A.get(j) == 0)
				numZeros++;

			if ( numZeros == m){
				int thisSize = j - i + 1;
				if (thisSize > maxSize){
					maxStart = i;
					maxEnd = j;
				}
			}
			else if (numZeros == m + 1){
				do
					i++;
				while (A.get(i)== 1);

				if (A.get(i)==0)
					numZeros--;
			}
		}

		ArrayList<Integer> result = new ArrayList<Integer> ();
		for (  i = maxStart; i <= maxEnd; i++){
			result.add (i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
