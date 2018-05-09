package leetcode;

// https://leetcode.com/problems/reverse-integer/description/
// The proper way (in Java 8).
public class ReverseInteger2 {

	public int reverse(int x) {
		int result = 0;		

		try { 
			while (x != 0){
				int digit = x % 10;
				x = x / 10;

				result = Math.multiplyExact (result, 10);
				result = Math.addExact(result, digit);
				//System.out.println(result);
			}
		} 
		catch ( java.lang.ArithmeticException jlae){
			return 0;
		}

		return result;
	}

	public static void main(String[] args) {
		int n = 1534236469;
		System.out.println( new ReverseInteger2().reverse (n));

	}

}
