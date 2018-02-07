package pinos;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/shortest-common-superstring/
// Just my try. Had several questions, so it's not finished.

public class ShortestComonSubstringIncomplete {
/*
	public int solve(ArrayList<String> A) {
		if ( A == null || A.size() == 0) return 0;
		if (A.size() == 1) return A.get(0).length();

		int result = Integer.MAX_VALUE;

		String firstWord = A.get(0);

		for ( int i = 1; i < A.size(); i++ ){
			// TODO: Method to join
			ArrayList <String> joins = join (firstWord, A.get(i));
			ArrayList <String> otherWords = new ArrayList <String> (A);
			otherWords.remove (A.get(i));
			for ( String join: joins)
				otherWords.set (0,join);

			int possibleResult = solve (otherWords);

			result = Math.min (result, possibleResult);
		}
	}
	return result;
}

ArrayList <String> join (String a, String b){
	ArrayList <String> result = new ArrayList <String> ();

	if ( a.length ()== 0 && b.length ()== 0) return result;
	if ( a.length ()== 0 ){
		result.add(a);
		return result;
	}
	if (b.length ()== 0 ){
		result.add (b);
		return result;
	}

	//Let's see if there is an intersection.
	//First, let's see if one word is contained in another one.

	if (a.equals(b) {
		result.add(a);
		return result;
	}


	//Let's find the longest word.
	if (a.length () > b.length()){
		String temp = a;
		a = b;
		b = temp;
	}

	//Is a in b?
	for ( int i = 0; i < b.length() - a.length(); i++ ){
		if (b.substring (i,a.length()).equals(a)){
			result.add(b);
			return result;
		}
	}

	//Does b start with some part of a?
	for ( int i = 1; i < a.length() -1; i++){
		String suffixA = A.substring (i);
		if ( b.substring (0, suffixA.length()).equals(suffixA)){
			result.add (suffixA);
			break;
		}
	}

	//Does b ends with some start of a?
	//(...)

}

//

}

public static void main(String[] args) {
	// TODO Auto-generated method stub

}
*/
}
