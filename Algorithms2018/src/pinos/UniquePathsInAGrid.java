package pinos;

//https://www.interviewbit.com/problems/unique-paths-in-a-grid/
//Oldie but goodie.

import java.util.ArrayList;

public class UniquePathsInAGrid {

	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
		if ( A.get(0).get(0) == 1 || A.get(A.size()-1).get(A.get(0).size()-1) == 1) return 0;
		//Lets use a matrix.
		int [][] m = new int [A.size()][A.get(0).size()];

		m[0][0] = 1;
		for ( int i = 0 ; i < A.size(); i++){
			if (A.get(i).get(0) == 1) break;
			m[i][0]=1;
		}

		for ( int i = 0 ; i < A.get(0).size(); i++){
			if (A.get(0).get(i) == 1) break;
			m[0][i]=1;
		}

		for ( int i = 1 ; i < A.size(); i++){
			for ( int j = 1; j < A.get(0).size(); j++ ){
				if ( A.get(i).get(j)==1 ) m[i][j] = 0;
				else m[i][j]=m[i-1][j]+m[i][j-1];
			}
		}
		return m[A.size()-1][A.get(0).size()-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
