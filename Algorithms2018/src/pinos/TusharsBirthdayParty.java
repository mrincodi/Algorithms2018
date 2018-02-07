package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// https://www.interviewbit.com/problems/tushars-birthday-party/
// Unbounded knapsack problem

public class TusharsBirthdayParty {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int solve(final List<Integer> friendsCapacity, final List<Integer> dishCapacity, final List<Integer> dishCost) {
		// Do Knapsack per friend.
		
		if ( friendsCapacity.size() == 0) return 0;
		
		int result = 0;

		for (int friendCapacity : friendsCapacity){
			result += knapsack (friendCapacity, dishCapacity, dishCost);
		}
		return result;
		

	}
	private int knapsack(int friendCapacity, List<Integer> dishCapacity, List<Integer> dishCost) {
		int [][] m = new int [dishCapacity.size() + 1][friendCapacity + 1];
		
		for (int i = 1; i <= friendCapacity; i++)
			m[0][i]=Integer.MAX_VALUE;	//Infinite cost if there are no dishes and capacity >=1.

		for (int i = 1; i <= dishCapacity.size(); i++){
			int thisDishCapacity = dishCapacity.get(i-1);
			int thisDishCost = dishCost.get(i-1);
			
			for (int capacity = 1; capacity <= friendCapacity; capacity++){
				m[i][capacity] = m[i-1][capacity];
				if ( capacity >= thisDishCapacity){  //We cannot take this plate if the friend doesn't even have capacity for 1 of it.
					m[i][capacity] = m[i-1][capacity];
					
					if ( m[i][capacity - thisDishCapacity] != Integer.MAX_VALUE)
					m[i][capacity] = Math.min( m[i-1][capacity], m[i][capacity - thisDishCapacity] + thisDishCost);
				}
			}
		}
		
		return m[dishCapacity.size()][friendCapacity ];
	}
	
	
	public static void main(String[] args) {
		ArrayList <Integer> friendsCapacity = new ArrayList <Integer> (Arrays.asList(4,6));
		ArrayList <Integer> dishCapacity = new ArrayList <Integer> (Arrays.asList(1,3));
		ArrayList <Integer> dishCost = new ArrayList <Integer> (Arrays.asList(5,3));
		
		int r = new TusharsBirthdayParty().solve(friendsCapacity, dishCapacity, dishCost);
		
		System.out.println(r);

	}

}
