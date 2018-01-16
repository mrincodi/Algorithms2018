package pinos;

//https://www.interviewbit.com/problems/modular-expression/
//I don't know why this doesn't work. It says:
/*
 * Your submission failed for the following input:
A : 71045970
B : 41535484
C : 64735492
Your function returned the following :
34431948
The expected returned value :
20805472
 */
/* OK, the reason why it was failing was because:
 * Line 35 was wrong, and I wasn't using long.
 */

public class ModularExpressionNotOk {

	public int Mod(int A, int B, int C) {
		int result = 0;

		if ( B == 0 ){
			if ( A != 0 )
				return 1;
			return 0;
		}

		if ( B%2 == 0){
			int val = Mod (A, B/2,C);
			result = (val * val) % C;
		}
		else
			result = ((A % C) * Mod (A, B-1, C)) % C; // This was wrong: it was missing the %C.


		return (int)((C + result) % C);

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
