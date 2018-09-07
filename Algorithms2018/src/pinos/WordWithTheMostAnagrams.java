package pinos;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class WordWithTheMostAnagrams {

	private static final String DIR = "/Users/mrincodi/git/Algorithms2018/Algorithms2018/src/dir";
	static HashMap < String, ArrayList < String > > cantidades;
	public String wordWithTheMostAnagrams ( ) throws IOException{
		String result = "";
		int maxCount = 0;

		ArrayList <String> diccionario = new ArrayList <String> ();
		cantidades = new HashMap <> ();

		diccionario = leerArchivos (DIR);
		
		for ( String sOrig : diccionario ){
			String s = sOrig;
//			s = Normalizer.normalize(s, Normalizer.Form.NFD);
//			s = s.replaceAll("\\p{M}", "");
			char [] sArray = s.toCharArray();
			Arrays.sort(sArray);
			String ordS = new String ( sArray );
			
			if ( !cantidades.containsKey(ordS))
				cantidades.put(ordS, new ArrayList < String > ( Arrays.asList(sOrig)));
			else
				cantidades.get(ordS).add(sOrig);
			
			if (cantidades.get(ordS).size() > maxCount){
				result = ordS;
				maxCount = cantidades.get(ordS).size();
				Collections.sort(cantidades.get(ordS));
				System.out.println (maxCount);
				System.out.println ( cantidades.get(ordS));

				
			}
		}
		return result;
	}

	private ArrayList<String> leerArchivos(String dirS) throws IOException {
		ArrayList < String > result = new ArrayList <>();
		java.io.File dir = new java.io.File(dirS);
        
        if ( !dir.isDirectory()){
            throw new java.io.IOException ( dir + "is not a valid a directory");
        }

        for (final java.io.File fileEntry : dir.listFiles()) {
            if (!fileEntry.isDirectory()) {
                java.io.File f = new java.io.File (fileEntry.getAbsolutePath());
                
                java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(f));
                String line;
                while ((line = br.readLine()) != null) {
                    result.add(line);
                }
                br.close();
            }
        }
		return result;
	}

	public static void main(String[] args) throws IOException {
		
		String s = new WordWithTheMostAnagrams().wordWithTheMostAnagrams();
		
		System.out.println (s);
		Collections.sort(cantidades.get(s));
		System.out.println ( cantidades.get(s));
	}

}
