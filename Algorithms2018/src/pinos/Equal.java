package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//https://www.interviewbit.com/problems/equal/
// What makes this problem hard is the lexicographic order needed for the solution.
// What interviewBit does (clever) is to compare each solution found with the best one so far, with 
// the lexicographic rule. I did a list and ordered it. So their solution saves space.

public class Equal {

	public ArrayList<Integer> equal(ArrayList<Integer> A) {
		HashMap <Integer, ArrayList <Integer>> sums = new HashMap <Integer, ArrayList <Integer>> ();    
		ArrayList<ArrayList<Integer>> resultsArray = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer> aResult = new ArrayList<Integer>();

		int addition = 0;
		for ( int i = 0; i < A.size() - 1; i++){
			for ( int j = i + 1; j < A.size(); j++){
				int C1=i;
				int D1=j;
				addition = A.get(i)+A.get(j);
				if ( sums.containsKey (addition) && sums.get(addition).size() == 2 ){
					int A1 = sums.get(addition).get(0);
					int B1 = sums.get(addition).get(1);

					if ( A1 < C1 && B1 != D1 && B1 != C1 ){
						aResult = new ArrayList<Integer>(Arrays.asList(A1, B1, C1, D1));
						resultsArray.add(aResult);
						sums.put(addition,aResult);
					}
				}
				else{
					sums.put(addition,new ArrayList<Integer>(Arrays.asList(i,j)));
				}
			}
		}
		if (resultsArray.size() == 0) return new ArrayList <Integer>();
		resultsArray.sort (new lexComparator());
		return resultsArray.get(0);
	}
	

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer> (Arrays.asList(1,1,1,1,1));
		ArrayList<Integer> result = new Equal().equal(A);
		System.out.println(result);

	}
}


class lexComparator extends ArrayList<Integer> implements Comparator <ArrayList<Integer>> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int compare (ArrayList<Integer> a, ArrayList<Integer>b){

		// I had to do this because I was going nuts.
		
		int A1 = a.get(0);
		int B1 = a.get(1);
		int C1 = a.get(2);
		int D1 = a.get(3);
		int A2 = b.get(0);
		int B2 = b.get(1);
		int C2 = b.get(2);
		int D2 = b.get(3);

		if (A1 < A2 ||
				(A1 == A2 && B1 < B2 ) ||
				(A1 == A2 && B1 == B2 && C1 < C2 ) || 
				(A1 == A2 && B1 == B2 && C1 == C2 && D1 < D2))
			return -1;

		return 1;
	}
}







