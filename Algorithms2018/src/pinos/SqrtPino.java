package pinos;

public class SqrtPino {

	//For now, thinking n > 1.
	public double mySqrt (double n, double error ){

		double upper = n;
		double lower = 1;
		double middle = n/2;
		
		int k = (int) (Math.log(n/error)/Math.log(2));

		for ( int i = 0; i < k; i++){
			middle = (upper + lower)/2;
			if ( middle*middle == n ) return middle;
			if (middle*middle >n) {
				if ( n > 1) upper= middle; else lower = middle;
			}
			else {
				if ( n > 1) lower = middle; else upper = middle;
			}
		}

		return middle;
	}
	public static void main(String[] args) {
		double aVer = new SqrtPino().mySqrt(2, 0.00001);
		System.out.println(aVer);

	}

}
