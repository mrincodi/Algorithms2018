package pinos;

import java.util.HashMap;
import java.util.Iterator;
//https://www.interviewbit.com/problems/window-string/
//Ugly, and takes too long for InterviewBit.
//I think I am comparing the hashes too many times.
//Also the pointers should move in a more intelligent way than one step at a time.
//InterviewBit's result uses an array as a HashMap.

public class WindowStringUgly {
	public String minWindow(String A, String B) {
		String result = "";

		if ( B.length ()> A.length () ) return result;

		//First, get needed hash.
		HashMap <Character, Integer> needed = new HashMap <Character, Integer>();
		HashMap <Character, Integer> current = new HashMap <Character, Integer>();

		for ( int i = 0; i < B.length(); i++){
			char character = B.charAt(i);

			current.put(character, 0);

			if (needed.containsKey(character))
				needed.put(character,needed.get(character)+1);
			else
				needed.put(character,1);
		}

		int startPointer=0, endPointer = -1;
		
		//Find the initial position.
//		while (startPointer <= A.length()-B.length()){
//			if (needed.containsKey(A.charAt(startPointer))){
//				if (B.length()==1) return B;
//				current.put(A.charAt(startPointer),1);
//				endPointer = startPointer;
//				break;
//			}
//		}
//		
		//if (startPointer==A.length()-B.length()) return "";
		
		//boolean relevant = false;

		String testing ="";
		while (startPointer <= A.length()-B.length()){
			testing =A.substring(startPointer,endPointer+1);

			if (charsEval (needed,current) == -1){ // chars needed.
				endPointer++;
				if ( endPointer == A.length()) break;
				if (current.containsKey(A.charAt(endPointer))){
					current.put(A.charAt(endPointer),current.get(A.charAt(endPointer))+1);
					// Ignore otherwise.
				}
			}
			else{ // Extra chars
				//Take the current character out first.
				if (current.containsKey(A.charAt(startPointer))){
					//current should have it already.
					current.put (A.charAt(startPointer),current.get(A.charAt(startPointer))-1);
				}
				startPointer++;
				if (startPointer == A.length()-B.length() + 1) break;
			}

			//Now, do I have the right amount? If I have extra, this could be a solution too.
			if ( charsEval (needed,current) > -1){
				String currentResult = A.substring (startPointer, endPointer+1);
				if ( result.length() == 0 || currentResult.length() < result.length()) result= currentResult;
				
//				//Find the next valid character.
//				while (startPointer <= A.length()-B.length()){
//					if (current.containsKey(A.charAt(startPointer))){
//						endPointer=Math.max(endPointer, startPointer);
//						break;
//					}
//					startPointer++;
//				}
			}
			//relevant = false;
		}

		return result;
	}

	int charsEval ( HashMap <Character, Integer> needed, HashMap <Character, Integer> current){
		Iterator <Character> iter = current.keySet().iterator();

		boolean extra = false;
		while (iter.hasNext()){
			char character = iter.next();
			if (current.get(character)<needed.get(character))
				return -1;
			if (current.get(character)>needed.get(character))
				extra = true;
		}
		if ( extra )return 1;
		return 0;
	}


	public static void main(String[] args) {
		String S = "A";
		String T  = "A";

		String result = new WindowStringUgly().minWindow(S, T);
		System.out.println(result);

	}

}
