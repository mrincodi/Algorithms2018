package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.interviewbit.com/problems/min-jumps-array/
// The greedy solution! Beautifully works in O(n).
// Implementation of https://www.youtube.com/watch?v=vBdo7wtwlXs

public class MinJumpsArray {

	public int jump(ArrayList<Integer> A) {
		int result = 0;

		if ( A.size() <= 1 ) return 0;
		
		int ladderEnd = 0;
		int nextLadderEnd =  A.get(0);
		if (nextLadderEnd >= A.size() - 1) return 1;
		
		int i = 1;
		while (i < A.size()){
			
			if ( i > ladderEnd ){
				if ( ladderEnd >= nextLadderEnd ) return -1;
				result++;
				ladderEnd = nextLadderEnd;
			}
			
			nextLadderEnd = Math.max( nextLadderEnd, i + A.get(i));
			
			if ( nextLadderEnd >= A.size() - 1) return result + 1;
			
			i++;
		}

		return result;
	}
	
	public static void main(String[] args) {
		ArrayList <Integer> A = new ArrayList <Integer> ( Arrays.asList(0, 46, 46, 0, 2, 47, 1, 24, 45, 0, 0, 24, 18, 29, 27, 11, 0, 0, 40, 12, 4, 0, 0, 0, 49, 42, 13, 5, 12, 45, 10, 0, 29, 11, 22, 15, 17, 41, 34, 23, 11, 35, 0, 18, 47, 0, 38, 37, 3, 37, 0, 43, 50, 0, 25, 12, 0, 38, 28, 37, 5, 4, 12, 23, 31, 9, 26, 19, 11, 21, 0, 0, 40, 18, 44, 0, 0, 0, 0, 30, 26, 37, 0, 26, 39, 10, 1, 0, 0, 3, 50, 46, 1, 38, 38, 7, 6, 38, 27, 7, 25, 30, 0, 0, 36, 37, 6, 39, 40, 32, 41, 12, 3, 44, 44, 39, 2, 26, 40, 36, 35, 21, 14, 41, 48, 50, 21, 0, 0, 23, 49, 21, 11, 27, 40, 47, 49));
		MinJumpsArray mjl = new MinJumpsArray();
		int result = mjl.jump(A);
		System.out.println ( result);
	}

}
