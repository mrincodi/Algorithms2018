package pinos;

import java.util.ArrayList;

public class FirstMissingPositiveRecursive {
	public int firstMissingPositive(ArrayList<Integer> A) {

		for ( int i = A.size() - 1; i >=0; i-- ){
			if (A.get (i) <= 0 ) A.remove(i);
		}

		for ( int index = 0; index < A.size(); index++){
			if (A.get ( index ) == 0 || A.get (index) > A.size() ) continue;

			clearIterative (A,A.get(index));
		}

		for ( int i = 0; i < A.size(); i++){
			if ( A.get(i) != 0) return i+1;
		}
		return A.size()+1;
	}


	void clearIterative (ArrayList <Integer> A,int vIndex){
		boolean exitThis=false;
		
		while (!exitThis){
			int index = vIndex - 1;
			// if ( A.get(index) == 0 || A.get(index) > A.size()) return;
			int newVIndex = A.get(index);
			A.set(index,0);
			if ( newVIndex == 0 || newVIndex > A.size()) exitThis=true;
			if ( newVIndex == index + 1 ) exitThis=true;
			vIndex = newVIndex;
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList <Integer> aL = new ArrayList <Integer>(java.util.Arrays.asList(1,100,4,3));
		int fmp = new FirstMissingPositiveRecursive().firstMissingPositive(aL);
		System.out.println (fmp);
	}

}
