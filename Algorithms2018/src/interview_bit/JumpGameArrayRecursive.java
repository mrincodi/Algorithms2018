package interview_bit;

import java.util.ArrayList;
import java.util.HashSet;

// https://www.interviewbit.com/problems/jump-game-array/
// It works, but will overflow for huge arrays that fail.

public class JumpGameArrayRecursive {

	public int canJump(ArrayList<Integer> positions) {
		if ( positions == null ) return 0;
		if ( positions.size() <= 1 ) return positions.size();

		HashSet < Integer > failed = new HashSet < Integer > ();
		return canJump ( positions, 0, failed );
	}

	private int canJump ( ArrayList < Integer > positions, int pos, HashSet < Integer > failed){
		if ( pos >= positions.size() - 1 ) return 1;
		if ( failed.contains ( pos ) ) return 0;
		int possibleJumps = positions.get ( pos );

		for ( int i = possibleJumps; i >= 1; i-- ){
			if ( canJump ( positions, pos + i, failed ) == 1 )
				return 1;
		}

		failed.add ( pos );
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
