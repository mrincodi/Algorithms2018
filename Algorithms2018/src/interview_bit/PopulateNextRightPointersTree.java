package interview_bit;

public class PopulateNextRightPointersTree {
	/**
	 * Definition for binary tree with next pointer.
	 * public class TreeLinkNode {
	 *     int val;
	 *     TreeLinkNode left, right, next;
	 *     TreeLinkNode(int x) { val = x; }
	 * }
	 */
	public void connect(TreeLinkNode root) {
		java.util.Queue < TreeLinkNode > queue = new java.util.LinkedList < TreeLinkNode > ();

		queue.add (root);

		while ( ! queue.isEmpty () ){
			int currentSize = queue.size();

			for ( int i = 0; i < currentSize - 1; i++ ){
				TreeLinkNode parent = queue.remove();

				parent.next = queue.peek();

				if ( parent.left != null  ) queue.add ( parent.left  );
				if ( parent.right != null ) queue.add ( parent.right );
			}

			TreeLinkNode lastParent = queue.remove();

			if ( lastParent.left != null  ) queue.add ( lastParent.left  );
			if ( lastParent.right != null ) queue.add ( lastParent.right );
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
