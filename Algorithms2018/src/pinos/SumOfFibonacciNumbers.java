package pinos;

import java.util.HashMap;

//https://www.interviewbit.com/problems/sum-of-fibonacci-numbers/
//Well, this didn't do the trick either. :/
public class SumOfFibonacciNumbers {

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

		int numFibs = i-1;

		int [] prevRow = new int [N+1];
		int []thisRow = new int [N+1];

		for ( i = 1; i <= N; i++)
			prevRow[i] = Integer.MAX_VALUE;

		for ( i = 1; i <numFibs; i++){
			int thisFib = fib.get(i);
			thisRow = new int [N+1];
			for (int j = 1; j <= N; j++){
				if (j < thisFib) thisRow[j] = prevRow [j];
				else {
					int timesIntoThisFib = j/thisFib;
					int rest = j % thisFib;
					int numTimesIfUsed = timesIntoThisFib + prevRow [rest];
					thisRow[j] = Math.min (prevRow [j], numTimesIfUsed);
				}
			}
			prevRow = thisRow;
			System.gc();
		}

		return thisRow[N];
	}

	public static void main(String[] args) {
		int N = 55;
		int s = new SumOfFibonacciNumbers().fibsum(N);
		System.out.println(s);

	}

}
