package basic_data_structures;

public class BestCommonSubsequence {

	public int bestCommonSubsequenceLength ( String a, String b){

		int [][] m = new int [a.length() + 1][b.length() + 1];

		for ( int i = 0; i < a.length (); i++){


			for ( int j = 0; j < b.length (); j++){
				int posA = i + 1;
				int posB = j + 1;
				
				if (a.charAt(i) == b.charAt(j)){
					m[posA][posB] = m[posA - 1][posB - 1] + 1;
				}
				else{
					m[posA][posB] = Math.max(m[posA][posB - 1], m[posA-1][posB]);
				}
			}
		}

		return m[a.length()][b.length()];
	}
	/**
	 * To be honest, once you have bestCommonSubsequenceString you don't really need
	 * bestCommonSubsequenceLength (unless you're like super interested in saving
	 * memory space.
	 * @param a
	 * @param b
	 * @return
	 */
	public String bestCommonSubsequenceString ( String a, String b){

		String [][] m = new String [a.length() + 1][b.length() + 1];
		for ( int i = 0; i <= a.length(); i++){
			m[i][0]="";
		}

		for ( int i = 0; i <= b.length(); i++){
			m[0][i]="";
		}
		
		for ( int i = 0; i < a.length (); i++){


			for ( int j = 0; j < b.length (); j++){
				int posA = i + 1;
				int posB = j + 1;
				
				if (a.charAt(i) == b.charAt(j)){
					m[posA][posB] = m[posA - 1][posB - 1] + a.charAt(i);
				}
				else{
					String q1 = m[posA][posB - 1];
					String q2 = m[posA - 1][posB];
					
					if ( q1.length() >= q2.length())
						m[posA][posB] = q1;
					else
						m[posA][posB] = q2;
				}
			}
		}

		return m[a.length()][b.length()];
	}
	
	public static void main(String[] args) {
		String a = "mdfaraamaixxopqma";
		String b = "zzmxxarrillo";
		
		a = "Muchos años después, frente al pelotón de fusilamiento, el coronel Aureliano Buendía había de recordar aquella tarde remota en que su padre lo llevó a conocer el hielo";
		b = "Macondo era entonces una aldea de 20 casas de barro y cañabrava construidas a la orilla de un río de aguas diáfanas que se precipitaban por un lecho de piedras pulidas, blancas y enormes como huevos prehistóricos.";
		
		//int bcs = new BestCommonSubsequence().bestCommonSubsequenceLength(a, b);
		String bcsS = new BestCommonSubsequence().bestCommonSubsequenceString(a, b);
		
		System.out.println(bcsS);
	}

}
