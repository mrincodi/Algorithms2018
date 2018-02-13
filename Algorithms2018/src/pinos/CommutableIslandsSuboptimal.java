package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

// https://www.interviewbit.com/problems/commutable-islands/
// Prim's algorithm, but not optimized with a heap (a TreeSet).

public class CommutableIslandsSuboptimal {

	public int solve(int A, ArrayList<ArrayList<Integer>> B) {

		int result = 0;
		if (A <=1 ) return 0;		

		HashSet <Integer> visited = new HashSet <Integer> ();

		visited.add(1);
		for ( int i = 1; i < A; i++){
			// Go over all the edges looking for edges
			// that start from one visited node and end in an
			// unvisited node.
			// Take the one with the smallest cost.

			int minCost = Integer.MAX_VALUE;
			int nextVisited = -1;

			for ( int j = 0; j < B.size(); j++){
				ArrayList<Integer> edge = B.get(j);
				int origin 		= edge.get(0);
				int destination = edge.get(1);
				int cost 		= edge.get(2);

				if ( visited.contains(origin) && !visited.contains(destination)){
					if (cost < minCost){
						minCost = cost;
						nextVisited = destination;
					}
				}

				else if ( !visited.contains(origin) && visited.contains(destination)){
					if (cost < minCost){
						minCost = cost;
						nextVisited = origin;
					}
				}
				else if ( visited.contains(origin) && visited.contains(destination)){
					B.remove(j);
					j=j-1;
				}
			}

			visited.add(nextVisited);
			result += minCost;
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

		int cost = new CommutableIslandsSuboptimal().solve(A, B);
		System.out.println(cost);

	}

}
