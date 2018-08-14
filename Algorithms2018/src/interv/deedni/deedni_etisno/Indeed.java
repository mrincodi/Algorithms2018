package interv.deedni.deedni_etisno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Indeed {

	HashMap < String, HashSet < String >> relations = new HashMap < String, HashSet < String >>();

	public void handleUserQuery(String user, String query) {

		// Initially, update the right relation hashmap.
		if ( !relations.containsKey ( user ) ){
			HashSet < String > set = new HashSet < String > ();
			set.add(query);
			relations.put(user, set);
		}
		else {
			relations.get(user).add(query);
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
						mostFrequentWordCount = Math.max(mostFrequentWordCount, relationCount.get(word));
					}
				}
			}
		}

		// Now, get the list of related words. TODO: This could have been taken from previous process.
		Iterator < String > relations = relationCount.keySet().iterator();

		ArrayList < String > result = new ArrayList <String>();

		while ( relations.hasNext()){
			String relationWord = relations.next();
			int quantity = relationCount.get(relationWord);
			if ( quantity ==  mostFrequentWordCount)
				result.add(relationWord);
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
    	
    	
    	
    }
	
	
	
}
