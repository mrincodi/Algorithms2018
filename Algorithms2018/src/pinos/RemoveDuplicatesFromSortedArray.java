package pinos;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
// Faster and shorter

public class RemoveDuplicatesFromSortedArray {


	public int removeDuplicates(ArrayList<Integer> a) {
	    
	    for ( int i = 0; i < a.size() - 1; i++){
	        int j = i + 1;
	        
	        while ((j < a.size()) && (a.get(i).equals(a.get(j)))) {
	        	j++;
	        }

	        a.subList (i+1,j).clear();
	        
	    }
	    return a.size();
	}



	public static void main(String[] args) {
		// ArrayList <Integer>  aL = new ArrayList <Integer> ( Arrays.asList( 0, 0, 0, 1, 1, 2, 2, 3));

		ArrayList <Integer>  aL = new ArrayList <Integer> ( Arrays.asList( 5000,5000,5000));
		int result = new RemoveDuplicatesFromSortedArray().removeDuplicates(aL);
		System.out.println( aL);
	}

}
