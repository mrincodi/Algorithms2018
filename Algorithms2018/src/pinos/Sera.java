package pinos;

import java.util.Arrays;
import java.util.Collections;

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

		//		
		//		int x = -5;
		//		//int y = x % 0;
		//		//System.out.println(y);
		//		
		//		//x = Character.getNumericValue('\\u005Cu216C');
		//		System.out.println(x);
		//		
		//		java.util.TreeSet <Integer> t = new java.util.TreeSet < Integer > ( java.util.Collections.reverseOrder ());
		//
		//		t.add(3);
		//		t.add(4);
		//		t.add(7);
		//		t.add(6);
		//		
		//		java.util.Iterator < Integer > iter = t.iterator();
		//		
		//		while (iter.hasNext())System.out.print(iter.next());
		//		

		// Our arr contains 8 elements
//		int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
//
//		Arrays.sort(arr, Collections.reverseOrder());
//
//		System.out.printf("Modified arr[] : %s",
//				Arrays.toString(arr));


//		int [] a = { 7 ,5, 6, 8 };
//		int [] b = a.clone();
//		
//		a [ 0 ] = 10000;
//		
//		for ( int n : b )
//			System.out.println ( n );
//		
		

		
//		Integer [] a = { 7 ,5, 6, 8 };
//		Arrays.sort(a);
//		
//		for ( int n : a )
//			System.out.println ( n );
	
		class Qq implements Comparable < Qq > {
			int x;

			Qq (){}
			Qq (int x){this.x=x;}
			
			@Override
			public int compareTo(Qq o) {
				if (this.x < o.x) return -1;
				if (this.x > o.x) return  1;
				return 0;
			}
			
		}
		
		Qq [] a = new Qq [5];
		
		java.util.Random random = new java.util.Random ();
		
		for ( int i = 0; i < a.length; i++){
			a[i]=new Qq();
			a[i].x=random.nextInt(1000);
		}
		
		Arrays.sort(a);
		
		for ( Qq q : a ){
			int n = q.x;
			System.out.println ( n );
		}
	}
	
    public int maxProfit(int[] prices) {
        
        if ( prices == null || prices.length <= 1) 
            return 0;
        
        int min = prices [ 0 ];
        int result = 0;
        
        for ( int i = 1; i < prices.length; i++ ){
            int price = prices [ i ];
            min = Math.min (min, price);
            result = Math.max ( result, price - min );
        }
        return result;
    }

}
