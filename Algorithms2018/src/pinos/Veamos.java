package pinos;

public class Veamos{

	public static int sumaCuadrados ( java.util.ArrayList < Integer > al ){
		int sumaC = 0;
		for ( int val : al ){
			sumaC += Math.pow ( val, 2 );
		}
		return sumaC;
	}

	public static void main ( String [] args ){
		java.util.ArrayList <Integer> al = new java.util.ArrayList <Integer> ( java.util.Arrays.asList ( 4,7,5,2));
		int sumaC = Veamos.sumaCuadrados (al);
		System.out.println ( sumaC);
	}
}

