package pinos;

//https://www.interviewbit.com/problems/stairs/
//Fibonacci. Easy.

public class Stairs {

	public int climbStairs(int A) {
		if ( A <= 1 ) return A;

		int minus1 = 1;
		int minus2 = 1;
		int current = 0;

		for ( int i = 2; i <= A; i++){
			current = minus1 + minus2;
			minus2 = minus1;
			minus1 = current;
		}
		return current;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
