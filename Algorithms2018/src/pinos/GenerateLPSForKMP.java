package pinos;

public class GenerateLPSForKMP {


	public java.util.ArrayList <Integer> generateLPSForKMP (String p){
		java.util.ArrayList <Integer> result = new java.util.ArrayList <Integer> ();
		result.add(0);

		int j = 0;
		for ( int i = 1; i < p.length(); i++){
			if ( p.charAt(j) == p.charAt(i)){
				result.add(++j);
			}
			else{
				boolean found = false;
				while ( !found && j > 0) {
					j=result.get(j-1);
					if (p.charAt(j) == p.charAt(i)){
						result.add(j+1);
						j++;
						found = true;
					}
				}

				if ( j == 0) result.add(0);
			}
		}

		return result;
	}
	public static void main(String[] args) {
		String pattern = "abc";
		java.util.ArrayList <Integer> LPS = new GenerateLPSForKMP().generateLPSForKMP(pattern);
		System.out.println(LPS);
	}

}
