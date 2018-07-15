package pinos;

class ExtTree {
	int val;
	ExtTree left;
	ExtTree right;
	ExtTree prevNode;
	ExtTree nextNode;

	ExtTree ( int val ){
		this.val = val;
		left= null;
		right= null;
		nextNode = null;;
	}

}
public class TreeWalker {

	public void createWalk ( ExtTree t ){

		if ( t == null || ( t.left == null && t.right == null) ) return;
		
		java.util.Queue < ExtTree > q = new java.util.LinkedList <ExtTree > ();
		
		q.add( t );
		ExtTree prevNode = null;
		while ( ! q.isEmpty() ){
			ExtTree node = q.remove ();

			// Add children.
			if ( node.left != null )  q.add (node.left);
			if ( node.right != null ) q.add(node.right);
			
			if ( prevNode != null){
				prevNode.nextNode = node;
			}
			node.prevNode = prevNode;
			
			prevNode = node;
			
		}
	}

	public static void main(String[] args) {
		ExtTree t = new ExtTree (1);
		t.left = new ExtTree (2);
		t.right = new ExtTree (3);
		t.left.left   = new ExtTree (4);
		t.left.right  = new ExtTree (5);
		t.right.left  = new ExtTree (6);
		t.right.right = new ExtTree (7);
		t.left.left.left = new ExtTree (8);
		t.right.right.right = new ExtTree (9);
		t.left.left.left.right = new ExtTree (10);
		ExtTree last = t.left.left.left.right;
		
		new TreeWalker().createWalk(t);
		
		ExtTree pointer = t;
		
		while ( pointer != null){
			System.out.println (pointer.val);
			pointer = pointer.nextNode;
		}
		
		pointer = last;
		while ( pointer != null){
			System.out.println (pointer.val);
			pointer = pointer.prevNode;
		}
	}

}
