package basic_data_structures;

public class Trie {
	final char END_WORD= '*';
	java.util.HashMap <Character, Trie> h;

	public Trie (){
		h = new java.util.HashMap <Character, Trie> ();
	}

	public void fill (java.io.File f )throws java.io.IOException{
		java.util.ArrayList <String> lotsOfWords = new java.util.ArrayList <String> ();

		if ( !f.exists()) {
			throw new java.io.FileNotFoundException( "File " + f.getAbsolutePath() + " not found!");
		}

		System.out.print(f.getAbsolutePath() + " ");
		java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(f));
		String line;
		while ((line = br.readLine()) != null) {
			lotsOfWords.add(line);
		}

		fill(lotsOfWords);
		System.out.println(lotsOfWords.size());
		br.close();
	}


	public void fill (java.util.ArrayList <String> words){
		for ( String word: words){
			java.util.HashMap<Character, Trie> pointer = this.h;
			for ( int i = 0; i < word.length(); i++){
				char c = word.charAt(i);
				if ( pointer.containsKey(c)){
					pointer = pointer.get(c).h;
				}
				else {
					pointer.put(c, new Trie());
					pointer = pointer.get(c).h;
				}
			}
			pointer.put(END_WORD, new Trie());
		}
	}

	public boolean isWordThere (String word ){
		java.util.HashMap<Character, Trie> pointer = this.h;

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
		Trie t = new Trie();
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


		System.out.println("Ya");



	}

}
