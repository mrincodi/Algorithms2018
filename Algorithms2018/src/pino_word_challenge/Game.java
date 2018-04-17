package pino_word_challenge;

/*
 * TODO:
 * - Clean code.
 * - Present words in 5 columns top-down.
 *  
 */
import java.io.IOException;
import java.util.Scanner;

public class Game {
	static final String DIR = "/Users/mrincodi/git/Algorithms2018/Algorithms2018/src/dir";
	int num_letters;
	static final int DEFAULT_NUM_LETTERS = 6;
	basic_data_structures.Trie3 t;   // Trie with only words of word size.
	basic_data_structures.Trie3 all; // Trie with all the words.
	String END_GAME = "FIN";

	Game ( java.io.File dir, int num_letters ) throws IOException{
		t = new basic_data_structures.Trie3(num_letters);
		t.fillFromDir(dir);

		all = new basic_data_structures.Trie3();
		all.fillFromDir(dir);
	}

	Game ( java.io.File dir ) throws IOException{
		this (dir, DEFAULT_NUM_LETTERS);
	}

	String shuffleWord ( String w ){
		if ( w == null) return null;
		String result = "";

		java.util.ArrayList <Character> letters = new java.util.ArrayList <Character> ();

		for ( int i = 0; i < w.length(); i++){
			letters.add(w.charAt(i));
		}

		for ( int i = 0; i < w.length(); i++){
			int item = new java.util.Random().nextInt(letters.size());
			result = result + letters.get(item);
			letters.remove(item);
		}

		return result;	
	}

	public void game () throws java.io.IOException{
		java.io.File dir = new java.io.File (DIR);

		Game g = new Game (dir, 23);

		while ( true ){ 
			String w = g.t.getRandomWord();

			String shuffledWord = shuffleWord (w);

			java.util.ArrayList <String> words = g.all.wordsWithLetters(w);
			java.util.TreeSet <String> toGuess = new java.util.TreeSet <String>();

			for ( String word: words)
				toGuess.add(word);

			System.out.println("Letras : "+ shuffledWord);

			while (!toGuess.isEmpty()){

				System.out.println("Letras : " + shuffledWord);
				System.out.println("Palabras que faltan : "+ toGuess.size());

				int wordsPerLine = 5;
				int j = 0;

				for ( String ww: words){

					if ( !toGuess.contains(ww))
						System.out.print(ww + "\t");
					else{
						StringBuffer sb = new StringBuffer();
						for ( int ii = 0; ii < ww.length(); ii++)
							sb.append('*');
						System.out.print(sb.toString() + "\t");
					}

					j++;
					if ( j % wordsPerLine == 0) System.out.println();
				}

				System.out.println();
				System.out.println("Palabra (escribe " + END_GAME + " para terminar).");
				java.io.BufferedReader br = null;
				br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
				String input = br.readLine();

				if ( toGuess.contains(input)){
					System.out.println("¡Bien!");
					toGuess.remove(input);

					if ( input.equals(w)){
						System.out.println("¡¡ERA LA PALABRA ORIGINAL!!");
					}
				}

				if ( input.equals(END_GAME)){

					System.out.println("Palabras que te faltaron:");
					java.util.Iterator <String> iter = toGuess.iterator();
					while (iter.hasNext()){
						System.out.println(iter.next());
					}
					toGuess=new java.util.TreeSet <String>();
					System.out.println("Presiona <Enter> para continuar.");
					input = br.readLine();
				}
			}
			if ( toGuess.isEmpty()){
				System.out.println("****************************************");
				System.out.println("** ¡¡FELICITACIONES!! ¡¡LO LOGRASTE!! **");
				System.out.println("****************************************");
			}
		}
	}
	public static void main(String[] args) throws java.io.IOException {
		java.io.File dir = new java.io.File (Game.DIR);
		Game g = new Game (dir);

		g.game();

	}

}
