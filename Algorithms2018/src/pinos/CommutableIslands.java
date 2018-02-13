package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

// https://www.interviewbit.com/problems/commutable-islands/
// Prim's algorithm, optimized with a heap (a TreeSet).
// Still takes too long for InterviewBit. (?)

public class CommutableIslands {

	public int solve(int A, ArrayList<ArrayList<Integer>> B) {

		int result = 0;
		if (A <=1 ) return 0;		

		TreeMap <Integer, ArrayList <Integer>> edges = new TreeMap <Integer, ArrayList <Integer>>();
		HashSet <Integer> visited = new HashSet <Integer> ();

		//Fill out the TreeSet.
		for ( ArrayList <Integer> edge: B){
			int origin 		= edge.get(0);
			int destination = edge.get(1);
			int cost 		= edge.get(2);

			if ( !edges.containsKey(cost))
				edges.put(cost, new ArrayList <Integer> (Arrays.asList(origin, destination)));
			else {
				edges.get(cost).add(origin);
				edges.get(cost).add(destination);
			}
		}

		visited.add(1);

		outer:
			for ( int i = 1; i < A; i++){
				// Go over all the edges looking for edges
				// that start from one visited node and end in an
				// unvisited node.
				// Take the one with the smallest cost.

				int nextVisited = -1;

				Iterator <Integer> iter = edges.keySet().iterator();

				while (iter.hasNext()){
					int cost = iter.next();
					ArrayList <Integer> vertices = edges.get(cost);

					for ( int j = 0; j < vertices.size(); j=j+2){
						int origin 		= vertices.get(j);
						int destination = vertices.get(j+1);

						if ( visited.contains(origin) && !visited.contains(destination)){
							visited.add(destination);
							result += cost;
							vertices.remove(j+1);
							vertices.remove(j);

							if ( vertices.size() == 0 )
								edges.remove(cost);

							continue outer;

						}

						else if ( !visited.contains(origin) && visited.contains(destination)){
							visited.add(origin);
							result += cost;
							vertices.remove(j+1);
							vertices.remove(j);

							if ( vertices.size() == 0 )
								edges.remove(cost);

							continue outer;
						}

						else if ( visited.contains(origin) && visited.contains(destination)){
							vertices.remove(j+1);
							vertices.remove(j);
							j=j-2;
						}
					}
				}

			}

		return result;
	}



	public static void main(String[] args) {

		int A = 4;
		ArrayList <ArrayList <Integer>> B = new  ArrayList <ArrayList <Integer>>();

		B.add(new ArrayList <Integer> (Arrays.asList(1,2,1)));
		B.add(new ArrayList <Integer> (Arrays.asList(2,3,2)));
		B.add(new ArrayList <Integer> (Arrays.asList(3,4,4)));
		B.add(new ArrayList <Integer> (Arrays.asList(1,4,3)));

		int cost = new CommutableIslands().solve(A, B);
		System.out.println(cost);

	}

}
