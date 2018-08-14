package pino_generics;

public class MyGenDemo {

	public static void main ( String [] args ){
		MyGen < String > empa = new MyGen < String >("eeeee");
		
		System.out.println ( empa.whatAmIUsing() + ", " + empa.actualObjectUsed());
	}
}
