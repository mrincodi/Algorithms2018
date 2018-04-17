package interview_bit.ninja_exam_1;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.TreeMap;


// https://www.interviewbit.com/problems/get-mode-array-updates/?test_id=4680



//         *** THIS CODE IS INCOMPLETE / WRONG. ***



/**
 * 
 * 
 * 
 * 
 * You are given an array of N positive integers, A1, A2 ,…, AN. 
Also, given a Q updates of form:

i j: Update Ai = j. 1 ≤ i ≤ N.
Perform all updates and after each such update report mode of the array. Therefore, return an array of Q elements, where ith element is mode of the array after ith update has been executed.

Notes

Mode is the most frequently occuring element on the array.
If multiple modes are possible, return the smallest one.
Update array input is via a Q*2 array, where each row represents a update.
For example,

A=[2, 2, 2, 3, 3]

Updates=    [ [1, 3] ]
            [ [5, 4] ]
            [ [2, 4] ]

A = [3, 2, 2, 3, 3] after 1st update.
3 is mode.

A = [3, 2, 2, 3, 4] after 2nd update.
2 and 3 both are mode. Return smaller i.e. 2.

A = [3, 4, 2, 3, 4] after 3rd update.
3 and 4 both are mode. Return smaller i.e. 3.

Return array [3, 2, 3].
Constraints 
1 ≤ N, Q ≤ 105 
1 ≤ j, Ai ≤ 109
 * @author mrincodi
 *
 */



public class GetModeArrayUpdates {

//	
//	    public ArrayList<Integer> getMode(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
//	        
//	        ArrayList<Integer> result = new ArrayList<Integer>  ();
//	        
//	        TreeMap <Integer, Integer> tm = new TreeMap <Integer, Integer> ();
//	        
//	        // Fill the TreeMap, and calculate current mode.
//	        
//	        int mode = A.get(0);
//	        int numTimes = 1;
//	        tm.put (A.get(0), 1);
//	        
//	        for (int i = 1; i < A.size(); i++){
//	            int num = A.get(i);
//	            if ( !tm.containsKey (num) )
//	                tm.put(num, 1);
//	            else
//	                tm.put (num, tm.get(num) + 1);
//	                
//	            if ( num == mode ) numTimes++;
//	            else {
//	                if ( ( num < mode && tm.get(num) == mode ) || ( tm.get(num) > numTimes)) {
//	                    mode = num;
//	                    numTimes = tm.get(num);
//	                }
//	            }
//	        }
//	        //result.add (mode);
//
//	        for ( int i = 0; i < B.size(); i++){
//	            int posToChange = B.get(i).get(0)-1;
//	            int newVal = B.get(i).get(1);
//
//	            int prevVal = A.get(posToChange);
//	        
//	            tm.put (prevVal, tm.get(prevVal) - 1);
//	            if ( tm.get(prevVal) == 0) tm.remove(prevVal);
//	            
//	            if (!tm.containsKey (newVal)) tm.put(newVal, 1);
//	            else tm.put (newVal, tm.get(newVal) + 1);
//	            /**
//	             * 
//	             * tm has been changed now.
//	             * Possibilities:
//	             * 0) prevVal == newVal. Ignore.
//	             *
//	             * 1) prevVal and newVal are both different from mode:
//	             *  * If  tm(newVal) == numTimes {
//	             *      if newVal < mode 
//	             *         I need to look in tm for the value smaller or equal to newVal for which tm(value) == numTimes
//	             *          mode = thatValue 
//	             *      else leave as it was.
//	             *    }
//	             * 
//	             *  * If tm (newVal) > numTimes (has to be numTimes + 1)
//	             *      mode = newVal
//	             *      numTimes = tm (newVal).
//	             * 
//	             * 
//	             * 2) prevVal == mode
//	             *      numTimes--
//	             *      I need to look in tm for the largest frequency.
//	             * 
//	             * 3) newVal = mode
//	             *      numTimes++; 
//	             * prevVal is mode
//	             * newVal is mode.
//	             */
//	            if ( prevVal == newVal ) continue;
//	            
//	            if ( prevVal != mode && newVal != mode){
//	                if ( tm.get(newVal) == numTimes) {
//	                    if ( newVal < mode){
//	                        Iterator <Integer> iter = tm.keySet().iterator();
//	                        int newMode = newVal;
//	                    
//	                        boolean look = true;
//	                        while (iter.hasNext() && look){
//	                            int current = iter.next();
//	                            if ( current > newVal ) look = false;
//	                            if ( tm.get(current) == numTimes ){
//	                                newMode = current;
//	                                look = false;
//	                            }
//	                        }
//	                        mode = newMode;
//	                    }
//	                }
//	                else if ( tm.get(newVal) > numTimes) {
//	                    mode = newVal;
//	                    numTimes = tm.get(newVal);
//	                }
//	            }
//	            else if ( prevVal == mode){
//	                numTimes --;
//	                
//	                Iterator <Integer> iter = tm.keySet().iterator();
//
//	                while (iter.hasNext()){
//	                    int current = iter.next();
//	                    if ( (current < mode && tm.get(current) == numTimes ) || tm.get(current) > numTimes){
//	                        mode = current;
//	                        numTimes = tm.get(current);
//	                    }
//	                }
//	            }
//	            
//	            else {
//	                numTimes++;
//	            }
//	            
//	            result.add(mode);
//	        }
//	        
//	        return result;
//
//	    }

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
