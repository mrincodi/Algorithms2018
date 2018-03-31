package pinos;

public class SubList {

	public static void main(String[] args) {

		java.util.ArrayList <Integer> al = new java.util.ArrayList <Integer> ( java.util.Arrays.asList (0,1,2,3,4,5));
		java.util.List <Integer> al2 = al.subList(3, 5);
		
		for ( int i = 0; i < al2.size(); i++){
			System.out.print(al2.get(i));
		}

		al.set(3, 100);

		System.out.println();
		for ( int i = 0; i < al2.size(); i++){
			System.out.print(al2.get(i));
		}

		
	}

}
