package pinos;

//https://www.interviewbit.com/problems/flip-array/
// Trying to solve it. Ignore.

public class FlipArrayNotes {
//
//	public class Solution {
//	    // DO NOT MODIFY THE LIST. IT IS READ ONLY
//	    int minChanges = 0;
//	    public int solve(final List<Integer> A) {
//	        
//	        solve (A, 0)
//	        
//	        return minChanges;
//	    }
//	    
//	    public int solve(List<Integer> A, int index, int surplus) {
//	        int result = 0;
//	        if (index == A.size() - 1){
//	            int val1 = A.get(0) + surplus;
//	            int val2 = A.get(0) - surplus;
//	            
//	            if ( val1 >=0 && val2 >= 0){
//	                if ( val1 <= val2 ) return val1;
//	                else{
//	                    minChanges++;
//	                    return val2;
//	                }
//	            }
//	            else if (val1 >=0 && val2 < 0){
//	                return val1;
//	            }
//	            else if (val1 < 0 && val2 >=0){
//	                minChanges++;
//	                return val2;
//	            }
//	            // else // Should not happen.
//	        }
//	        else {
//	            int pos1 = solve (A, index+1, surplus + A.get(0));
//	            int pos2 = solve (A, index + 1, surplus - A.get(0));
//	            
//	            if ( pos1 < pos2){
//	                return pos1;
//	            } else{
//	                minChanges++;
//	                return pos2;
//	            }  
//	            
//	            int result1 = A.get(0) + pos1;
//	            int result1 = A.get(0) + pos2;
//	            
//	            if ( A.get(0) + pos1 < A.get(0)+ pos2
//	        }
//	            
//	            
//	            
//	            
//	            
//	            
//	            
//	            if ( A.get(0) >= goal){
//	                
//	                
//	                
//	            }
//	                return A.get(0)- goal;
//	            else {
//	                minChanges++;
//	                return -A.get(0) - goal;
//	            }
//	        }
//	        
//	        //Four possibilities.
//	        //First, no changes.
//	        int pos1 = solve (A, index + 1, - bgoal)
//	        return 0;
//	    }
//	    
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
