package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/extra-long-factorials/problem
// ??? This was not hard at all!!
// 2018-08-01

public class ExtraLongFactorials {

	// Complete the extraLongFactorials function below.
	static void extraLongFactorials(int n) {
		BigInteger result = factorial (n);
		System.out.println (result);
	}

	static BigInteger factorial ( int n ){

		BigInteger result = BigInteger.ONE;

		while ( n > 1 ){
			result = result.multiply(BigInteger.valueOf(n));
			n--;
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		extraLongFactorials(n);

		scanner.close();
	}
}



