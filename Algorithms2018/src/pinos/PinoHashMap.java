package pinos;

public class PinoHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		java.util.HashMap <Integer, Integer> h = new java.util.HashMap <Integer, Integer> ();

		h.put (5, 7);
		h.put (9, 0);

		java.util.Iterator <Integer> iter = h.keySet().iterator();

		while (iter.hasNext ()){
			int key = iter.next();
			int value = h.get(key);
			System.out.println ( key + "->" + value );
		}

	}

}
