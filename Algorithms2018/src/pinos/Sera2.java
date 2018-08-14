package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

public class Sera2 {

	public static void main(String[] args) {

		//		int x = 3243985;
		//		
		//		int y = 23982398;
		//		
		//
		//		System.out.println ( x + " " + y);
		//		x = x ^ y;
		//
		//		System.out.println ( x + " " + y);
		//		y = x ^ y;
		//
		//		System.out.println ( x + " " + y);
		//		x = x ^ y;
		//
		//		System.out.println ( x + " " + y);


		char c = 'a';

		int q = 0;

		char qq = (char) q;

		int n = Character.getNumericValue(c);

		int nn = c;
		System.out.println ( n );
		System.out.println ( nn );
		System.out.println ( qq );



		ArrayList <Integer>sera = new ArrayList <  >();

		sera.addAll(Arrays.asList(1,2,3));

		ListIterator < Integer> iter =sera.listIterator(sera.size());

		while (iter.hasPrevious()){
			System.out.println(iter.previous());
		}

		TreeMap <Integer, String> seraqq = new TreeMap <Integer, String> ();
		
		seraqq.put (1, "pero");
		seraqq.put (2, "cómo");
		seraqq.put (3, "hacemos");
		
		ArrayList<Integer> keys = new ArrayList<Integer>(seraqq.keySet());
		
		Collections.reverse(keys);
		
		
		
		
		
		String a = "4";
		int b = 5;
		String cc = a + String.valueOf(b);
		
		System.out.println(cc);


	}

}
