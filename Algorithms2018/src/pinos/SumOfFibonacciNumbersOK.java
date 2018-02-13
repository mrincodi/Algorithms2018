package pinos;

import java.util.HashMap;

//https://www.interviewbit.com/problems/sum-of-fibonacci-numbers/
// This is the solution with DP, but Interviewbit complains of heap space.
// I don't actually need a whole matrix. I can just save the previous row
// each time.

public class SumOfFibonacciNumbersOK {

	public int fibsum(int N) {

		//Calculate fibonacci until N.
		//Create a HashMap for it.

		if ( N <=2 ) return 1;
		HashMap <Integer, Integer> fib = new HashMap <Integer, Integer> ();

		fib.put(0,0);
		fib.put(1,1);
		fib.put(2,2);

		int lastFib = 2;
		int i = 3;

		while ( lastFib <= N){
			fib.put(i,fib.get(i-1)+fib.get(i-2));
			lastFib = fib.get(i);
			i++;
		}


		int [][] m = new int [i-1][N+1];

		for ( i = 1; i <= N; i++)
			m[0][i] = Integer.MAX_VALUE;

		for ( i = 1; i <m.length; i++){
			int thisFib = fib.get(i);
			for (int j = 1; j <= N; j++){
				if (j < thisFib) m[i][j] = m [i-1][j];
				else {
					int timesIntoThisFib = j/thisFib;
					int rest = j % thisFib;
					int numTimesIfUsed = timesIntoThisFib + m[i-1][rest];
					m[i][j] = Math.min (m[i-1][j], numTimesIfUsed);
				}
			}
		}

		return m[m.length - 1][N];
	}

	public static void main(String[] args) {
		int N = 59;
		int s = new SumOfFibonacciNumbers().fibsum(N);
		System.out.println(s);

	}

}
