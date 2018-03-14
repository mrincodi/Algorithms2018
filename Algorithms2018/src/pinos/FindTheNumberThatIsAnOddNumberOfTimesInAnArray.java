package pinos;

public class FindTheNumberThatIsAnOddNumberOfTimesInAnArray {
	int findIt (int [] array) {
		int res = 0;
		for ( int num:array) res = num ^ res;
		return res;
	}
	
	public static void main(String[] args) {
		int [] array = { 1, 7, 4, 7, 6, 4, 4 ,4, 6, 6, 1023, 7,6,6,7,6,7, 1 , 6, 7, 6};
		
		System.out.println(new FindTheNumberThatIsAnOddNumberOfTimesInAnArray().findIt(array));

	}

}
