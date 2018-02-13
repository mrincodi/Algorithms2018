package pinos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://www.interviewbit.com/problems/clone-graph/
// Easy, yet important, problem.
// Notice that I add the "result" node just after created, before
// I look at the neighbors.
// Also, this *should* work if instead of using labels, I use the
// actual nodes.
// I could have used a global variable for the HashMap, and not created
// another method.
// An interesting (and important) exercise: use BFS instead of the default
// DFS of the recursion; also: use DFS but not recursion.

public class CloneGraph {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap <Integer, UndirectedGraphNode> alreadySeen = new HashMap <Integer, UndirectedGraphNode> ();

		return cloneGraph (node, alreadySeen);
	}


	UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap <Integer, UndirectedGraphNode> alreadySeen) {

		if ( node == null ) return null;

		if ( alreadySeen.containsKey (node.label)) return alreadySeen.get(node.label);

		UndirectedGraphNode result = new UndirectedGraphNode (node.label);

		//if ( node.neighbors != null {
		result.neighbors = new ArrayList<UndirectedGraphNode>();
		alreadySeen.put (node.label, result);

		for ( UndirectedGraphNode ugn: node.neighbors)
			result.neighbors.add (cloneGraph (ugn, alreadySeen));

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
