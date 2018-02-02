package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://www.interviewbit.com/problems/tushars-birthday-bombs/
// Non-recursive solution.

public class TusharsBirthdayBombsInterviewBit {

	
	public class Solution {
	    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		int minE = B.get(0);
		for (int i = 0; i < B.size(); i++) {
			minE = Math.min(minE, B.get(i));
		}
		int maxKicks = A / minE;

		ArrayList<Integer> ans = new ArrayList<Integer>();
		int idx = 0;
		while (idx < B.size() && A > 0) {
			if (A - B.get(idx) < 0) {
				idx++;
				continue;
			}
			if (1 + ans.size() + (A - B.get(idx)) / minE < maxKicks) {
	idx++;
	continue;
	}
			ans.add(idx);
			A = A - B.get(idx);
		}

		return ans;
	    }
	}

	public static void main(String[] args) {
		ArrayList <Integer> S = new ArrayList <Integer> (Arrays.asList(8, 8, 6, 5, 4));
		ArrayList <Integer> result = new TusharsBirthdayBombsSuboptimal().solve(10, S);
		System.out.println(result);


	}

}
