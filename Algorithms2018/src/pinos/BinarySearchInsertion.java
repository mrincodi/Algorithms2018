package pinos;

public class BinarySearchInsertion {

	void insert ( java.util.ArrayList <Integer> a, int [] b) {
		for (int num: b) {
			insert (a,num);
		}
	}

	void insert (java.util.ArrayList <Integer> a, int num) {
		if ( a.size() == 0) a.add(num);
		else insert (a,num,0,a.size()-1);
	}

	private void insert (java.util.ArrayList <Integer> a, int num, int inf, int sup) {
		if ( sup == inf) {
			if ( a.get(sup) < num)
				a.add(sup+1,num);
			else
				a.add(sup,num);
		}
		else {
			int midPos = ( sup + inf)/2;
			int midNum = a.get(midPos);
			if ( num < midNum) insert (a, num, inf, midPos);
			else insert (a, num, midPos+1, sup);
		}

	}
	public static void main(String[] args) {
		BinarySearchInsertion bsi = new BinarySearchInsertion (); 

		java.util.ArrayList <Integer> a = new java.util.ArrayList <Integer> ();
		int [] b = {2, 12, 5, 1, 17, 3, 13, 7, 10, 8, 9, 14, 20, 4, 6, 16, 11, 18, 19, 15};
		bsi.insert (a, b);
		System.out.println(a);

	}


}
