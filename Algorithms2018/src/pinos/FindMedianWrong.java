package pinos;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/matrix-median/
// Wrong solution. This is a CHALLENGING problem.

public class FindMedianWrong {
	public int findMedian(ArrayList<ArrayList<Integer>> A) {
		//All-right.
		//First find out position of the median.
		int posMedian = (A.size() * A.get(0).size())/2 + 1;

		//Find out smallest and largest integer.
		int width = A.get(0).size();
		int smallest = A.get(0).get(0);
		int largest = A.get(0).get(width-1);

		for ( int i = 1; i < A.size(); i++){
			smallest = Math.min (smallest,A.get(i).get(0));
			largest = Math.max (largest,A.get(i).get(width - 1));
		}

		//Now, look for the median.
		int currentCount = 0;
		int low = smallest;
		int high = largest;
		int result = 0;
		while ( low <= high){
			int mid = (low + high ) / 2;
			int hml = howManyLess (A, mid);
			if (hml > posMedian){ 
				result = mid; high = mid -1;
			}
			else
				low = mid + 1;
		}

		return result;
	}

	int howManyLess ( ArrayList<ArrayList<Integer>> A, int n) {
		int howMany = 0;
		for ( int i = 0; i < A.size(); i++){
			howMany += howManyLessInArray (A.get(i), n);
		}
		return howMany;
	}

	int howManyLessInArray ( ArrayList<Integer> A, int n ){
		int posLow = 0;
		int posHigh = A.size() - 1;

		while (posLow <= posHigh){
			int posMid = (posLow + posHigh)/2;
			if (A.get(posMid)<=n) posLow = posMid + 1;
			else posHigh = posMid - 1;
		}
		return posHigh;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
