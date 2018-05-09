package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SomeCode {


	// Hello!
	// Question1: Write a function that will return an array of integers that occur exactly once in a given array of integers.

	// [1,1]
	public static ArrayList <Integer> returnSingles ( ArrayList <Integer> numbers ){

		ArrayList <Integer> result = new ArrayList <Integer> ();
		HashSet <Integer> already  = new HashSet <Integer> ();
		HashSet <Integer> repeated = new HashSet <Integer> ();

		for ( int number: numbers ){
			if ( already.contains (number))
				repeated.add(number);
			already.add(number);
		}

		for ( int i = 0; i < numbers.size(); i++){
			int number = numbers.get(i);
			if ( !repeated.contains (number))
				result.add(number);
		}

		return result;
	}
	//Complexity: O(n)


	/* This class will be given a list of words (such as might be tokenized
	 * from a paragraph of text), and will provide a method that takes two
	 * words and returns the shortest distance (in words) between those two
	 * words in the provided text.
	 * Example:
	 *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
	 *   assert(finder.distance("fox","the") == 3);
	 *   assert(finder.distance("quick", "fox") == 1);
	 *
	 * "quick" appears twice in the input. There are two possible distance values for "quick" and "fox":
	 *     (3 - 1) = 2 and (4 - 3) = 1.
	 * Since we have to return the shortest distance between the two words we return 1.
	 */
	public class WordDistanceFinder {
		HashMap <String, ArrayList <Integer>> dist = new HashMap <String, ArrayList <Integer>>();

		public WordDistanceFinder (List<String> words) {
			for ( int i = 0; i < words.size(); i++) {
				String word = words.get(i);

				if (!dist.containsKey(word))
					dist.put(word,new ArrayList<Integer>(Arrays.asList(i)));
				else
					dist.get(word).add(i);
			}
		}
		//    
		//    public int distance (String wordOne, String wordTwo) {
		//        
		//        if (!dist.contains (wordOne) || !dist.contains(wordTwo)) return -1;    //or throw exception.
		//        
		//        if ( wordOne.equals(wordTwo)) return 0;
		//        
		//        ArrayList <Integer>> positionsWordOne = dist.get(wordOne);
		//        ArrayList <Integer>> positionsWordTwo = dist.get(wordTwo);
		//        
		//        //Get smallest difference (this part can be done better, as values are sorted).  
		//        /*      
		//        int minDiff=Integer.MAX_VALUE;
		//        for ( int i = 0; i < positionsWordOne.size(); i++){
		//            inner:
		//            for ( int j = 0; j < positionsWordTwo.size(); j++){
		//            
		//                int pos1=positionsWordOne.get(i);
		//                int pos2=positionsWordTwo.get(j);
		//
		//                if (                 
		//                
		//                int diff = Math.abs(pos1-pos2);
		//                
		//                minDiff = Math.min(minDiff, diff);
		//                
		//                if ( pos2 > pos1 ) break inner;
		//            }
		//        }
		//        */
		//        
		//        //Another way:
		//        int i = 0;
		//        int j = 0;
		//        
		//        while ( i < positionsWordOne.size() ){
		//            while ( j < positionsWordTwo.size() ){
		//                int pos1=positionsWordOne.get(i);
		//                int pos2=positionsWordTwo.get(j);
		//
		//                int diff = pos1-pos2;
		//                int absDiff = Math.abs(diff);
		//                 minDiff = Math.min(minDiff, diff);
		//                
		//                if ( pos1 < pos2 ) j++;
		//                else i++;
		//            }
		//        }
		//        
		//        
		//        return minDiff;
		//        
		//        //A: 1 4 5
		//        //B: 3 7 
		//        
	}
}






