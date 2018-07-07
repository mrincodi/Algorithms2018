package leetcode;

// https://leetcode.com/problems/symmetric-tree/description/
// Very easy.

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if ( root == null ) return true;
        
        return isSymmetric ( root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if ( left == null && right == null ) return true;
        if ( left == null || right == null ) return false;
        
        if ( left.val != right.val ) return false;
        
        boolean leftB =  isSymmetric ( left.left, right.right );
        if ( leftB == false ) return false;
        
        boolean rightB =  isSymmetric ( left.right, right.left );
        return rightB;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
