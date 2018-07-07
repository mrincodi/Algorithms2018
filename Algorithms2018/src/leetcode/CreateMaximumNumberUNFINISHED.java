package leetcode;

// https://leetcode.com/problems/create-maximum-number/description/
// Interesting and difficult problem with lots of corner cases and
// a challenging way to represent data. I have the idea, but it's unfinished.
// Is there a better, cleaner, less verbose solution?
import java.util.HashMap;

public class CreateMaximumNumberUNFINISHED {

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int [] result = new int [ k ];

		String a = "";
		String b = "";

		for ( int d : nums1 ){
			a = a + d;
		}

		for ( int d : nums2 ){
			b = b + d;
		}

		String resultS = maxNumber ( a, b, 0, 0, k );

		if ( resultS == null || resultS.equals ( "" )) return result;

		// TODO: Fix below.
		int i = 0;
		for ( char c : resultS.toCharArray () ){
			result [ i++ ] = c - '0';
		}

		return result;
	}

	HashMap < String, String > map = new HashMap < String, String >  ();
	private String maxNumber(String nums1, String nums2, int pointer1, int pointer2, int k ){
		String s = pointer1 + "_" + pointer2 + "_" +  k;

		if ( map.containsKey ( s )) return map.get ( s );

		String result = new String() ;

		if ( k == 0 ) return "";

		if ( pointer1 == nums1.length () && pointer2 == nums2.length () ){
			result = null;
		}
		else if ( pointer1 == nums1.length () ){
			String result1 = maxNumber (nums1, nums2, pointer1, pointer2 + 1, k - 1);
			if ( result1 == null ) {
				result = null;
			}
			else {
				result1 = nums2.charAt(pointer2) + result1;
				String result2 = maxNumber (nums1, nums2, pointer1, pointer2 + 1, k);
				if ( result2 == null ) 
					result = result1;
				else
					result =  max ( result1, result2 );
			}
		}

		else if ( pointer2 == nums2.length ()){
			String result1 = maxNumber (nums1, nums2, pointer1 + 1, pointer2, k - 1);
			if ( result1 == null ) {
				result = null;
			}
			else {
				result1 = nums1.charAt(pointer1) + result1;

				String result2 = maxNumber (nums1, nums2, pointer1 + 1, pointer2, k);
				if ( result2 == null ) {
					result = result1;
				}
				else {
					result = max ( result1, result2 );
				}
			}
		}

		else {
			//Get the max. digit.
			char c1 = nums1.charAt ( pointer1 );
			char c2 = nums2.charAt ( pointer2 );

			if ( c1 == '9' ){ // Take it.
				result = maxNumber (nums1, nums2, pointer1 + 1, pointer2, k - 1);
				if ( result == null ) return null;
				else result = c1 + result;
			}
			else if ( c2 == '9' ){ // Take it.
				result = maxNumber (nums1, nums2, pointer1, pointer2 + 1, k - 1);
				if ( result == null ) return null;
				else result = c2 + result;
			}
			else {
				// Compare both values.
				if ( c1 > c2 ){
					//Either c1 should be taken here, or not, but not c2.
					String result1 =  maxNumber (nums1, nums2, pointer1 + 1, pointer2, k - 1);
					String result2 =  maxNumber (nums1, nums2, pointer1 + 1, pointer2, k );

					if ( result1 != null ) result = c1 + result1;
					
					result = max ( result1, result2 );
				}
				else {
					//Either c2 should be taken here, or not, but not c2.
					String result1 = maxNumber (nums1, nums2, pointer1, pointer2 + 1, k - 1);
					String result2 = maxNumber (nums1, nums2, pointer1, pointer2, k );
					if ( result1 != null ) result = c2 + result1;
					
					result = max ( result1, result2 );
				}
			}
		}

		map.put ( s, result );

		return result;
	}

	private String max ( String a, String b ){
		if ( a == null && b == null ) return null;
		if ( a == null ) return b;
		if ( b == null ) return a;

		long aa = a.equals("")?0:Long.parseLong ( a );
		long bb = b.equals("")?0:Long.parseLong ( b );

		return aa>bb?a:b;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int [] n1 = {3,4,6,5};
//		int [] n2 = { 9,1,2,5,8,3};
		int [] n1 = {2,3};
		int [] n2 = {4,5};
		int [] result = new CreateMaximumNumberUNFINISHED().maxNumber(n1, n2, 2); //5

		for ( int i = 0; i < result.length; i++){
			System.out.print(result [ i ]);
		}
	}

}
