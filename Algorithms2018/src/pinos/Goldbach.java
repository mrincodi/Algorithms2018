package pinos;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Goldbach {

	public LinkedHashSet < Integer > primes = new LinkedHashSet < Integer >();
	int maxChecked = 3;

	Goldbach (){
		maxChecked = 3;
		primes.add(2);
		primes.add(3);
	}

	void printWays ( int min, int max ){
		if ( min %2 != 0 || max % 2 != 0 || min > max ){
			System.out.println ("Oops...");
			return;
		}

		for ( int i = min; i <= max ; i+=2){
			int num = numWays ( i );
			System.out.print(num + " ");
		}
	}

	int numWays ( int n ){
		int result = 0;

		if ( n > maxChecked){
			updatePrimesUpTo (n);
		}

		Iterator <Integer> iter = primes.iterator();

		while ( iter.hasNext()){
			int p = iter.next();
			if ( p <= n/2 ){
				if ( primes.contains(n - p)) result++;
			}
			else return result;
		}

		return result;
	}

	private void updatePrimesUpTo(int number) {
		int max = maxChecked % 2 == 1?maxChecked:maxChecked + 1;
		for ( int n = max ; n <= number; n = n + 2){
			if ( isPrime ( n )) primes.add(n);
		}
		maxChecked = number;
	}

	private boolean isPrime ( int n ){

		Iterator < Integer > iter = primes.iterator();
		int sqrtRoot = (int) Math.sqrt((double)n);

		while ( iter.hasNext()){
			int p = iter.next();
			if ( n % p == 0 ) return false;
			if ( p > sqrtRoot ) return true;
		}
		return true;
	}

	public static void main(String[] args) {
		new Goldbach().printWays(0,10000);
	}

}
