package interview_bit;

//https://www.interviewbit.com/problems/spiral-order-matrix-ii/

import java.util.ArrayList;

public class SpiralOrderMatrixII {

	    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
	        
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
	         
	        // Create the basic structure.
	        for ( int i = 0; i < A; i++){
	            result.add( new ArrayList<Integer>());
	            for ( int j = 0; j < A; j++){
	                result.get(i).add(-1);
	            }
	        }
	        
	        // Fill the structure.
	        int blockSize = A - 1;
	        int offset = 0;
	        int num = 1;
	        while ( blockSize >= 1){
	            // Upper side
	            for ( int i = 0; i < blockSize; i++){
	                result.get (offset).set (offset + i,num++);
	            }
	            
	            //Right side.
	            for ( int i = 0; i < blockSize; i++){
	                result.get (offset + i).set (A - offset - 1,num++);
	            }
	            
	            //Lower side.
	            for ( int i = 0; i < blockSize; i++){
	                result.get (A - offset - 1).set (A - offset - 1 - i,num++);
	            }
	            
	            
	            //Left side.
	            for ( int i = 0; i < blockSize; i++){
	                result.get (A - offset - i - 1).set (offset,num++);
	            }
	            
	            blockSize -=2;
	            offset++;
	        }
	        
	        if ( A % 2 == 1){
	            result.get (A / 2).set (A/2, num);
	        }
	        
	        return result;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
