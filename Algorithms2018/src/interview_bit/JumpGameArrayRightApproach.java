package interview_bit;

import java.util.ArrayList;


// https://www.interviewbit.com/problems/jump-game-array/
// A much better approach, non-recursive and O(n).

public class JumpGameArrayRightApproach {

	public int canJump(ArrayList<Integer> positions) {
		if ( positions == null ) return 0;
		if ( positions.size() <= 1 ) return positions.size();

		int minSolution = positions.size () - 1;

		for ( int i = positions.size() - 2; i >= 0; i-- ){
			if ( positions.get(i) + i >= minSolution )
				minSolution = i;
		}
		return minSolution == 0?1:0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
