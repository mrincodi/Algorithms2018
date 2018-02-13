package pinos;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/seats/
// This code fails in InterviewBit for some unspecified overflow issue.

public class Seats {

	public int seats(String A) {
		
		
		ArrayList <Integer> positions = new ArrayList <Integer> ();
		
		
		for ( int i = 0; i < A.length(); i++)
			if (A.charAt(i)=='x') positions.add(i);

		if ( positions.size() <= 1) return 0;

		if ( positions.size()%2 == 0){
			//Add a new position for the median and stop thinking.
			
			int newPos = positions.size()/2;

			int val1 = positions.get(positions.size()/2 - 1);
			int val2 = positions.get(positions.size()/2 );
			int newVal = (val1+val2)/2;
			
			positions.add(newPos, newVal);
			
			for ( int i = newPos + 1; i < positions.size(); i++){
				positions.set(i, positions.get(i)+1);
			}
			
		}
		
		int medianPos = positions.size()/2;
		long numSteps = 0;
		

		if ( positions.size()%2 == 1){
			for ( int i = 0; i < medianPos; i++){
				numSteps += (positions.get(medianPos) - positions.get(i)) - i - 1;
			}
			for ( int i = medianPos + 1; i < positions.size(); i++){
				numSteps += ( positions.get(i) - positions.get(medianPos)) - (i - medianPos) ;
			}
		
		}
		else {
			
		}
		
		return (int) numSteps % 10000003;
		
	}



	public static void main(String[] args) {
		int s = new Seats().seats("...x..x...x.x");
		System.out.println(s);

	}

}
