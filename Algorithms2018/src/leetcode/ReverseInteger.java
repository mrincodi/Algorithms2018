package leetcode;

// https://leetcode.com/problems/reverse-integer/description/
// This should be possible to do without long.
// I am not sure of the behavior of negative modulo.
public class ReverseInteger {

	public int reverse(int x) {
		long xl = (long) x;
		//Negative?
		boolean negative = x < 0;

		long limit = (long) Math.pow (2,31);
		if (negative) limit = limit - 1;

		xl = Math.abs (xl);

		long result = 0;

		while ( xl > 0){
			long digit = xl % 10L;
			xl = xl / 10L;

			result = result * 10L + digit;

			if ( result > limit) return 0;
		}

		if (negative) result = -result;

		return (int) result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
