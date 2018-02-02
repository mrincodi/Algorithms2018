package pinos;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
//Well, this was too short... :|
// It assumed all values were positive.

public class MaxSumWithoutAdjacentElementInterviewBit {
		public int adjacent(ArrayList<ArrayList<Integer>> a) {
		    if (a.isEmpty()) return 0;
		    if (a.get(0).isEmpty()) return 0;
		    int prec = 0;
		    int last = 0;
		    
		    for (int i = 0; i < a.get(0).size(); ++i) {
		        int total = Math.max(a.get(0).get(i), a.get(1).get(i)) + prec;
		        int res = Math.max(total, last);
		        
		        prec = last;
		        last = res;
		    }
		    
		    return Math.max(prec, last);
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
