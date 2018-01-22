package pinos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://www.interviewbit.com/problems/substring-concatenation/

public class SubstringConcatenation {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public ArrayList<Integer> findSubstring(String S, final List<String> L) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		if (L.size()==0) return result;

		int sizeOfEachWord = L.get(0).length();

		if ( sizeOfEachWord * L.size() > S.length()) return result;

		//Make initial hash.
		HashMap <String, Integer> words = new HashMap <String, Integer>();

		for ( String w: L){
			if ( words.containsKey (w))
				words.put(w,words.get(w)+1);
			else
				words.put(w,1);
		}

		outer:
			for ( int i = 0; i < S.length() - sizeOfEachWord * L.size() + 1; i++){
				HashMap <String, Integer> words1 = new HashMap <String, Integer> (words);
				//Check words.
				inner:
					for (int wordCounter=0; wordCounter < L.size(); wordCounter++){
						int wordStart = i + wordCounter*sizeOfEachWord;
						String word = S.substring(wordStart, wordStart + sizeOfEachWord);
						if ( !words1.containsKey(word)) continue outer;
						words1.put(word,words1.get(word)-1);
						if (words1.get(word) == 0) words1.remove(word);
					}
				if ( words1.isEmpty()) result.add(i);
			}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
