package pinos;

//https://www.interviewbit.com/problems/ways-to-decode/
// A failed attempt. Somewhat difficult problem that looks easy.

public class WayToDecodeFailed {

	/*
	 * 
	 * 
	 * 
	 * public class Solution {
    public int numDecodings(String A) {

        if (A.length()==0 ) return 0;

        int [] v = new int [ A.length()];

        // First char.
        if ( Integer.parseInt (A.substring (0,1)) == 0 ) return 0;

        v[0] = 1;

        if ( A.length() == 1) return 1;

        //Second char.
        int secondDigit = Integer.parseInt (A.substring (1,2));
        int firstTwoDigits = Integer.parseInt (A.substring (0,2));

        if ( secondDigit == 0 ){ // 1 0 ?
            if ( A.length() > 2 && Integer.parseInt (A.substring (2,3)) == 0 ) return 0;

            if ( firstTwoDigits > 26 ) return 0; // Remeber that first digit is not 0.
            else v[1] = 1;
        }
        else { //1 2 ?
            if ( A.length() > 2 && Integer.parseInt (A.substring (2,3)) == 0 ) return 0;

            if (firstTwoDigits <= 26 ) v[1] = 2;
            else v[1]=1;
        }











        //Rest
        for ( int i = 2; i < A.length(); i++){

            int thisDigit = Integer.parseInt (A.substring (i,i+1));
            int prevAndThisDigit = Integer.parseInt (A.substring (i-1,i+1));
            if ( thisDigit == 0 ){
                if ( prevAndThisDigit == 0 ) return 0; 
                if ( prevAndThisDigit <= 26 ) v[i] = v[i-1];  // 10 or 20.
                else return 0;
            }
            else {
                if ( prevAndThisDigit > 9 && prevAndThisDigit <= 26 ) v[i] = v[i-1]+v[i-2];
                else v[i]=v[i-1];
            }
        }

        return v [ A.length() - 1];

    }
}

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
