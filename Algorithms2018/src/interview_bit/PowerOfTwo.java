package interview_bit;

// https://www.interviewbit.com/problems/power-of-2/
// Not the most interesting problem I've ever made.
// 2018-07-22
public class PowerOfTwo {

	public int power(String s) {

		if ( s.equals ("1")) return 0;
		if ( s.equals ("2")) return 1;
		char c = s.charAt (s.length () - 1 );
		if ( c != '2' && c != '4' && c != '6' && c != '8') return 0;

		String t = new String ( "2" );

		boolean end = false;
		//int qq = 0;
		while (end == false){
			t = timesTwo (t);
			//qq++;
			int co =  compare (t, s );

			//System.out.println ("HOLAAAAA" + qq + " " + t + " and " + s + " and... " + co);

			if ( co == 0 ) return 1;
			if ( co == 1 ) return 0;
		}
		return 0;
	}

	String timesTwo (String s ){

		String result = "";

		int carry = 0;
		for ( int i = s.length () - 1; i >=0; i--){
			int d = s.charAt ( i ) - '0';
			int rr = 2*d + carry;
			int r = rr % 10 ;
			carry = rr / 10;
			result = r + result;
		}
		if ( carry != 0){
			result = carry + result;
		}

		return result;
	}

	private int compare ( String a, String b ){
		if ( a.length () < b.length ()) return -1;
		if ( a.length () > b.length () ) return 1;

		for ( int i = 0; i < a.length (); i++){
			int aa = a.charAt (i) - '0';
			int bb = b.charAt (i) - '0';

			if ( aa > bb ) return 1;
			if ( aa < bb ) return -1;

		}

		return 0;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
