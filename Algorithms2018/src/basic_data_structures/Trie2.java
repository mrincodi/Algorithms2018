package basic_data_structures;

/**
 * Like Trie, but with the option of all the words having the same length.
 * 
 * @author mrincodi
 *
 */
public class Trie2 {
	final char END_WORD= '*';
	final int NO_FIXED_SIZE = -1;
	java.util.HashMap <Character, Trie2> h;
	int words_size = -1;

	public Trie2 (int words_size){
		h = new java.util.HashMap <Character, Trie2> ();
		this.words_size = words_size;
	}

	public Trie2 (){
		h = new java.util.HashMap <Character, Trie2> ();
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

		java.util.HashMap<Character, Trie2> pointer = this.h;
		for ( int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if ( pointer.containsKey(c)){
				pointer = pointer.get(c).h;
			}
			else {
				pointer.put(c, new Trie2());
				pointer = pointer.get(c).h;
			}
		}
		pointer.put(END_WORD, new Trie2());
		
		return true;
	}

	/**
	 * OK, this is going to be really random only if all the words are the same size.
	 * @return The random word.
	 */
	public String getRandomWord (){
		String result = "";

		java.util.HashMap<Character, Trie2> pointer = this.h;
		
		char c = 'X';
		while (true) {
			java.util.Set <Character> s = pointer.keySet();
			
			int size = s.size();
			int item = new java.util.Random().nextInt(size);
			
			java.util.Iterator <Character> iter = s.iterator();
			
			for ( int i = 0; i <= item; i++){
				c = iter.next();
			}
			
			if ( c == END_WORD) return result;
			
			result = result + c;
			pointer = pointer.get(c).h;
		}
	}


	public boolean isWordThere (String word ){
		java.util.HashMap<Character, Trie2> pointer = this.h;

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

	public static void main(String[] args) throws java.io.IOException {
		//		java.util.ArrayList <String> words;
		//		words = new java.util.ArrayList <String> (Arrays.asList("perro", "perrote", "perrón", "gato", "pena"));
		Trie2 t = new Trie2();
		boolean result;

		//		t.fill(words);

		//		boolean result = t.isWordThere("perro");
		//
		//		System.out.println(result);


		java.io.File dir = new java.io.File ("/Users/mrincodi/git/Algorithms2018/Algorithms2018/src/dir");
		t.fillFromDir(dir);
		//		java.io.File f = new java.io.File ("/Users/mrincodi/git/Algorithms2018/Algorithms2018/src/a.txt");
		//		t.fill(f);
		//
		//		f = new java.io.File ("/Users/mrincodi/git/Algorithms2018/Algorithms2018/src/b.txt");
		//		t.fill(f);
		//
		//		f = new java.io.File ("/Users/mrincodi/git/Algorithms2018/Algorithms2018/src/c.txt");
		//		t.fill(f);
		//
		//		f = new java.io.File ("/Users/mrincodi/git/Algorithms2018/Algorithms2018/src/d.txt");
		//		t.fill(f);





		result = t.isWordThere("animadversión");

		System.out.println(result);


		//System.out.println("Ya");



	}

}
