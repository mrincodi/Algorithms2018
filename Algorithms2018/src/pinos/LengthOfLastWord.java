package pinos;

//https://www.interviewbit.com/problems/length-of-last-word/#

public class LengthOfLastWord {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int lengthOfLastWord(final String A) {
		int lastWordLength = 0;
		for ( int i = A.length()-1; i>=0; i--){
			char thisChar = A.charAt(i);
			if ( thisChar != ' '){  //If it is a letter
				lastWordLength++;
			}
			else {
				if (lastWordLength == 0) continue;
				else return lastWordLength;
			}
		}
		return lastWordLength;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
