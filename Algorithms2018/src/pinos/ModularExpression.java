package pinos;

//https://www.interviewbit.com/problems/modular-expression/
public class ModularExpression {
	public int Mod(int A, int B, int C) {

		if ( B == 0 ){
			if ( A != 0 )
				return 1;
			return 0;
		}

        long val;
		if ( B%2 == 0){
		    val = Mod (A, B/2,C);
			val = (val * val) % C;
		}
		else{
		    val = A % C;
			val = (val * Mod (A, B-1, C)) % C;
		}


		return (int)((C + val)%C);

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
