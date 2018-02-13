package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

// https://www.interviewbit.com/problems/commutable-islands/
// Before I noticed there's an algorithm for the MST, this was my (wrong) try.
// I was in the right track though (not that that matters anyways...).

public class CommutableIslandsWrong {

	    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

	        // This TreeMap associates cost to bridges.        
	        TreeMap <Integer, ArrayList<Integer>> bridges = new  TreeMap <Integer, ArrayList<Integer>> ();
	        HashSet <Integer> islands = new HashSet <Integer> (); // Islands already connected.
	        
	        int result = 0;
	        
	        for ( int i = 0; i < B.size(); i++ ){
	            //Fill in the bridges.
	            int origin      = B.get(i).get(0);
	            int destination = B.get(i).get(1);
	            int cost        = B.get(i).get(2);
	            
	            if ( !bridges.containsKey (cost) ){
	                bridges.put (cost, new ArrayList <Integer> (Arrays.asList(origin,destination)));
	            }
	            else {
	                bridges.get(cost).add(origin);
	                bridges.get(cost).add(destination);
	            }
	        }
	        
	        Iterator <Integer> iter = bridges.keySet().iterator();
	        
	        while (iter.hasNext()){
	            int cost = iter.next();
	            ArrayList <Integer> islandsArray = bridges.get(cost);
	            int i = 0;
	            while ( i < islandsArray.size()){
	                int origin = islandsArray.get(i++);
	                int destination = islandsArray.get(i++);
	                
	                if ( !islands.contains ( origin ) || !islands.contains ( destination ) ){
	                    islands.add(origin);
	                    islands.add(destination);
	                    
	                    result += cost;
	                }
	            }
	        }
	        
	        return result;
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
