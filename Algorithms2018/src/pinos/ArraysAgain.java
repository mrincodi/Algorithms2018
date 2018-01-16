package pinos;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysAgain {
	static int suma ( ArrayList < Integer > al ){
		int sum = 0;
		for (int val: al){	// ¿Se puede hacer esto?
			sum += val;
		}
		return sum;
	}
	
	public static void main ( String [] args ){

		java.util.ArrayList < Integer> al = new java.util.ArrayList <Integer> (Arrays.asList(5,4,3,2,1));
		
		int sum = ArraysAgain.suma(al);
		System.out.println( (sum));
	}
}

