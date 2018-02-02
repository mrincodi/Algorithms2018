package pinos;

import java.util.HashMap;

// https://www.interviewbit.com/problems/intersecting-chords-in-a-circle/
// There are shorter ways of doing this (whew!). Indeed, InterviewBit's solution
// is like 10 lines long... :|
// It does not use a HashMap but an array.

public class IntersectingChordsInACircle {

	public int chordCnt(int A) {
		HashMap <Integer, Long> counts = new HashMap <Integer, Long> ();
		counts.put (1,1L);
		return (int) (chordCnt (0,2*A-1,counts) % 1000000007L);
	}

	long chordCnt(int start, int end, HashMap <Integer, Long> counts) {
		if ( counts.containsKey(end - start) ) return counts.get(end-start);
		long totalSum = 0 ;

		//First one.
		totalSum = (totalSum + chordCnt (start + 2, end, counts)) % 1000000007L;

		//Last one.
		totalSum += (chordCnt (start +1, end - 1, counts)) % 1000000007L;

		if ( end - start == 3) return totalSum % 1000000007L;

		//Middle ones.

		for (int inc = 3; inc <= end - start- 2; inc += 2 ){
			totalSum += (chordCnt (start + 1, start + inc -1, counts) * chordCnt ( start + inc + 1, end , counts)) % 1000000007L; 
		}
		
		
		counts.put (end - start, totalSum% 1000000007L);
		return totalSum % 1000000007L;
	}


	public static void main(String[] args) {
		int q = new IntersectingChordsInACircle().chordCnt(65);
		System.out.println(q);
	}

}
