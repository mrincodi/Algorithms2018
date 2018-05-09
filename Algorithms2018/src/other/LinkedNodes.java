package other;

//Just the simple exercise of linking all the nodes at the same level in a binary tree.
public class LinkedNodes {

	public void linkNodes ( SpecialTreeNode t ){
		java.util.Queue <SpecialTreeNode> q = new java.util.LinkedList <SpecialTreeNode> ();
		
		q.add(t);
		q.add(null); // To indicate level.
		SpecialTreeNode previous = null;
		
		while ( !q.isEmpty()){
			SpecialTreeNode node = q.remove();
			
			if (node == null){
				if ( q.peek() == null ) return;
				q.add(null);
				//previous = null;
			}
			else{
				if (previous != null)
					previous.nextRight = node;
				
				previous = node;
				
				if ( node.left != null  ) q.add(node.left);
				if ( node.right != null ) q.add(node.right);
			}
			
		}

	}
	public static void main(String[] args) {
		SpecialTreeNode t = new SpecialTreeNode(1);
		t.left  = new SpecialTreeNode(2);
		t.right = new SpecialTreeNode(3);
		
		t.left.left   = new SpecialTreeNode(4);
		t.left.right  = new SpecialTreeNode(5);	
		t.right.left  = new SpecialTreeNode(6);
		t.right.right = new SpecialTreeNode(7);
		
		new LinkedNodes().linkNodes (t);

		SpecialTreeNode p = t;
		while (p != null){
			System.out.println(p.val);
			p=p.nextRight;
		}
	}

}
