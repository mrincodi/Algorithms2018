package pinos;

import java.util.List;

// https://www.interviewbit.com/problems/median-of-array/#

public class MedianOfArray2 {public class Solution {
	public double util(List<Integer> a, List<Integer> b,int imin, int imax)
	{
		int m = a.size();
		int n = b.size();

		while(imin<=imax)
		{
			int i = (imin + imax) / 2;
			// left heavy equation is used
			int j = ((m + n + 1) / 2) - i;
			if (j > 0 && i < m && b.get(j - 1) > a.get(i)) {
				imin = i + 1;
			} 
			else if (i > 0 && j < n && a.get(i - 1) > b.get(j)) {
				imax = i - 1;
			} 
			else {
				int med1 = 0, med2 = 0;
				// since left heavy equation is used, med1 for both m+n = even and odd arrays 
				// will lie on the left partition. So, we care about i and j hitting 0 as the corner case.
				// Otherwise, the best candididate from the left partition can be determined by
				// min(A[i-1], B[j-1]).
				if(i==0)
					med1=b.get(j-1);
				else if(j==0)
					med1 = a.get(i-1);
				else
					med1 = Math.max(a.get(i-1),b.get(j-1));
				// if m+n = odd, med1 will be the answer, so we return here.
				if((m+n)%2 == 1)
					return (double)med1;

				// if m+n = even, med2 will lie on the right partition. So, we care about
				// i and j hitting m and n respectively as the corner case. Otherwise,
				// the best candidate from the right partition is min(A[i], B[j])
				if(i==m)
					med2 = b.get(j);
				else if(j==n)
					med2 = a.get(i);
				else
					med2 = Math.min(a.get(i),b.get(j));

				// get the average of med1 and med2
				return (double)(med1+med2)/2.0;
			}
		}
		return -1;
	}

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		int m = a.size();
		int n = b.size();
		double ans = 0;
		if(m>n)
			ans = util(b,a,0,n);
		else
			ans = util(a,b,0,m); 

		return ans;  
	}
}


public static void main(String[] args) {
	// TODO Auto-generated method stub

}

}
