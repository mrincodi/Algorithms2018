package pinos;

import java.util.ArrayList;

public class AllFactors {
	public ArrayList<Integer> allFactors(int A) {
		ArrayList<Integer> result = new ArrayList<Integer>  ();
		java.util.TreeSet <Integer> ts = new java.util.TreeSet <Integer>();
		ts.add(1);
		ts.add(A);

		int upperLimit = (int) Math.sqrt(A);

		for ( int i = 2; i <= upperLimit; i++){
			if (A%i == 0){
				ts.add(i);
				ts.add(A/i);
			}
		}

		java.util.Iterator <Integer> iter = ts.iterator();
		while ( iter.hasNext()){
			result.add(iter.next());
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
