package pinos;

import java.util.ArrayList;
import java.util.Collections;

// https://www.interviewbit.com/problems/counting-triangles/
// I don't understand why this code takes too long of a time for InterviewBit.
public class CountingTriangles {

	public int nTriang(ArrayList<Integer> sides) {
		Collections.sort(sides);
		int indexA=0, indexB = 1, indexC=2;
		long resultL = 0L;

		for ( indexA = 0; indexA < sides.size() - 2; indexA++){
			indexB = indexA + 1;
			for ( indexB = indexA + 1; indexB < sides.size() - 1; indexB++){
				int sum = sides.get(indexA) + sides.get(indexB);
				boolean halt = false;
				for ( indexC = indexB + 1; !halt && indexC < sides.size(); indexC++){
					if (sum > sides.get(indexC))
						resultL++;
					else halt = true;
				}
			}
		}
		return (int) (resultL % 1000000007L);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
