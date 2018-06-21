package pinos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class Sera {

	public static void main(String[] args) {
//		String s = "12345678";
//		s = s.substring(8-2);
//		System.out.println(s);
//		
//		Character q = 'F';
//
//		char c = 'X' + 26;
//		System.out.println (c);
		
		
		//PriorityQueue <Integer> q = new PriorityQueue <Integer> ( Collections.reverseOrder () );
//
//		Queue <Integer> q = new LinkedList <Integer> ();
//		q.add (5);
//		q.add (3);
//		q.add(9);
//		int t = q.remove();
//		System.out.println (t);
//		
//		try {
//			FileReader fr = new FileReader ( "f" );
//			BufferedReader br = new BufferedReader (fr);
//			String s;
//			while ( ( s = br.readLine() ) != null ){
//				System.out.println (s);
//			}
//			br.close();
//		}
//		catch (Exception e ){};

		
		int x = -5;
		//int y = x % 0;
		//System.out.println(y);
		
		//x = Character.getNumericValue('\\u005Cu216C');
		System.out.println(x);
		
		java.util.TreeSet <Integer> t = new java.util.TreeSet < Integer > ( java.util.Collections.reverseOrder ());

		t.add(3);
		t.add(4);
		t.add(7);
		t.add(6);
		
		java.util.Iterator < Integer > iter = t.iterator();
		
		while (iter.hasNext())System.out.print(iter.next());
		
		
	}

}
