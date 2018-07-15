package basic_data_structures;

import java.util.ArrayList;

/**
 * Like Trie2, but with a size field. This way we can really give random words.
 * TODO:
 * - Clean code
 * - Add words with StringBuffer, not "+".
 * - Instead of having an option for fixed size, have an option for "min_size" and "max"size",
 *   where one or both can be -1. Fill out the dictionary with words with lengths in those boundaries.
 * 
 * @author mrincodi
 *
 */
public class Trie3 {
	final char END_WORD= '*';
	final int NO_FIXED_SIZE = -1;
	java.util.TreeMap <Character, Trie3> h;
	int my_size = 0;
	int words_size = -1;

	public Trie3 (int words_size){
		h = new java.util.TreeMap <Character, Trie3> ();
		this.words_size = words_size;
	}

	public Trie3 (){
		h = new java.util.TreeMap <Character, Trie3> ();
		this.words_size = NO_FIXED_SIZE;
	}

	public void fill (java.io.File f )throws java.io.IOException{
		java.util.ArrayList <String> lotsOfWords = new java.util.ArrayList <String> ();

		if ( !f.exists()) {
			throw new java.io.FileNotFoundException( "File " + f.getAbsolutePath() + " not found!");
		}

		//System.out.print(f.getAbsolutePath() + " ");
		java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(f));
		String line;
		while ((line = br.readLine()) != null) {
			lotsOfWords.add(line);
		}

		fill(lotsOfWords);
		//System.out.println(lotsOfWords.size());
		br.close();
	}

	public void fill (java.util.ArrayList <String> words){
		for ( String word: words){	
			fill(word);
		}
	}

	public boolean fill (String word){
		if ( this.words_size != NO_FIXED_SIZE && word.length() != this.words_size) return false;

		this.my_size++;
		java.util.TreeMap<Character, Trie3> pointer = this.h;
		for ( int i = 0; i < word.length(); i++){
			char c = word.charAt(i);

			if ( !pointer.containsKey(c))
				pointer.put(c, new Trie3());

			pointer.get(c).my_size++;
			pointer = pointer.get(c).h;

		}
		pointer.put(END_WORD, new Trie3());

		return true;
	}

	public String getWordFromNumber (int n){
		String s = getWordFromNumberRec(n);
		return s.substring(0, s.length()-1);
	}

	private String getWordFromNumberRec (int n ){
		if ( n < 0 || n > this.my_size) return END_WORD + "";

		if (n == 0 ){
			if ( this.h.containsKey(END_WORD)) return "";
			//TODO: If not, there is an error. Throw exception or something.
		}
		else {
			//Look for the "n-th" word.
			java.util.Iterator <Character> iter = this.h.keySet().iterator();

			int wordsSoFar = 0;
			char c =END_WORD;
			while ( iter.hasNext()){
				c = iter.next();

				if (wordsSoFar + h.get(c).my_size >= n)
					return c + h.get(c).getWordFromNumberRec(n - wordsSoFar);

				wordsSoFar += h.get(c).my_size;
			}
		}
		return END_WORD + "";
	}

	public boolean isWordThere (String word ){
		java.util.TreeMap<Character, Trie3> pointer = this.h;

		for ( int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if (!pointer.containsKey(c)) return false;
			pointer = pointer.get(c).h;
		}
		if (!pointer.containsKey(END_WORD)) return false;
		return true;	//TODO.
	}

	/**
	 * Here, I receive the path of a directory with the files that contain valid words.
	 * @param dir
	 */
	public void fillFromDir (java.io.File dir) throws java.io.IOException{

		if ( !dir.isDirectory()){
			throw new java.io.IOException ( dir + "is not a valid a directory");
		}

		for (final java.io.File fileEntry : dir.listFiles()) {
			if (!fileEntry.isDirectory()) {
				java.io.File f = new java.io.File (fileEntry.getAbsolutePath());
				//System.out.println(f.getName());
				fill(f);
			}
		}
	}

	public String getRandomWord (){
		int total_size = this.my_size;
		java.util.Random rand = new java.util.Random();

		int  n = rand.nextInt(total_size) + 1;
		String q  = this.getWordFromNumber(n);
		return q;
	}

	public java.util.ArrayList <String> wordsWithLetters ( String letters ){

		if ( letters == null ) return null;

		char [] let = letters.toCharArray();
		java.util.Arrays.sort(let);
		letters = new String (let);
		return wordsWithLettersRec (letters);
	}

	private ArrayList<String> wordsWithLettersRec(String sortedLetters) {
		ArrayList<String> result = new ArrayList<String>();

		if (sortedLetters.length() == 0) return result;

		for ( int i = 0; i < sortedLetters.length(); i++){
			char c = sortedLetters.charAt(i);

			//So we don't have repeated words in case of repeated letters:
			if ( i > 0 && sortedLetters.charAt(i-1) == c) continue;

			if (this.h.containsKey(c)){
				//Is this the end of a word?
				if ( this.h.get(c).h.containsKey(END_WORD))
					result.add(c + "");

				//Take letter out from string.
				String otherLetters = sortedLetters.substring(0,i)+sortedLetters.substring(i+1);
				ArrayList<String> partial = this.h.get(c).wordsWithLettersRec(otherLetters);
				for ( String w: partial){
					result.add(c + w);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) throws java.io.IOException {
		Trie3 t = new Trie3();
		boolean result;

		java.io.File dir = new java.io.File ("/Users/mrincodi/git/Algorithms2018/Algorithms2018/src/dir");
		t.fillFromDir(dir);

		String q = t.getRandomWord();
		System.out.println("The word is "+ q);
		ArrayList <String> littleWords = t.wordsWithLetters(q);

		System.out.println(littleWords);

		result = t.isWordThere("animadversión");

		System.out.println(result);
	}
}
