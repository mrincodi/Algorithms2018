package pinos;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/sum-of-fibonacci-numbers/
//Seems this mindless approach works...

public class SumOfFibonacciNumbersInterviewBit {
	public int fibsum(int a) {
		if (a == 0)
			return 0;
		if (a < 3)
			return 1;

		ArrayList<Integer> fibs = new ArrayList<Integer>();
		fibs.add(1);
		fibs.add(1);
		while ((int)fibs.get(fibs.size()-1) < a)
			fibs.add(fibs.get(fibs.size()-1) + fibs.get(fibs.size()-2));

		int count = 0;
		while (a != 0) {
			while ((int)fibs.get(fibs.size()-1) > a)
				fibs.remove(fibs.size()-1);
			a -= fibs.get(fibs.size()-1);
			count++;
		}

		return count;
	}
	
	public static void main(String[] args) {
		int N = 55;
		int s = new SumOfFibonacciNumbers().fibsum(N);
		System.out.println(s);

	}

}
