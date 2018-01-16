package pinos;

import java.util.ArrayList;
import java.util.Arrays;

public class PinoNumbersLessThanAnotherOne {

	public int howManyLessThan (ArrayList <Integer> a, int x){
		if ( a.size()==0) return -1;
		if ( a.size()==1) return 0;
		
		int lowPos = 0;
		int highPos = a.size() - 1;


		while (lowPos <= highPos){
			int midPos = (highPos + lowPos) / 2;
			if ( a.get(midPos)<x) {

				lowPos = midPos + 1;
			}
			else {
				highPos = midPos-1;
			}
		}
		return lowPos;
		
	}
	
	public static void main(String[] args) {
		ArrayList <Integer> aL = new ArrayList <Integer> ( Arrays.asList(1,2,3,4,10,20));
		int x = 30;
		int hm = new PinoNumbersLessThanAnotherOne().howManyLessThan(aL, x);
		System.out.println(hm);
	}

}
