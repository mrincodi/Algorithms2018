package pinos;

import java.util.Arrays;
import java.util.TreeSet;

public class Pi {

	java.util.TreeSet <Integer> primes = new java.util.TreeSet <Integer>(Arrays.asList(2));

	public int pi ( int n ){
		int result = 0;

		if ( n < 2 ) return 0;

		if ( n == primes.last()) return primes.size();

		if ( n < primes.last()) {

			java.util.Iterator <Integer> iter = primes.iterator();

			while (iter.hasNext()){
				int p = iter.next();
				if (p < n) result++;
				else return result;
			}
		}

		else {
			for ( int i = primes.last() + 1; i <= n; i++){
				if ( !isDivisible (i)){
					primes.add(i);
				}
			}
			return primes.size();
		}

		return result;
	}


	private boolean isDivisible(int n) {

		java.util.Iterator <Integer> iter = primes.iterator();

		while ( iter.hasNext()){
			int p = iter.next();
			if ( n % p == 0 ) return true;
		}
		return false;
	}

	public double xSobreLnX ( int x ){
		return (double)x / (Math.log((double)x - 1d));
	}

	public static void main(String[] args) {
		int n = 100000;
		Pi pi = new Pi ();
		int p = pi.pi(n);
		double xSobreLnX = pi.xSobreLnX(n);

		System.out.println ("Pi de " + n + " es " + p);
		System.out.println ("xSobreLnX de " + n + " es " + xSobreLnX);

		n = 1000000;
		p = pi.pi(n);
		xSobreLnX = pi.xSobreLnX(n);

		System.out.println ("Pi de " + n + " es " + p);
		System.out.println ("xSobreLnX de " + n + " es " + xSobreLnX);
		
	}

}
