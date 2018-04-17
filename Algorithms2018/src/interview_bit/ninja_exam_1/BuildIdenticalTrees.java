package interview_bit.ninja_exam_1;

import interview_bit.TreeNode;

//https://www.interviewbit.com/problems/build-identical-trees/?test_id=4680

/**
 * 
 * Description: 
 * 
 * 
Given two binary trees T1 and T2, you have to find minimum number of insertions to be done in T1 to make it structurally identical to T2. Return -1 if not possible.

Notes

Assume insertions are done in a normal fashion in the BSTs.
Assume while inserting, if the value of a node v is equal to value being inserted, we insert it in left subtree of node v.
You can insert any positive or negative integer.
Example :

Input 1: 

T1:       10
         / \
        9   20

T2:       5
         / \
        2   7
       /
      1

If you insert 8 into T1, it will be structurally identical to T2. Hence answer is 1.


Input 2: 

T1:       10
         / \
        9   20

T2:       5
           \
            7

You cannot make T1 and T2 structurally identical. Hence answer is -1.

 * @author mrincodi
 *
 */
public class BuildIdenticalTrees {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) {
	 *      val = x;
	 *      left=null;
	 *      right=null;
	 *     }
	 * }
	 */
	    public int cntMatrix(TreeNode A, TreeNode B) {
	        
	        return cntMatrix (A, B, Integer.MIN_VALUE, Integer.MAX_VALUE);
	        
	    }
	    
	    public int cntMatrix(TreeNode A, TreeNode B, int min, int max) {

	        if ( A == null && B == null ) return 0;
	        
	        if ( A != null && B != null){
	            int leftCnt = cntMatrix (A.left, B.left, min,A.val);
	            if ( leftCnt == -1) return -1;
	            int rightCnt = cntMatrix (A.right, B.right, A.val, max);
	            if ( rightCnt == -1) return -1;
	            
	            return leftCnt + rightCnt;
	            
	        }
	        
	        if ( B == null ) return -1;
	        
	        if ( A == null ) {
	            int newVal = (min + max)/2;
	            int cntLeft = cntMatrix (null,B.left, min, newVal);
	            if ( cntLeft == -1) return -1;
	            int cntRight = cntMatrix (null,B.right, newVal, max);
	            if ( cntRight == -1) return -1;
	           
	            return cntLeft + cntRight + 1;
	 
	        } 
	        return -1;
	    }

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
