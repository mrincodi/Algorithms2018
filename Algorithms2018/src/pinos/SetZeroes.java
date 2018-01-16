package pinos;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.interviewbit.com/problems/set-matrix-zeros/

public class SetZeroes {

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {

		java.util.HashSet <Integer> zeroRows = new java.util.HashSet <Integer> ();
		java.util.HashSet <Integer> zeroCols = new java.util.HashSet <Integer> ();

		if (a.size()==0) return;

		for ( int row = 0; row < a.size(); row++){
			for ( int col = 0; col < a.get(0).size(); col++ ){
				if ( a.get(row).get(col)==0){
					zeroRows.add ( row );
					zeroCols.add ( col );
				}
			}
		}

		zero (a, zeroRows, zeroCols);
	}

	public void zero (ArrayList<ArrayList<Integer>> a, java.util.HashSet<Integer> zeroRows, java.util.HashSet<Integer> zeroCols ){

		java.util.Iterator <Integer> rowIter = zeroRows.iterator();
		java.util.Iterator <Integer> colIter = zeroCols.iterator();

		//Zero the rows
		while ( rowIter.hasNext() ){
			Integer row = rowIter.next();
			for ( int iCol = 0; iCol < a.get(row).size(); iCol++)
				a.get(row).set(iCol,0);
		}

		//Zero the cols
		while ( colIter.hasNext() ){
			Integer col = colIter.next();
			for ( int iRow = 0; iRow < a.size(); iRow++)
				a.get(iRow).set(col,0);
		}

	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

		a.add(new ArrayList <Integer> (Arrays.asList(1,0)));
		a.add(new ArrayList <Integer> (Arrays.asList(0,0)));

		new SetZeroes().setZeroes(a);

		System.out.println (a);

	}

}
