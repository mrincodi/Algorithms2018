package pinos;

public class KMP {

	public java.util.ArrayList <Integer> do_KMP (String string, String pattern){
		java.util.ArrayList <Integer>  result = new java.util.ArrayList <Integer> ();
		
		if ( pattern.length() > string.length()) return result;

		java.util.ArrayList <Integer> LPS = new GenerateLPSForKMP().generateLPSForKMP(pattern);
		
		int j = 0;
		for ( int i = 0; i < string.length() ; ){

			if ( string.charAt(i) != pattern.charAt(j)){
				boolean found = false;
				while ( !found && j > 0 ){
					j = LPS.get(j-1);
					if (string.charAt(i) == pattern.charAt(j)){
						found = true;
						j++;
					}
				}
				i++;
			}
			else {
				j++;
				if (j == pattern.length()){
					result.add( i - pattern.length() + 1);
					if ( pattern.length() == 1) {
						j = 0; i++;	// Special case when looking for a single character.
					}
					else 
						j = LPS.get(j-2);
				}
				else i++;

			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		String  s = "bb";
		String p = "b";
		
		java.util.ArrayList <Integer> result = new KMP().do_KMP(s, p);
		System.out.println(result);
	}

}
