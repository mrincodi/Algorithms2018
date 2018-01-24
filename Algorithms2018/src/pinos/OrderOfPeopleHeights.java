package pinos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

//https://www.interviewbit.com/problems/order-of-people-heights/
// A cool problem. Not really related to trees... unless you think of using
// segment trees to find the xth free position.

public class OrderOfPeopleHeights {

	public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		TreeMap <Integer, Integer> heights = new TreeMap <Integer, Integer> ();

		for ( int i = 0; i < A.size(); i++){
			result.add(-1);
			heights.put(A.get(i), B.get(i));    //To each height, how many people taller in front.
		}

		Iterator <Integer> iter = heights.keySet().iterator();

		outer:
			while (iter.hasNext()){
				int height  = iter.next();
				int inFront = heights.get(height);

				int howManyTallerSoFar = -1;

				for ( int i = 0; i < result.size(); i++){
					if ( result.get(i) == -1){
						howManyTallerSoFar++;
						if ( howManyTallerSoFar == inFront){
							result.set(i,height);
							continue outer;
						}

					}
				}
			}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
