package topcoder;

import java.util.HashSet;

// http://community.topcoder.com/stat?c=problem_statement&pm=13922
// First approach. Too slow. Also, doesn't work.
// Second approach. I forgot of the method indexOf (important). It doesn't work
// with test AAABBAABB, BAABAAABAABAABBBAAAAAABBAABBBBBBBABB
public class ABBADiv1Wrong {

	final String SI = "Possible", NO = "Impossible";

	HashSet <String> out = new HashSet < String >();


	public String canObtain ( String initial, String target ){
		return canObtain1 (initial, target )?SI:NO;
	}

	public boolean canObtain1 ( String initial, String target ){

		if ( initial.length() > target.length()) return false;

		if ( initial.length() == target.length()){
			return initial.equals(target);
		}

		if ( out.contains(initial)) return false;

		// First, look for String.
		if ( in ( initial + "A", target ) ){
			// Good. An option is to add A at the end.
			boolean partial = canObtain1 ( initial + "A", target);
			if (partial ) return true;
		}

		// Now, look for reverse.
		String reverseB = reverse ( initial + "B");
		String reverseTarget = reverse ( target );

		if ( in (reverseB, target) || 
				in ( reverseB, reverseTarget) ){
			boolean partial = canObtain1 ( reverseB, target);
			if (partial ) return true;
		}
		
		out.add(initial);
		return false;		

	}

	private String reverse ( String s ){
		StringBuilder input1 = new StringBuilder();
		input1.append(s);
		input1 = input1.reverse();
		return input1.toString();
	}

//	private boolean in (String initial, String target) {
//		//Definitely there are faster ways to do this.
//		for ( int i = 0; i < target.length() - initial.length() + 1 ; i++){
//			if ( initial.substring(i, i + initial.length()).equals(initial))
//				return true;
//		}
//		return false;
//	}

	private boolean in (String initial, String target) {
		
		return target.indexOf(initial) != -1;
	}
	
	public static void main(String[] args) {
		String initial = "A";
		String target = "BABA";

		ABBADiv1Wrong abbadiv1 = new ABBADiv1Wrong();

		System.out.println (abbadiv1.canObtain(initial, target));

	}

}
