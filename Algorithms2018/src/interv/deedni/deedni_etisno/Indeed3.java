package interv.deedni.deedni_etisno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Pair {
	String word;
	int value;

}
public class Indeed3 {

	HashMap < String, HashSet < String >> relations = new HashMap < String, HashSet < String >>();
	HashMap < String, HashMap < String, Integer>> solutions = new HashMap < String, HashMap < String, Integer>>  ();


	public void handleUserQuery(String user, String query) {
		ArrayList < String > result = new ArrayList <String>();

		// Initially, update the right relation hashmap.
		if ( !relations.containsKey ( user ) ){
			HashSet < String > set = new HashSet < String > ();
			set.add(query);
			relations.put(user, set);
		}
		else {
			relations.get(user).add(query);
		}

		// Now, update solutions.
		if ( !solutions.containsKey(query)){
			solutions.put (query, new HashMap < String, Integer>());
			for ( String word: relations.get(user)){
				if ( !word.equals(query)){
					solutions.get(query).put(word, 1);
				}
			}
			System.out.println ("0");
			return;
		}
		else {
			// Go over the related words and find the most frequent one.
			int mostCount = 0;
			Iterator < String > iter = solutions.get(query).keySet().iterator();
			while ( iter.hasNext()){
				String word = iter.next(); 
				int thisCount = solutions.get(query).get(word);
				if ( thisCount > mostCount){
					mostCount = thisCount;
					result =  new ArrayList <String>();
					result.add(word);
				}
				else if ( thisCount == mostCount){
					result.add(word);
				}

				// In any case, update all the lists.
				solutions.get(word).put(query, solutions.get(word).get(query) + 1);
			}

			//Now, update all the lists.
		}











		//Now, go over the hashsets, and start counting how many of them have that query already.

		Iterator < String > iter = relations.keySet().iterator();

		HashMap <String, Integer > relationCount = new HashMap <String, Integer > ();
		int mostFrequentWordCount = 0;


		while ( iter.hasNext() ){
			String userLookUp = iter.next();

			HashSet < String > set = relations.get(userLookUp);

			if ( ! userLookUp.equals(user) && set.contains(query)){
				//Go over the other words in that hashSet, and fill out relationCount accordingly.

				Iterator < String > otherRelations = set.iterator();

				while (otherRelations.hasNext()){
					String word = otherRelations.next();
					if ( !word.equals(query)){
						relationCount.put(word, relationCount.getOrDefault(word, 0) + 1);

						// Compare this number with the current mostFrequentWordCount;
						int thisFreq = relationCount.get(word);
						if ( thisFreq == mostFrequentWordCount){
							result.add(word);
						}
						else if ( thisFreq > mostFrequentWordCount){
							result = new ArrayList < String > ();
							result.add(word);
							mostFrequentWordCount = thisFreq;
						}
					}
				}
			}
		}

		Collections.sort(result );
		result.add(0, String.valueOf(mostFrequentWordCount));

		//Finally, print.
		for ( int i = 0; i < result.size() - 1; i++){
			System.out.print(result.get(i));
			System.out.print(" ");
		}
		System.out.println(result.get(result.size() - 1));
	}

	public static void main(String args[] ) throws Exception {
		//        Scanner input = new Scanner(System.in);
		//        int numberOfLines = Integer.parseInt(input.nextLine());
		//        Indeed solution = new Indeed();
		//        for (int i = 0; i < numberOfLines; i++) {
		//            String user = input.next();
		//            String query = input.next();
		//            solution.handleUserQuery(user, query);
		//        }

		// 7
		Indeed2 sera =  new Indeed2();

		sera.handleUserQuery ("A", "java");
		sera.handleUserQuery ("B", "python");
		sera.handleUserQuery ("B", "java");
		sera.handleUserQuery ("B", "go");
		sera.handleUserQuery ("C", "java");
		sera.handleUserQuery ("A", "python");

		sera.handleUserQuery ("C", "python");
		sera.handleUserQuery ("D", "python");



		//    	sera.handleUserQuery ("A", "java");
		//    	sera.handleUserQuery ("B", "python");
		//    	sera.handleUserQuery ("B", "java");
		//    	sera.handleUserQuery ("A", "software_engineer");
		//    	sera.handleUserQuery ("C", "truck_driver");
		//    	sera.handleUserQuery ("B", "software_engineer");
		//    	sera.handleUserQuery ("A", "python");

	}



}
