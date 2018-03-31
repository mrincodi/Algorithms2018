package interview_bit;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/problems/assign-mice-to-holes/

public class AssignMiceToHoles {

	    public int mice(ArrayList<Integer> mice, ArrayList<Integer> holes) {
	        int result = 0;
	        Collections.sort (mice);
	        Collections.sort (holes);
	        for ( int i = 0; i < mice.size(); i++){
	            result = Math.max (result, Math.abs (mice.get(i) - holes.get(i)));
	        }
	        return result;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
