package pinos;


public class Compa implements java.lang.Comparable <Integer>{ //Comparable comes from java.lang.
	Integer num;

	public static void main(String[] args) {
		Integer [] array = { 5,6,7,8,9};
		java.util.ArrayList <Integer> al = new java.util.ArrayList <Integer> (java.util.Arrays.asList (array));	


		java.util.ArrayList <Integer> aal = new java.util.ArrayList <Integer> ( java.util.Arrays.asList ( 5,6,7,8,9 ));
		Integer [] aarray = al.toArray (new Integer [ aal.size() ]);

		java.util.Arrays.sort ( aarray );

	}

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
class Comparador implements java.util.Comparator <Compa> { // Comparator comes from java.util!

	@Override
	public int compare (Compa c1, Compa c2){
		return c1.num.compareTo(c2.num);
	}
}




