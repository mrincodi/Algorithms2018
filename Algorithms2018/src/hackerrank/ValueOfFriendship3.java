package hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/value-of-friendship/problem
// Second approach. Still times out.
// 2018-07-31

public class ValueOfFriendship3 {

	/*
	 * Complete the valueOfFriendsship function below.
	 */
	  static int valueOfFriendsship(int n, int[][] friendships) {
	        int result = 0;
	        ArrayList < HashSet < Integer >> setsArray = new ArrayList < HashSet < Integer >> ();
	        
	        for ( int [] friendship : friendships ){
	            int a = friendship [ 0 ];
	            int b = friendship [ 1 ];
	            
	            // See to what sets they belong.
	            int aSet = 0;
	            int bSet = 0;
	            while ( aSet < setsArray.size() && !setsArray.get ( aSet ).contains(a)){
	                aSet++;
	            }
	            
	            while ( bSet < setsArray.size() && !setsArray.get ( bSet ).contains(b)){
	                bSet++;
	            }
	            
	            if ( aSet == setsArray.size() && bSet == setsArray.size() ){
	                // Create a new set with these two elements.
	                HashSet < Integer > set = new HashSet < Integer > ();
	                set.add(a);
	                set.add(b);
	                setsArray.add(set);
	            }
	            else if ( aSet == setsArray.size()){
	                //Just add a to bSet.
	                setsArray.get ( bSet ).add(a);
	            }
	            else if ( bSet == setsArray.size()){
	                //Just add b to aSet.
	                setsArray.get ( aSet ).add(b);
	            }
	            else if ( aSet != bSet ){
	                //Join both sets.
	                
	                Iterator < Integer > iter = setsArray.get ( aSet ).iterator();
	                
	                while ( iter.hasNext ()){
	                    int num = iter.next();
	                    setsArray.get ( bSet ).add(num);
	                }
	                
	                setsArray.remove (aSet);
	            }
	            // If they are the same, do nothing.
	            
	            // Now, calculate the value.
	            
	            for ( int i = 0; i < setsArray.size(); i++){
	                int size = setsArray.get(i).size();
	                result = result + ( size * ( size - 1 ));
	            }
	            System.out.println(result);
	        }
	        
	        return result;

	    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = 5;
		int [][] friendships = new int [4][2];
		int [] a = { 1,2};
		int [] b = { 3,2};
		int [] c = { 4,2};
		int [] d = { 4,3};

		friendships[0]=a;
		friendships[1]=b;
		friendships[2]=c;
		friendships[3]=d;
		
		int result = valueOfFriendsship(n, friendships);
		
		System.out.println(result);

	}
}
