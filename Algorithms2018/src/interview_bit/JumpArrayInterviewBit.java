package interview_bit;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/jump-game-array/
// Or JumpArrayAwesome. The best approach! Will stop as soon as jumps are impossible.

public class JumpArrayInterviewBit {

	public int canJump(ArrayList<Integer> a) {
		int currJump= 0;
		for (int i=0; i<a.size(); i++){
			if (currJump<0) return 0;
			currJump= Math.max(a.get(i),currJump);
			currJump--;
		}
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
