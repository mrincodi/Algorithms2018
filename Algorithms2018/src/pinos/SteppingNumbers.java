package pinos;

import java.util.ArrayList;
import java.util.Collections;

public class SteppingNumbers {

	//int numCalls=0;
	public ArrayList<Integer> stepnum(int A, int B) {

		ArrayList<Integer> result = new ArrayList<Integer> ();

		for ( int i = 1; i <= 9; i++){
			stepnum(result,A,B,i);
		}

		Collections.sort(result);
		//System.out.println(numCalls);
		return result;
	}

	void stepnum(ArrayList<Integer> result, int A, int B, int current) {

		//numCalls++;
		if (current < B){
			if ( current >= A){
				result.add(current);
			}


			int lastDigit = current % 10;

			if (lastDigit != 0)
				stepnum (result,A,B,current *10 + lastDigit - 1);

			if (lastDigit != 9)
				stepnum (result,A,B,current *10 + lastDigit + 1);
		}

	}

	public static void main(String[] args) {

		ArrayList<Integer> result = new SteppingNumbers().stepnum (9,1000000);
		System.out.println(result);
	}

}
