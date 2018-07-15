package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/word-ladder-ii/description/
// The DFS solution (too slow). I solved this problem with BFS
// a long time ago. See the file WordLadderII in the
// interviewbit folder.

public class WordLadderIITooSlow {


	// int minLevels = Integer.MAX_VALUE;
	// int thisLevel = 0;

	HashMap < String, List < List < String > > > already = new HashMap < String, List < List < String > > >  ();
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

		List < List < String > > result = new  ArrayList < List < String > > ();

		//Create string for these words.
		StringBuffer sb = new StringBuffer ();
		sb.append (beginWord + "_" + endWord );
		for ( String word: wordList ){
			sb.append ( "_" + word );
		}
		String s = sb.toString ();

		if (already.containsKey (s)) return already.get(s);

		// if ( thisLevel > minLevels ) return result;

		// Check if my word is endWord or is neighbor of endWord.
		if ( beginWord.equals (endWord ) ){
			// Just check that endWord is in the dictionary.
			for ( String word: wordList){
				if ( word.equals ( endWord )) {
					result.add ( new ArrayList <String> ( Arrays.asList ( endWord )));
					return result;
				}
			}
			return result;
		}

		//     || isNeighbor ( beginWord, endWord ) ){ // TODO
		//     result.add ( new ArrayList ( Arrays.asList ( beginWord, endWord )));
		//     return result;
		// }

		for ( int i = 0; i < wordList.size(); i++ ){
			String thisWord = wordList.get ( i );
			if ( isNeighbor ( beginWord, thisWord )){

				if ( thisWord.equals (endWord)){
					result = new  ArrayList < List < String > > ();
					result.add ( new ArrayList ( Arrays.asList ( beginWord, endWord )));
					return result;
				}

				ArrayList<String> truncatedWordList = new ArrayList<String> ( wordList );
				truncatedWordList.remove ( i );
				// thisLevel++;
				List < List < String > > restOfResult = findLadders( thisWord, endWord, truncatedWordList);
				// thisLevel--;
				for ( List < String > partialResult : restOfResult){
					partialResult.add (0, beginWord);
				}
				result.addAll ( restOfResult );
				//minSize = Math.min ( restOfResult.size(), minSize);
			}
		}

		// Return shortest list.
		int minSize = Integer.MAX_VALUE;

		for ( int i = result.size() - 1; i >= 0; i--){
			minSize = Math.min ( result.get (i).size(), minSize);
		}   

		for ( int i = result.size() - 1; i >= 0; i--){
			if ( result.get (i).size() > minSize) result.remove ( i );
		}

		// minLevels = Math.min ( thisLevel, minLevels );
		already.put ( s, result);
		return result;  
	}

	private boolean isNeighbor ( String a, String b ) {
		boolean result = false;
		int numTimes = 0;
		for ( int i = 0; i < a.length(); i++){
			char c1 = a.charAt ( i );
			char c2 = b.charAt ( i );
			if ( c1 != c2 ){
				numTimes++;
				if (numTimes > 1 ) return false;
			}
		}

		return numTimes == 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
