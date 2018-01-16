package pinos;

import java.util.List;

// https://www.interviewbit.com/problems/largest-number/
// this works but takes too long, supposedly.
// The reasons are:
// - That I was adding Strings instead of using a StringBuffer <- This was definitely a reason.
// - That I am receiving integers and then doing String.valueOf inside the compare. Instead, compare Strings.

public class LargestNumber {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public String largestNumber(final List<Integer> A) {
		java.util.ArrayList <String > sA = new java.util.ArrayList <String >();
		for (Integer val : A){
			sA.add(String.valueOf(val));
		}
		java.util.Collections.sort (sA, new newComparator());

		if (sA.get(0).equals("0")) return "0";
		
		StringBuffer strBuf = new StringBuffer();
		for ( String val : sA){
			strBuf.append(val);
		}

		return strBuf.toString();

	}

	public static void main(String[] args) {
		java.util.ArrayList <Integer> numeros = new java.util.ArrayList < Integer> ( java.util.Arrays.asList(3, 30, 34, 5, 9));
		System.out.println(new LargestNumber().largestNumber(numeros));
	}
}

class newComparator implements java.util.Comparator <String>{
	public int compare (String a, String b){
		String aS = String.valueOf (a);
		String bS = String.valueOf (b);

		String cS1 = bS + aS;
		String cS2 = aS + bS;

		return cS1.compareTo(cS2 );

//		for ( int i = 0; i < cS1.length(); i++){
//			if (cS1.charAt(i) < cS2.charAt(i)) return 1;
//			if (cS1.charAt(i) > cS2.charAt(i)) return -1;
//		}
//		return 0;
	}
}



