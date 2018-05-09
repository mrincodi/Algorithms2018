package leetcode;

// https://leetcode.com/problems/maximum-product-subarray/description/
// Easy.
public class MaximumProductSubarray {

	    public int maxProduct(int[] nums) {
	        if ( nums.length == 1 ) return nums[0];
	        int result = nums[0];
	        int min = nums [ 0];    // Min. including last position.
	        int max = nums [ 0 ];   // Max. including last position.
	        int maxSoFar = max;
	        
	        for ( int i = 1; i < nums.length; i++){
	            int num = nums [ i ];
	            
	            //Calculate minimum.
	            java.util.PriorityQueue <Integer> heapForMin = new java.util.PriorityQueue <Integer> (                                      );
	            java.util.PriorityQueue <Integer> heapForMax = new java.util.PriorityQueue <Integer> ( java.util.Collections.reverseOrder ());
	            
	            heapForMin.add (num      );
	            heapForMin.add (num * min);
	            heapForMin.add (num * max);
	            
	            heapForMax.add (num      );
	            heapForMax.add (num * min);
	            heapForMax.add (num * max);
	            
	            min = heapForMin.remove();
	            max = heapForMax.remove();
	            
	            if ( max > maxSoFar ){
	                maxSoFar = max;
	            }
	        }
	        
	        return maxSoFar;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
