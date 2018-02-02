package pinos;

import java.util.HashMap;

// https://www.interviewbit.com/problems/intersecting-chords-in-a-circle/
// InterviewBit's solution.
// It does not use a HashMap but an array.

public class IntersectingChordsInACircleInterviewBit {
	public int chordCnt(int A) {
		long[] dp = new long[A+1];
		dp[0]=1;
		int modulus = (int)Math.pow(10,9)+7;
		for(int i=2;i<=2*A;i=i+2)
		{
			for(int j=2;j<=i;j=j+2)
			{
				dp[i/2]+= (dp[(j-2)/2]*dp[(i-j)/2])%modulus;
			}
			dp[i/2]= dp[i/2]%modulus;
		}
		return (int)dp[A];
	}



	public static void main(String[] args) {
		int q = new IntersectingChordsInACircle().chordCnt(65);
		System.out.println(q);
	}

}
