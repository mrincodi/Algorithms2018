package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PrimeSum {
	public ArrayList<Integer> primesum(int A) {

		java.util.TreeSet <Integer> primeNumbers = getPrimeNumbers (A);

		Iterator <Integer> iter = primeNumbers.iterator();
		while (iter.hasNext()){
			int i = iter.next();
			if (primeNumbers.contains (A-i)){
				return new ArrayList<Integer> ( Arrays.asList (i,A-i));
			}
		}
		return null;
	}


    java.util.TreeSet <Integer> getPrimeNumbers (int A){
        java.util.TreeSet <Integer> primes = new java.util.TreeSet <Integer> ();
        primes.add(2);
        
        outer:
        for ( int i = 3; i <= A; i++){
            int sqrt = (int)Math.sqrt (i);
        	
            Iterator <Integer> iter = primes.iterator();
            while (iter.hasNext()){
                int aPrime = iter.next();
                if (i % aPrime == 0 ) continue outer;
                if ( aPrime > sqrt ){
                	primes.add(i);
                	continue outer;
                }
            }
            primes.add(i);
        }
        return primes;

    }

	public static void main(String[] args) {
		ArrayList <Integer> aL = new PrimeSum().primesum(1048574);
		System.out.println(aL);

	}

}
