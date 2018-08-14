package hackerrank;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TheCoinChangeproblem {

	static long getWays(long n, long[] c) {
		long result = 0;
		if ( n < 1 ) return 0;

		if (c.length == 1 ){
			if  ( c [ 0 ] == n ) return 1;
			else return 0;
		}

		long v = c [ 0 ];

		// 1) v > n.
		if ( v > n ){
			long [] c1 = Arrays.copyOfRange(c,  1,  c.length);
			result = getWays ( n, c1 );
			return result;
		}

		// v == n
		else if ( v == n ){
			result = 1;
			long [] c1 = Arrays.copyOfRange(c,  1,  c.length );
			result = result + getWays ( n, c1 );
			return result;
		}
		else { // if ( v < n )
			// If I use it in this count:
			long subresult1 = getWays ( n - v, c);
			long [] c1 = Arrays.copyOfRange(c,  1,  c.length);
			long subresult2 = getWays ( n, c1);
			result = subresult1 + subresult2;

			return result;

		}





		//		
		//		
		//		
		//		
		//		
		//		
		//		
		//		
		//		
		//		long partialResult = 0;
		//		
		//		if ( v < n ){
		//			partialResult = getWays ( n - v, c );
		//		}
		//
		//		long [] c1 = 
		//				Arrays.copyOfRange(c,  1,  c.length - 1);
		//		long partialResult2 = 0;
		//		partialResult2 = getWays (n, c1);
		//
		//		result = partialResult + partialResult2;

		//return result;

	}

	// Complete the getWays function below.
	//	static HashMap <Long, Long > ways = new HashMap <Long, Long >();
	//	static long getWays(long n, long[] c) {
	//		if ( ways.containsKey(n)) return ways.get(n);
	//
	//		long result = 0;
	//		for ( int i = 0; i < c.length; i++){
	//			long v = c[i];
	//			if ( v == n ) result++;
	//			if ( v < n ) result = result + getWays (n - v, c );
	//		}
	//		ways.put(n, result);
	//		return result;
	//
	//	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		long [] a= { 2,5,3,6};
		long r = getWays (4, a);
		System.out.println(r);


		//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		//
		//		String[] nm = scanner.nextLine().split(" ");
		//
		//		int n = Integer.parseInt(nm[0]);
		//
		//		int m = Integer.parseInt(nm[1]);
		//
		//		long[] c = new long[m];
		//
		//		String[] cItems = scanner.nextLine().split(" ");
		//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		//
		//		for (int i = 0; i < m; i++) {
		//			long cItem = Long.parseLong(cItems[i]);
		//			c[i] = cItem;
		//		}
		//
		//		// Print the number of ways of making change for 'n' units using coins having the values given by 'c'
		//
		//		long ways = getWays(n, c);
		//
		//		bufferedWriter.close();
		//
		//		scanner.close();
	}


}
