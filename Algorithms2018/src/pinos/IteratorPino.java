package pinos;

import java.util.HashMap;
import java.util.Iterator;

public class IteratorPino {
	public static void main ( String[] args){
		HashMap <Integer, Integer> h = new HashMap <Integer, Integer>();
		h.put(1, 2);
		h.put(4, 45);
		
		Iterator <Integer> iter = h.keySet().iterator();
		
		while (iter.hasNext()){
			int key = iter.next();
			System.out.println(key + " " + h.get(key));
		}
		
	}
}
