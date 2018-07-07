package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TripletsWithSumBetweenGivenRange {
	
	// https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
	// NOT WORKING. TODO: SOLVE THIS.
	// A very annoying problem, to say the least. Not easy either.
	// There seem to be less "case based" ways of solving it.
	
	public int solve(ArrayList<String> ss) {


		if ( ss.size () < 3 ) return 0;

		ArrayList < Double > a = new  ArrayList < Double >  ();

		ArrayList < Double > A = new  ArrayList < Double >  ();
		ArrayList < Double > b = new  ArrayList < Double >  ();
		ArrayList < Double > c = new  ArrayList < Double >  ();

		for ( String s: ss ){
			double d = Double.parseDouble ( s );

			if ( d < (2d/3d) ) {
				a.add (d);
				Collections.sort (a);
				if (a.size() > 2 ) a.remove (2);

				A.add (d);
				Collections.sort (A);
				if ( A.size() > 3 ) A.remove (0);
			}
			else if ( d <= 1 ){
				b.add(d);
				Collections.sort ( b );
				if ( b.size () > 2 ) b.remove ( 2 );
			}
			else if ( d < 2 ){
				c.add ( d );
				if (c.size() > 1){
					if ( c.get (0) > c.get(1)) c.remove (0);
					else c.remove (1);
				}
			}
		}

		// Now, case by case.
		// AAA
		if ( A.size() == 3 ){
			double sum = A.get(0) + A.get(1) + A.get(2);
			if ( sum > 1 && sum < 2 ) return 1;
		}

		//AAB
		// Hmm... I don't like going over the array again.
		if ( A.size() >= 2 && b.size() >=1 ){
			double sum = A.get ( 0 ) + A.get ( 1 );

			for ( String s: ss){
				double d = Double.parseDouble ( s );
				
				if ( d >= (2d/3d) && d<=1 && d + sum > 1 && d + sum < 2 ) return 1; 
			}
		}

		//AAC
		if ( a.size() >=2 && c.size() == 1){
			double sum = a.get ( 0 ) + a. get ( 1 ) + c.get ( 0 );
			if ( sum < 2 ) return 1;
		}

		//ABB. Again, as case 2...
		if ( a.size() >=1 && b.size() == 2 ){
			double sum = b.get ( 0 ) + b.get ( 1 );

			for ( String s: ss){
				double d = Double.parseDouble ( s );
				if ( d < (2d/3d) && d + sum > 1 && d + sum < 2 ) return 1; 
			}
		}

		//ABC
		if ( a.size () >= 1 && b.size() >= 1 & c.size () == 1 ){
			if ( a.get ( 0 ) + b.get( 0 ) + c.get ( 0 ) < 2 ) return 1;
		}

		return 0;
	}

	public static void main(String[] args) {
		String [] ss1 = { "0.234022", "0.051717", "0.820402", "0.492629", "0.004825", "0.589073" };
		ArrayList < String > ss = new ArrayList < String > ( Arrays.asList(ss1));
		System.out.println ( new TripletsWithSumBetweenGivenRange().solve(ss));
		
		

	}

}
