package interview_bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Anagrams {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		ArrayList <ArrayList<Integer>> result = new ArrayList <ArrayList<Integer>> ();

		HashMap < String, ArrayList<Integer>> map = new HashMap < String, ArrayList<Integer>> ();

		for ( int i = 0; i < A.size(); i++){
			// Sort letters.
			char [] letters = A.get(i).toCharArray();
			Arrays.sort ( letters );
			String sorted = new String ( letters );

			if ( map.containsKey (sorted ) )
				map.get ( sorted ).add ( i + 1 );
			else
				map.put ( sorted, new ArrayList<Integer> ( Arrays.asList ( i + 1 ) ) );
		}

		Iterator <String>  iter = map.keySet ().iterator ();
		while ( iter.hasNext () ){
			result.add ( map.get ( iter.next ()));
		}
		return result;      
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
