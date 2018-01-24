package pinos;

import java.util.ArrayList;
import java.util.HashMap;

//https://www.interviewbit.com/problems/n-digit-numbers-with-digit-sum-s-/
// This works and it's cool. InterviewBit's solution seems to be based in the
// knapsack problem!
public class NDigitNumbersWithDigitSumS {

	public int solve(int N, int S) {
		ArrayList<HashMap<Integer,Long>> NumbersAtPosition = new ArrayList<HashMap<Integer,Long>> ();
		for ( int i = 0; i < N; i++){
			NumbersAtPosition.add(new HashMap<Integer,Long>());
		}
		return (int) (solve (N,S,true,NumbersAtPosition) % 1000000007L);
	}

	long solve(int N, int S, boolean isFirst,ArrayList<HashMap<Integer,Long>> NumbersAtPosition) {
		long result = 0L;

		if ( N == 1 ) return S <= 9?1:0;

		if ( NumbersAtPosition.get(N-1).containsKey(S)) return NumbersAtPosition.get(N-1).get(S);

		int start = isFirst?1:0;

		for ( int i = start; i <= Math.min (9,S); i++){
			result += ( solve (N-1, S-i, false,NumbersAtPosition)  % 1000000007L);
		}
		NumbersAtPosition.get(N-1).put(S,result);
		return result;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
