package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//https://www.interviewbit.com/problems/word-break-ii/
//Another classic.

public class WordBreakII {

	public ArrayList<String> wordBreak(String A, ArrayList<String> B) {

		if (A.length()==0) return new ArrayList<String>();

		HashSet <String> words = new HashSet <String> ();

		for ( String word:B)
			words.add(word);

		return wordBreak (A, words );

	}

	ArrayList<String> wordBreak(String A, HashSet<String> words) {
		ArrayList<String> result = new ArrayList<String>();

		// OJO: Starting counter was 1. And it was < A.length(), not < A.length() -1
		for ( int i = 1; i < A.length(); i++){
			if (words.contains (A.substring(0,i))){
				ArrayList<String> partialResult = new ArrayList<String>();
				//Get the rest of sequences.
				partialResult = wordBreak(A.substring(i),words); 
				for ( int seqCounter = 0; seqCounter<partialResult.size (); seqCounter++){
					//TODO: Would be better to use StringBuffer here.
					String sequence = A.substring(0,i) + " " + partialResult.get(seqCounter);    
					partialResult.set(seqCounter, sequence);
				}
				result.addAll (partialResult);
			}
		}

		if (words.contains (A)){
			result.add(A);
		}

		return result;
	}

	public static void main(String[] args) {
		String A = "ab";
		//ArrayList <String> B = new ArrayList <String> (Arrays.asList("bababbbb", "bbbabaa", "abbb", "a", "aabbaab", "b", "babaabbbb", "aa", "bb"  ));
		ArrayList <String> B = new ArrayList <String> (Arrays.asList( "a", "b"  ));
		ArrayList <String> result = new WordBreakII().wordBreak(A, B);
		System.out.println( result);

	}

}
