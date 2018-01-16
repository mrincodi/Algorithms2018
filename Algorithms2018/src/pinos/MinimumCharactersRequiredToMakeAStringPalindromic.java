package pinos;

public class MinimumCharactersRequiredToMakeAStringPalindromic {



	public int solve(String A) {
		StringBuffer sb = new StringBuffer();
		sb.append (A);
		sb.append("$");
		for ( int i = A.length() -1; i >= 0; i-- ){
			sb.append (A.charAt(i));
		}

		java.util.ArrayList < Integer > lps = generateLPS (sb.toString());

		return (A.length () - lps.get(lps.size()-1));        

	}

	java.util.ArrayList < Integer > generateLPS (String s ){
		java.util.ArrayList < Integer > result = new java.util.ArrayList < Integer > ();
		result.add(0);
		int i = 1, j = 0;
		while ( i < s.length() ){
			if ( s.charAt (i) == s.charAt(j)){
				result.add(++j);
				i++;
			}
			else {
				if ( j > 0 ){
					j = result.get(j-1);
				}
				else{
					result.add(0);
					i++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "aaabaa";
		System.out.println(new MinimumCharactersRequiredToMakeAStringPalindromic().solve(s));

	}

}
