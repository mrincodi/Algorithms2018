package interview_bit;

// https://www.interviewbit.com/problems/edit-distance/
// So simple, yet so important!

public class EditDistance {

	public int minDistance(String A, String B) {

		if ( A.length () == 0 || B.length () == 0 ) 
			return Math.abs (A.length () - B.length () );

		int [] [] m = new int [ B.length() + 1 ][ A.length () + 1 ];

		char [] a = A.toCharArray();
		char [] b = B.toCharArray();
		
		// First row
		for ( int i = 0; i <= A.length(); i++){
			m[0][i]=i;
		}

		for ( int i = 0; i <= B.length(); i++){
			m[i][0]=i;
		}

		for ( int ib = 1; ib <= b.length; ib++){
			for ( int ia = 1; ia <= a.length; ia++){
				
				char ca = a[ia-1];
				char cb=b[ib-1];

				if ( ca==cb){
					m[ib][ia]=m[ib-1][ia-1];
				}
				else {
					// Inserting letter at the end.
					m[ib][ia]= Math.min( m[ib-1][ia]+1, m [ ib][ia-1]);
					m[ib][ia]= Math.min( m[ib][ia], m [ ib-1 ][ia-1] + 1);
				}
			}
		}
		return m[b.length][a.length];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
