package pinos;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/bulbs/
// 3 lines!!
public class BulbsInterviewBit {

    public int bulbs(ArrayList<Integer> a) {  
        int count = 0;
        for(int val : a) if(val == count % 2) count++;
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
