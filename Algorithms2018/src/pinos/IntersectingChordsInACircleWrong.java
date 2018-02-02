package pinos;

import java.util.HashMap;

//https://www.interviewbit.com/problems/intersecting-chords-in-a-circle/
//Wrong answer. Think this through again
public class IntersectingChordsInACircleWrong {

	public int chordCnt(int A) {
		HashMap <Integer, Integer> counts = new HashMap <Integer, Integer> ();
		counts.put (1,1);
		return chordCnt (0,2*A-1,counts);
	}

	int chordCnt(int start, int end, HashMap <Integer, Integer> counts) {
		if ( counts.containsKey(end - start) ) return counts.get(end-start);
		int totalSum = 0 ;

		for ( int inc = 1; inc < end - start; inc +=2){
			totalSum += (chordCnt (start, start + inc, counts) + chordCnt (start + inc + 1, end, counts));    
		}

		//counts.put (end - start, chordCnt (start +2, end,counts) + chordCnt (start +1, end -1,counts));
		counts.put (end - start, totalSum);
		return totalSum;
	}


	public static void main(String[] args) {
		int q = new IntersectingChordsInACircleWrong().chordCnt(3);
		System.out.println(q);
	}

}
