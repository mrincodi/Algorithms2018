package pinos;

import java.util.ArrayList;
import java.util.HashMap;

//https://www.interviewbit.com/problems/shortest-unique-prefix/
// Why do they always create another structure? HashMap < Character, HashMap> suffices.
public class ShortestUniquePrefix {

	public ArrayList<String> prefix(ArrayList<String> A) {
		ArrayList<String> result = new ArrayList<String> ();
		if (A.size() == 0) return result;
		HashMap < Character, HashMap> trie = new HashMap < Character, HashMap> ();

		trie.put ('0',new HashMap<Character, HashMap>());

		HashMap < Character, HashMap> triePointer = trie;

		//Fill trie.
		for (String word:A){
			triePointer = trie.get('0');
			for ( int i = 0; i < word.length();i++){
				char c = word.charAt(i);
				if (!triePointer.containsKey(c))
					triePointer.put(c,new HashMap<Character, HashMap>());

				triePointer = triePointer.get(c);
			}
		}

		//Now, look for the smallest prefixes per word.
		for (String word:A){
			triePointer = trie.get('0');
			String prefix = word.charAt(0) + "";
			for (int i = 0; i< word.length(); i++){
				char c = word.charAt(i);
				triePointer = triePointer.get (c);
				if ( triePointer.keySet().size() > 1 )
					prefix = word.substring (0,i+2);
			}
			result.add(prefix);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
