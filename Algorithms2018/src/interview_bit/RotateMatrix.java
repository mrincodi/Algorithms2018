package interview_bit;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/rotate-matrix/
// Annoying, but important.
public class RotateMatrix {

	public void rotate(ArrayList<ArrayList<Integer>> a) {

		for ( int i = 0; i < a.size() / 2; i++ ){
			for ( int j = i; j < a.size() - 1 - i; j++ ){
				int temp = a.get(i).get(j); 

				a.get ( i ).set (j,a.get(a.size()-1-j).get (i));

				a.get ( a.size()-1-j).set (i, a.get (a.size()- 1 - i).get (a.size() - 1 - j ));

				a.get ( a.size()- 1 - i).set (a.size() - 1 - j, a.get (j).get( a.size() -i - 1 ));  

				a.get (j).set( a.size() - i - 1 , temp); 
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		

	}

}
