package pino_word_challenge;


import java.io.IOException;
import java.util.Arrays;

public class Game {
	static final String DIR = "/Users/mrincodi/git/Algorithms2018/Algorithms2018/src/dir";
	int num_letters;
	static final int DEFAULT_NUM_LETTERS = 6;
	basic_data_structures.Trie2 t;
	
	Game ( java.io.File dir, int num_letters ) throws IOException{
		t = new basic_data_structures.Trie2(num_letters);
		t.fillFromDir(dir);
	}
	
	Game ( java.io.File dir ) throws IOException{
		this (dir, DEFAULT_NUM_LETTERS);
	}
	
	char [] shuffleWord ( String w ){
		if ( w == null) return null;
		char [] result = new char [ w.length()];

//		// TODO: MR: Continúe aquí.
//		Character [] qq = w.toCharArray();
//		ArrayUtils.toObject(charArray);

		java.util.ArrayList <Character> wl = new java.util.ArrayList <Character> (java.util.Arrays.asList('f'));
	
		int size = w.length();
		for ( int i = 0; i < w.length(); i++){
			int item = new java.util.Random().nextInt(size--);
			
		}
		
		return result;
		
	}
	public void game () throws java.io.IOException{
		
		java.io.File dir = new java.io.File (DIR);
		
		Game g = new Game (dir);
		
		String w = g.t.getRandomWord();
		
		char [] shuffledWord = shuffleWord (w);
		
		System.out.println(w);
//		
//		boolean qq = g.t.isWordThere("cabeza");
//		
//		System.out.println(qq);
		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		java.io.BufferedReader br = null;
//		br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
//
//		while (true){
//			System.out.println ( "¿Número de letras? <Enter> para terminar.");
//			String input = br.readLine();
//			
//			System.out.println(input);
//			
//			int numLetras = Integer.parseInt(input);
//			
//			//Now, look for a word with that amount of letters
//		}
	}
	public static void main(String[] args) throws java.io.IOException {
		java.io.File dir = new java.io.File (Game.DIR);
		Game g = new Game (dir);
		
		g.game();

	}

}
