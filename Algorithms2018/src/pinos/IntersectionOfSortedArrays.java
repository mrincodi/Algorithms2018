package pinos;

import java.util.ArrayList;
import java.util.List;

//https://www.interviewbit.com/problems/intersection-of-sorted-arrays/

public class IntersectionOfSortedArrays {

	    // DO NOT MODIFY THE LIST. IT IS READ ONLY
	    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
	        int indexA = 0, indexB = 0;
	        ArrayList<Integer> result = new ArrayList<Integer> (); 
	        
	        while (indexA < A.size() && indexB < B.size() ){
	            int valA = A.get(indexA);
	            int valB = B.get(indexB);

	            if (valA < valB) indexA++;
	            else if (valA == valB) {
	                result.add (valA);
	                indexA++;
	                indexB++;
	            }
	            else indexB++;

	        }
	        return result;
	    }


	
}
