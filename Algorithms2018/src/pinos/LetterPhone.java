package pinos;

import java.util.ArrayList;
import java.util.HashMap;

//https://www.interviewbit.com/problems/letter-phone/
// I didn't like that I am creating that silly hashmap every time.
// I could have used an array,as a class variable
public class LetterPhone {

	HashMap <Integer, String> letters = new HashMap <Integer, String> ();

	public ArrayList<String> letterCombinations(String A) {

		letters.put(1,"1");
		letters.put(2,"abc");
		letters.put(3,"def");
		letters.put(4,"ghi");
		letters.put(5,"jkl");
		letters.put(6,"mno");
		letters.put(7,"pqrs");
		letters.put(8,"tuv");
		letters.put(9,"wxyz");
		letters.put(0,"0");


		ArrayList<String> result = new ArrayList<String> ();
		if (A.length() == 0){
			result.add("");
			return result;
		}

		ArrayList<String> partialResult = letterCombinations (A.substring (1));

		String firstCharacters = letters.get (Integer.parseInt(A.charAt(0)+""));
		for (int j = 0; j < firstCharacters.length();j++){
			char c = firstCharacters.charAt(j);

			for (int partialResultIndex = 0; partialResultIndex < partialResult.size(); partialResultIndex++){    
				result.add (c + partialResult.get(partialResultIndex));
			}
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
