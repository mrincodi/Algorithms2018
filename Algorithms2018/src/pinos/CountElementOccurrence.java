package pinos;

import java.util.List;

public class CountElementOccurrence {

	public int findCount(final List<Integer> A, int B) {
		int leftLimitForSearch = 0, rightLimitForSearch = A.size() - 1;
		int leftLimitSolution = -1, rightLimitSolution = -1;

		if ( A.size()==0 ) return 0;
		if ( A.size()==1 )
			return A.get(0) == B?1:0;

		if ( A.get(0) > B ) return 0;
		if ( A.get(A.size() - 1) < B ) return 0;

		if ( A.get(0) == B ) leftLimitSolution = 0;
		if ( A.get(A.size() - 1) == B ) rightLimitSolution = A.size() - 1;

		if ( leftLimitSolution == -1){
			leftLimitForSearch = 0;
			rightLimitForSearch = A.size() - 1;
			
			int prevPos = -1;
			int midPos = 0;
			while ( prevPos != midPos && leftLimitSolution == -1){
				prevPos = midPos;
				midPos = (leftLimitForSearch + rightLimitForSearch)/2;
				int val = A.get(midPos);
				if ( val < B ){
					leftLimitForSearch = midPos;
				}
				else if ( val > B ){
					rightLimitForSearch = midPos;
				}
				else {
					int prevVal = A.get (midPos - 1);
					if ( prevVal == B ){
						//Keep looking for limit.
						rightLimitForSearch = midPos;
					}
					else{
						//Found!
						leftLimitSolution = midPos;
					}
				}

			}
		}

		if ( leftLimitSolution == -1 ) return 0;

		if ( rightLimitSolution == -1){
			leftLimitForSearch = leftLimitSolution;
			rightLimitForSearch = A.size() - 1;
			int prevPos = -1;
			int midPos = 0;
			while ( prevPos != midPos && rightLimitSolution == -1){
				prevPos=midPos;
				midPos = (leftLimitForSearch + rightLimitForSearch)/2;
				int val = A.get(midPos);
				if (val < B ){
					leftLimitForSearch = midPos;
				}
				else if ( val > B ){
					rightLimitForSearch = midPos;
				}
				else {
					int nextVal = A.get (midPos + 1);
					if ( nextVal == B ){
						//Keep looking for limit.
						leftLimitForSearch = midPos;
					}
					else{
						//Found!
						rightLimitSolution = midPos;
					}
				}

			}
		}

		return rightLimitSolution - leftLimitSolution + 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		java.util.ArrayList <Integer> aL = new java.util.ArrayList <Integer>(java.util.Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 ));
//		java.util.ArrayList <Integer> aL = new java.util.ArrayList <Integer>(java.util.Arrays.asList(1,2,2,2,3));
		java.util.ArrayList <Integer> aL = new java.util.ArrayList <Integer>(java.util.Arrays.asList(1,2,3,3,5 ));

		System.out.println((new CountElementOccurrence().findCount(aL, 3)));
	}

}
