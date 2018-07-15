package topcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ANewHopeUnfinished {


	int count(int[] firstWeek, int[] lastWeek, int D){
		int result = 0;
		HashSet < String > already = new HashSet < String > () ;

		// Check if first week is last week (we gotta do this, kids).
		boolean equal = true;
		for ( int i = 0; i < firstWeek.length; i++){
			if ( firstWeek[i] != lastWeek [ i ]){
				equal = false;
				break;
			}
		}
		if ( equal) return 0;

		String start = makeString (firstWeek);// TODO
		String end = makeString (lastWeek);// TODO

		Queue < String > q = new LinkedList < String > ();

		already.add(start);
		q.add(start);
		q.add(null);

		while ( !q.isEmpty()){
			String current = q.remove();

			if ( current != null ){

				// Make valid neighbors of this week.
				ArrayList < String > validNeighbors = makeValidNeighbors (current, already, D); // TODO
				for ( String s: validNeighbors){
					// If you get the end, just exit!
					if ( s.equals(end)) return result + 1;
					q.add(s);
					already.add(s);
				}
			}
			else {
				if ( !q.isEmpty()){	//It should never be empty for this problem.
					result++;
					q.add(null);
				}
			}
		}
		return result;
	}



	private ArrayList<String> makeValidNeighbors(String current, HashSet<String> already, int d) {
		// Make array of possible numbers.
		// My goodness, what a dance.
		ArrayList<String> result = new ArrayList<String> (); // Tengo miedo.

		String [] currentSplit = current.split("_");

		ArrayList < Integer > currentArray = new ArrayList < Integer > ();

		for ( int i = 0; i < currentSplit.length; i++){
			currentArray.add(Integer.parseInt(currentSplit[i]));
		}

		ArrayList < ArrayList < Integer > > possible = new ArrayList < ArrayList < Integer > >();

		for ( int i = 0; i < currentArray.size(); i++){
			ArrayList < Integer > theseNumbers = new ArrayList < Integer > ();
			for ( int j = 0; j < Math.min( currentArray.size(), currentArray.size() + i - d + 1); j++){
				theseNumbers.add(currentArray.get(j));
			}
			possible.add(theseNumbers);
		}

		// And now, with this information, generate the neighbors (uff...).


		ArrayList < ArrayList < Integer > > valid = combinations ( possible, 0 ); // TODO

		for ( ArrayList < Integer > numbers: valid){
			String s = makeString(numbers);
			if (!already.contains(s)){
				already.add(s);
				result.add(s);
			}
		}
		return null;
	}


	// TODO...
	private ArrayList<ArrayList<Integer>> combinations(ArrayList<ArrayList<Integer>> possible, int level) {
		//		if ( level ==)
		return null;
	}



	private String makeString(int[] array) {
		StringBuffer sb = new StringBuffer ();

		for ( int n: array){
			sb.append(n + "_");
		}
		sb.deleteCharAt(sb.length()-1);

		return sb.toString();
	}


	private String makeString(ArrayList < Integer> array) {
		StringBuffer sb = new StringBuffer ();

		for ( int n: array){
			sb.append(n + "_");
		}
		sb.deleteCharAt(sb.length()-1);

		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
