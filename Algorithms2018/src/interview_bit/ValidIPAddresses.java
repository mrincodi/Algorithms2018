package interview_bit;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/valid-ip-addresses/
// Another annoying, yet important, exercise.

public class ValidIPAddresses {

	public ArrayList<String> restoreIpAddresses(String A) {

		return restoreIpAddresses ( A, 4 );
	}

	private ArrayList<String> restoreIpAddresses(String A, int left) {
		ArrayList<String> result = new ArrayList<String>();

		if ( A == null || A.length() < left ) return result;

		if ( left == 1){

			if ( A.equals ("0") ) {
				result.add (A);
				return result;
			}

			if ( A.charAt (0) == '0'  ) return result;

			int num = Integer.parseInt (A);
			if ( num <= 255 )
				result.add (A);

			return result;
		}

		//Try with first character.
		String firstNumber = A.substring(0,1);
		ArrayList<String> partialResult1 = restoreIpAddresses ( A.substring (1), left - 1 );

		for ( String part: partialResult1 )  {
			result.add ( firstNumber + "." + part);
		}

		if ( A.charAt(0) != '0' ){
			if ( A.length() >=2 ){
				String secondNumber = A.substring (0,2);
				ArrayList<String> partialResult2 = restoreIpAddresses ( A.substring (2), left - 1 );

				for ( String part: partialResult2 )  {
					result.add ( secondNumber + "." + part);
				}
			}

			if (A.length () >= 3){

				String ThirdNumber = A.substring (0,3);
				if ( Integer.parseInt ( ThirdNumber ) <= 255 ){
					ArrayList<String> partialResult3 = restoreIpAddresses ( A.substring (3), left - 1 );

					for ( String part: partialResult3 )  {
						result.add ( ThirdNumber + "." + part);
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
