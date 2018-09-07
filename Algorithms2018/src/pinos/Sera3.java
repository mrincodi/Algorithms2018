package pinos;

import java.text.Normalizer;

public class Sera3 {

	public static void main(String[] args) {

//		boolean a = true;
//		boolean b = true;
//
//		int qq = 5;
//		int pp = ~qq;
//		
//		
//		if ( a & b ) System.out.println ( "Wow!");
//		System.out.println (pp);

		String string = "paranás"; 
		string = Normalizer.normalize(string, Normalizer.Form.NFD);
		string = string.replaceAll("[^\\p{ASCII}]", "");
		System.out.println (string);
	}

}
