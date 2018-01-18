package pinos;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/kth-permutation-sequence/
// For some reason this fails in InterviewBit with division by zero.
// Well I found the reason: I needed to add an entry in case that factorial overflowed.
// (line 34).
public class KthPermutationSequence {

	public String getPermutation(int n, int k) {
		ArrayList <Integer> numbers = new ArrayList <Integer> ();

		for ( int i = 1; i <= n; i++){
			numbers.add(i);
		}

		return getPermutation1(numbers,k);
	}

	String getPermutation1 (ArrayList <Integer> numbers, int k){
		if ( numbers.size() == 1 ) return String.valueOf(numbers.get(0));

		int firstIndex = ((k - 1) / factorial (numbers.size() - 1));
		String firstString =  String.valueOf(numbers.get(firstIndex));
		
		ArrayList <Integer> newNumbers = new ArrayList <Integer> (numbers);
		newNumbers.remove(firstIndex);
		return firstString + getPermutation1 ( newNumbers, k - firstIndex * factorial (numbers.size() - 1));    

	}

	int factorial (int i){
		if ( i == 0 ) return 1;
		if ( i >= 12) return Integer.MAX_VALUE;
		return i * factorial (i - 1);
	}




	public static void main(String[] args) {
		String qq = new KthPermutationSequence().getPermutation(3, 6);
		System.out.println(qq);
	}

}
