package basic_data_structures;

public class Graph {
	int V; // Num. vertices.
	java.util.ArrayList <Integer> [] adjacencyList;

	Graph ( int v ) {
		this.V=v;

		adjacencyList = new java.util.ArrayList[v];	// How to remove this warning?

		for ( int i = 0; i < v; i++ )
			adjacencyList[i] = new java.util.ArrayList <Integer> ();

	}

	void addEdge (int x, int y ){	//undirected.
		adjacencyList[x].add(y);
		adjacencyList[y].add(x);
	}

	void printBFS (int origen ){
		java.util.Queue <Integer> q = new java.util.LinkedList <Integer> ();
		boolean[] visited = new boolean [adjacencyList.length];

		q.add (origen);
		visited [ origen ] = true;

		while (!q.isEmpty()){
			int node = q.remove();
			//visited[node] = true;		// Not here! For 1->2 1->3 2->4 3->4 this gives 1 2 3 4 4 (repeats 4).
			System.out.print (node + " ");

			java.util.ArrayList <Integer> neighbors = adjacencyList[node];

			for ( int neighbor : neighbors ){
				if ( !visited[ neighbor ]) {
					visited[neighbor] = true;	// Needs to be put here (see above).
					q.add( neighbor );
				}
			}
		}
	}

	void printDFS (int origen ){
		java.util.Stack<Integer> s = new java.util.Stack <Integer> ();
		boolean [] visited = new boolean [V];
		s.push(origen);
		visited[origen]=true;

		while (!s.isEmpty()){
			int node = s.pop();
			System.out.print(node + " ");

			java.util.ArrayList <Integer> neighbors = adjacencyList[node];

			for ( int neighbor: neighbors ){
				if (!visited[neighbor]){
					visited[neighbor] = true;
					s.push(neighbor);
				}
			}
		}
	}


	public static void main ( String [] args ){
		Graph g = new Graph (6);

		g.addEdge ( 1, 2 );
		g.addEdge ( 1, 3 );
		g.addEdge ( 2, 4 );
		g.addEdge ( 3, 4 );
		g.addEdge ( 4, 5 );

		g.printDFS(1);
	}
}




