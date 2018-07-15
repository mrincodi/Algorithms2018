package careercup;


// https://www.careercup.com/question?id=5242973380935680
// A little caveat: the first number is always positive, 
// so you can't subtract it. You need to start your 
// recursion from the element in index 1, looking for ans - arr[0].
// OJO with the sign (un)check at the end of the recursion. Hmmm...
public class MagicNumber {

	public boolean canIGet ( int number, int [] array ){
		if ( array.length == 0) return number == 0;
		if ( array.length == 1) return number == array [ 0 ];
		return canIGet (  number - array [ 0 ], array, 1 );
		
	}
	
	
	private boolean canIGet(int number, int[] array, int pos) {
		if ( pos >= array.length - 1){
			return number == array [ pos ] || number == -array[ pos ];
		}
		
		boolean adding = canIGet ( number - array [ pos ], array, pos + 1);
		if ( adding ) return true;
		
		boolean subtracting = canIGet ( number + array [ pos ], array, pos + 1);
		if ( subtracting ) return true;
		
		return false;
	}


	public static void main(String[] args) {
		int [] array = { 1,17,4};
		
		boolean val = new MagicNumber().canIGet(-12, array);
		
		System.out.println ( val );

	}

}
