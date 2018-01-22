package pinos;

import java.util.HashMap;

// https://www.interviewbit.com/problems/window-string/
// I solved the wrong problem. :(

public class WindowStringWRONG {


	public String minWindow(String A, String B) {

		if (B.length () > A.length()) return "";
		HashMap<Character,Integer> needed = new HashMap<Character,Integer>();

		for ( int i = 0; i < B.length(); i++){
			Character c = B.charAt(i);
			if ( needed.containsKey(c) )
				needed.put(c,needed.get(c)+1);
			else
				needed.put(c,1);
		}

		HashMap<Character,Integer> missing = new HashMap<Character,Integer>(needed);

		//Initial window scan.
		for ( int i = 0; i < B.length();i++){
			char c = A.charAt(i);
			if (missing.containsKey(c)){
				int val = missing.get(c);
				if (val == 1)
					missing.remove(c);
				else
					missing.put(c,missing.get(c)-1);
			}
		}

		if (missing.isEmpty()) return A.substring (0,B.length());

		//TODO: Test when size of window is one.
		for ( int startWindow = 1; startWindow<A.length()-B.length();startWindow++){
			//Remove the character.
			char charToRemove = A.charAt(startWindow - 1);

			if ( needed.containsKey (charToRemove)){
				if ( !missing.containsKey (charToRemove)){
					//We need it again.
					missing.put(charToRemove,1);
				}
				else {
					//We miss one occurrence of it.
					missing.put (charToRemove,missing.get(charToRemove)+1);
				}
			}

			char newChar = A.charAt(startWindow + B.length() -1 );

			if ( needed.containsKey (newChar)){
				if (missing.containsKey(newChar)){
					if (missing.get(newChar)== 1){
						missing.remove(newChar);
					}
					else{
						missing.put(newChar,missing.get(newChar)-1);
					}
				}
			}

			if (missing.isEmpty()) return A.substring (startWindow,startWindow + B.length()); 
		}

		return "";

	}
}

