package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;


// https://www.interviewbit.com/problems/sub-matrices-with-sum-zero
// Official InterviewBit solution.
// I still have to look into why this works.


public class SubMatricesWithSumZero {

	public int solve(ArrayList<ArrayList<Integer>> A) {
		int result = 0;

		int height = A.size();
		if ( height == 0 ) return 0;

		int width = A.get(0).size();
		if ( width ==  0 ) return 0;

		int [][] m = new int [height][width];

		//Fill the matrix.
		for ( int i = 0; i < height; i++){
			for (int j = 0; j < width; j++){
				m[i][j]=A.get(i).get(j);
			}
		}

		for ( int rowStart = 0; rowStart < height; rowStart++){
			for ( int rowEnd = rowStart; rowEnd < height; rowEnd++){
				//Create array.
				int [] array = new int [width];
				for ( int i = 0; i < width; i++ ){
					for (int j = rowStart; j <= rowEnd; j++){
						array[i] += m[j][i];
					}
					//if ( array[i] == 0) result++;
				}

				//Now, calculate sums from beginning to end.
				HashMap <Integer, Integer> h = new HashMap <Integer, Integer> ();
				h.put(0, 1);
				int sum = 0;
				for ( int i = 0; i < width; i++){
					sum += array[i];
					h.put (sum,h.getOrDefault (sum,0) + 1); //Number of times that sum has showed up.
				}

				//Now, go over the hashmap keys, and see if a value is more than once.
				Iterator <Integer> iter = h.keySet().iterator();

				while (iter.hasNext()){
					sum = iter.next();
					if ( h.get(sum)==2)result +=1;
					if ( h.get(sum)>2) result += factorial (h.get(sum))/(2*factorial(h.get(sum)-2));
				}
			}
		}
		return result;
	}

	int factorial (int n){
		if ( n <=1 ) return 1;
		return n * factorial (n-1);
	}


	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>> ();
		A.add(new ArrayList<Integer> (Arrays.asList(0,0)));
		A.add(new ArrayList<Integer> (Arrays.asList(0,0)));
		int result = new SubMatricesWithSumZeroAlmostDone().solve(A);
		System.out.println(result);
	}

}
