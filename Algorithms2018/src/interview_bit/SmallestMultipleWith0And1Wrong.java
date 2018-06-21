package interview_bit;

// https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/#
// Although I was on the right track, still I am missing some kind of carry number.

import java.util.LinkedList;
import java.util.Queue;

class SP{
	String carry ;
	String resultSoFar;

	SP (String carry, String resultSoFar){
		this.carry=carry;
		this.resultSoFar = resultSoFar;
	}
}

public class SmallestMultipleWith0And1Wrong {

	public String multiple(int n) {
		if ( n <= 1 ) return String.valueOf(n);

		String result = "";

		Queue < SP > q = new LinkedList <SP> ();

		q.add ( new SP ("0",""));

		int lastDigit = n % 10;

		int startAt=1;

		while (!q.isEmpty ()){
			SP pair = q.remove();
			int carryLastDigit = pair.carry.charAt ( 0 ) - '0';

			for ( int i = startAt; i <= 9; i++){
				int newLastDigit = ( i * lastDigit + carryLastDigit ) % 10;

				if ( newLastDigit == 0 || newLastDigit == 1){
					int newCarry = ( i * n + Integer.parseInt ( pair.carry) )/ 10;
					if ( only0sOr1s ( String.valueOf(newCarry) )){
						result = newCarry + String.valueOf(newLastDigit) + pair.resultSoFar;
						return result;
					}
					else {
						q.add ( new SP (String.valueOf(newCarry), newLastDigit + pair.resultSoFar));
					}

				}
			}
			startAt = 0;
		}
		return null;
	}

	boolean only0sOr1s ( String s ){
		for ( char c: s.toCharArray()){
			if ( c != '0' && c != '1') return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 71;
		
		String s = new SmallestMultipleWith0And1Wrong().multiple(n);
		System.out.println(s);

	}

}
