package pinos;

public class Excel {
	public int titleToNumber(String A) {
		int sum = 0;
		for ( int i = 0; i < A.length(); i++){
			char c = A.charAt (A.length() - i - 1);

			int val = Character.getNumericValue(c) - 9;

			sum += val * (Math.pow (26,i));
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
