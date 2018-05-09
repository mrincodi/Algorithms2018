package leetcode;

// https://leetcode.com/problems/open-the-lock/description/
// Beautiful and elementary exercise on graphs.

public class OpenTheLock {

	public int openLock(String[] deadends, String target) {
		String NEXT_LEVEL = "-1";
		java.util.HashSet <String> set = new java.util.HashSet <String>();

		String init = "0000";
		
		for ( String s: deadends){
			set.add (s);
			if (s.equals(init)) return -1;
		}

		java.util.Queue <String> q = new java.util.LinkedList <String>();

		q.add (init);
		q.add (NEXT_LEVEL);
		set.add(init);
		int numSteps = 0;

		while (! q.isEmpty ()){
			String pos = q.remove ();
			
			if ( pos.equals(target)) return numSteps;

			if ( pos.equals (NEXT_LEVEL)){
				if ( q.isEmpty()) 
					return -1;
				q.add(NEXT_LEVEL);
				numSteps++;
			}
			else {
				java.util.ArrayList <String> neighbors = getValidNeighbors (pos, set);

				for ( String neighbor: neighbors){
					set.add(neighbor);
					q.add(neighbor);
				}
			}
		}
		return -1;    
	}

	java.util.ArrayList <String> getValidNeighbors (String pos, java.util.HashSet <String> set){
		java.util.ArrayList <String> result = new java.util.ArrayList <String> ();

		for ( int i = 0; i < pos.length(); i++ ){
			String prevS = pos.substring (0,i);
			String postS = pos.substring (i+1,pos.length());

			char c = pos.charAt (i);
			char cPlus1 =  c == '9' ? '0':(char)(c+1);
			char cMinus1 = c == '0' ? '9':(char)(c-1);

			StringBuilder sb = new StringBuilder ();
			sb.append (prevS);
			sb.append (cPlus1);
			sb.append (postS);

			String neighbor = sb.toString();
			if ( !set.contains (neighbor)){
				result.add(neighbor);
			}

			sb = new StringBuilder ();
			sb.append (prevS);
			sb.append (cMinus1);
			sb.append (postS);

			neighbor = sb.toString();
			if ( !set.contains (neighbor)){
				result.add(neighbor);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		OpenTheLock otl = new OpenTheLock();
		String [] deadends = { "8887","8889","8878","8898","8788","8988","7888","9888"};
		String target = "8888";
		
		int res = otl.openLock(deadends, target);
		
		System.out.println( res);
	}

}
