package pinos;

import java.io.IOException;
import java.util.HashSet;

public class RepeatedWords {
	private static final String dirS = "/Users/mrincodi/git/Algorithms2018/Algorithms2018/src/dir";

	static void printRepeatedWords () throws IOException{
		HashSet < String > set = new HashSet < String >();

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

					if ( set.contains(line))
						System.out.println (line);
					else set.add(line);
				}
				br.close();
			}
		}
	}

	public static void main ( String [] args ) throws IOException{
		printRepeatedWords();
	}


}

