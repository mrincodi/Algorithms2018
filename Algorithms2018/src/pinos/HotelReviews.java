package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

//https://www.interviewbit.com/problems/hotel-reviews/
// I don't know what this problem has to do with trees or tries at all.

public class HotelReviews {
	public ArrayList<Integer> solve(String A, ArrayList<String> B) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		//Put the good words in a hashSet.

		String [] goodWordsArray = A.split("_");
		HashSet <String> goodWords = new HashSet <String>();

		for ( String w: goodWordsArray ){
			goodWords.add (w);
		}

		//Now, the TreeSet that maps number of good words with word positions in the review.
		TreeMap <Integer, ArrayList <Integer>> positions = new TreeMap <Integer, ArrayList <Integer>> ();    

		for ( int i = 0; i < B.size(); i++){
			String review = B.get(i);

			String [] reviewWords = review.split("_");

			// How many words are good words?
			int howManyGoodWords = 0;
			for ( String word: reviewWords){
				if ( goodWords.contains (word)) howManyGoodWords++;
			}

			//Now, add position in TreeSet.
			if ( positions.containsKey (howManyGoodWords)){
				positions.get(howManyGoodWords).add(i);
			}
			else {
				positions.put (howManyGoodWords, new ArrayList <Integer> (Arrays.asList(i)));   
			}
		}

		// Finally, just create the final ArrayList with the positions.
		Iterator iter = positions.keySet().iterator();
		while ( iter.hasNext()){
			result.addAll (0, positions.get(iter.next()));
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
