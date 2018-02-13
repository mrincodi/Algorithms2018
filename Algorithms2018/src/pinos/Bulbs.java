package pinos;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/bulbs/
// Easy. Look at the ridiculously short solution from InterviewBit.

public class Bulbs {

	public int bulbs(ArrayList<Integer> A) {
		boolean sw = true; //True: 0 is off and 1 is on; false: otherwise.
		int numSwitches = 0;
		for (int b: A){
			if (sw == true){
				if (b == 0){
					numSwitches++;
					sw = false;
				}
			}
			else {
				if ( b == 1 ){
					numSwitches++;
					sw = true; 
				}
			}
		}

		return numSwitches;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
