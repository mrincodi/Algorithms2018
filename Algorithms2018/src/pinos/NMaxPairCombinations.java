package pinos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//https://www.interviewbit.com/problems/n-max-pair-combinations/
// This is not an elegant solution IMO...
// although it is one of the solutions in InterviewBit (the fastest (?)).
public class NMaxPairCombinations {


	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<Integer> ();

		if ( A.size() == 0) return result;

		Collections.sort (A, Collections.reverseOrder());
		Collections.sort (B, Collections.reverseOrder());

		PriorityQueue <Integer> heap = new PriorityQueue <Integer>();

		outer:
			for ( int i = 0; i < A.size(); i++){

				for ( int j = 0; j < A.size(); j++){
					int sum = A.get(i) + B.get(j);
					if (heap.size() < A.size()){
						heap.add(sum);
					}
					else {
						if ( sum < heap.peek()) continue outer;
						else { heap.remove();
						heap.add(sum);
						}
					}
				}


			}
		result = new ArrayList <Integer> (heap);
		Collections.sort (result, Collections.reverseOrder());
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
