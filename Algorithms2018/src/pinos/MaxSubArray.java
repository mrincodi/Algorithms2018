package pinos;

import java.util.List;

//https://www.interviewbit.com/problems/max-sum-contiguous-subarray/

public class MaxSubArray {
    public int maxSubArray(final List<Integer> A) {
        if (A.size()==1) return A.get(0);
        
        int maxSoFar = A.get(0);
        int maxWithMe = A.get(0);
        for ( int i = 1; i < A.size(); i++ ){
            int num = A.get(i);
            maxWithMe = Math.max ( num, maxWithMe + num);
            maxSoFar = Math.max (maxWithMe, maxSoFar);
        }
        
        return maxSoFar;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
