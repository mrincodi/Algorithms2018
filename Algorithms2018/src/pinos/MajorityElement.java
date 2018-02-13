package pinos;

import java.util.HashMap;
import java.util.List;

// https://www.interviewbit.com/problems/majority-element/
// Easy and all, but I started solving it as "just find the most frequent number"
// instead of making it stop once the count of a number gets to size()/2.

public class MajorityElement {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int majorityElement(final List<Integer> A) {

		HashMap <Integer, Integer> count = new HashMap <Integer, Integer>();

		if ( A.size() == 1 ) return A.get(0);

		int mid = A.size()/2;

		for (int i = 0; i < A.size();i++){
			int num = A.get(i);

			if ( !count.containsKey(num))
				count.put(num,1);
			else
				count.put(num,count.get(num)+1);

			if (count.get(num) > mid) return num;
		}

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
