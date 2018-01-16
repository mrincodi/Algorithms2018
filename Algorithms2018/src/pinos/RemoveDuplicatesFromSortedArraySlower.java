package pinos;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
// Takes too long for InterviewBit.

public class RemoveDuplicatesFromSortedArraySlower {


	public int removeDuplicates(ArrayList<Integer> a) {

		for ( int i = 0; i < a.size() - 1; i++){
			int j = i + 1;
			int valI = a.get(i);
			int valJ = a.get(j);
			boolean halt = false;
			while (!halt && valJ == valI){
				a.remove(j);
				if ( j == a.size() ) halt = true;
				else valJ = a.get(j);
			}
		}
		return a.size();
	}



	public static void main(String[] args) {
		ArrayList <Integer>  aL = new ArrayList <Integer> ( Arrays.asList( 0, 0, 0, 1, 1, 2, 2, 3));
		int result = new RemoveDuplicatesFromSortedArraySlower().removeDuplicates(aL);
		System.out.println( aL);
	}

}
