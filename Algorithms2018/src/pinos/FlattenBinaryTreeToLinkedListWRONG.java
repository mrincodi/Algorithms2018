package pinos;

// https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
// This was my try for this problem. This solution is WRONG.

public class FlattenBinaryTreeToLinkedListWRONG {


	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode flatten(TreeNode a) {
		addNodesToTheRight(a,a);
		return a;
	}

	void addNodesToTheRight ( TreeNode root, TreeNode pointer) {
		if ( root == null ) return ;

		if ( root == pointer){
			if ( root.left == null){
				addNodesToTheRight (root.right, root.right);
			}
			else {
				pointer = root.left;
				TreeNode temp = root.right;
				addNodesToTheRight (root, pointer);
				root.left = null;
			}
		} else {

			if ( pointer != null ){
				TreeNode temp = root.right;
				root.right = new TreeNode (pointer.val);
				root = root.right;
				root.right = temp;

				addNodesToTheRight (root, pointer.left);
				addNodesToTheRight (root, pointer.right);
			}

		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
