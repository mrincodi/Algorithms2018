package pinos;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/

// O(nˆ2) solution with "histograms" strategy.
public class MaxrectangleInBinaryMatrix {
	public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {

		// Go row by row.
		// Find the maximum rectangle that ends in that row,
		// as if this were the last row in the matrix.
		// Use the "largest rectangle under histogram" strategy.

		//First, create the helper matrix.
		//NOTE: This was not really needed. It could have been calculated row by row.
		int [][] m = new int [A.size()][A.get(0).size()+2];

		for ( int j = 0; j < A.get(0).size(); j++)
			m[0][j+1]=A.get(0).get(j);

		//m[0][m.length-1]=0;

		for ( int i = 1; i < A.size(); i++){
			for ( int j = 0; j < A.get(0).size(); j++){
				if (A.get(i).get(j) == 0) m[i][j+1]=0;
				else m[i][j+1] = m[i-1][j+1]+1;
			}
			//m[i][A.get(0).size()]=0;
		}

		int maxRectangleArea = 0;
		for ( int i = 0; i< A.size(); i++){ //Row by row
			maxRectangleArea = Math.max(maxRectangleArea, getLargestRectangleUnderHistogram (m[i]));
		}

		return maxRectangleArea;
	}



	private int getLargestRectangleUnderHistogram(int[] r) {
		java.util.Stack <Integer> s = new java.util.Stack <Integer> () ;
		int maxArea = 0;
		for ( int i = 0; i <r.length; i++){
			if (s.isEmpty()){
				s.push(i);
			}
			else {
				if (r[i] >= r[s.peek()]) s.push(i);
				else{

					while ( !s.isEmpty() && r[s.peek()] >= r[i]){
						int thisArea = 0;
						int top = s.pop();

						if ( !s.isEmpty())
							thisArea = r[top] * (i - s.peek() -1);
						else
							thisArea = r[top] * (i - top);

						maxArea = Math.max(thisArea, maxArea);
					}
					
					s.push(i);
				}
			}
		}
		return maxArea;
	}


	public static void main(String[] args) {
		ArrayList < ArrayList <Integer>> A = new ArrayList < ArrayList <Integer>>();
//		A.add(new ArrayList<Integer>(Arrays.asList(0,0,1,1,0)) );
//		A.add(new ArrayList<Integer>(Arrays.asList(0,1,1,1,0)) );
//		A.add(new ArrayList<Integer>(Arrays.asList(0,0,1,1,0)) );
//		A.add(new ArrayList<Integer>(Arrays.asList(0,0,1,1,1)) );
//		A.add(new ArrayList<Integer>(Arrays.asList(1,0,1,1,0)) );

//		  A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 0, 0, 1, 0, 1)));
//		  A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 0, 0, 0, 0, 0, 0)));
//		  A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 0, 1, 0, 1)));
//		  A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0, 1, 1, 0, 1)));
//		  A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0, 0, 1, 1, 1)));
//		  A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1, 1, 1, 0, 1, 1, 1)));
//		  A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 0, 1, 1, 1, 1)));
//		  A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0, 1, 0, 1, 0, 1)));	
//		
		
		  A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 0)));
		  A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0)));
		  A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1)));
		  A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1, 0)));
		  A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)));
		  A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1)));
		
		int v =  new MaxrectangleInBinaryMatrix().maximalRectangle(A);

		System.out.println(v);

	}

}
