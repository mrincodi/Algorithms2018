package leetcode;

// https://leetcode.com/problems/binary-tree-tilt/description/
// Easy, but not optimal.
// 2018-07-19
public class BinaryTreeTiltTilt {


	public int findTilt(TreeNode root) {

		if ( root == null ) return 0;

		int weightLeft = getWeight ( root.left );   // TODO
		int weightRight = getWeight ( root.right );

		int tilt = Math.abs ( weightLeft - weightRight);

		tilt = tilt + findTilt ( root.left ) + findTilt ( root.right );

		return tilt;
	}

	int getWeight ( TreeNode t ){
		if ( t == null ) return 0;
		return t.val + getWeight (t.left ) + getWeight ( t.right) ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
