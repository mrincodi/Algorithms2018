package leetcode;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/non-overlapping-intervals/description/
// TODO: This was taken from the Internet. I need to understand why it works.
public class NonOverlappingIntervals {


/** 
 * Definition for an interval. 
 * public class Interval { 
 *     int start; 
 *     int end; 
 *     Interval() { start = 0; end = 0; } 
 *     Interval(int s, int e) { start = s; end = e; } 
 * } 
 */    
    public int eraseOverlapIntervals(Interval[] intervals) {  
        if (intervals.length < 1) {  
            return 0;  
        }  
        Arrays.sort(intervals, new Comparator<Interval>() {  
            @Override  
            public int compare(Interval o1, Interval o2) {  
                if (o1.end == o2.end) {  
                    return o1.start - o2.start;  
                } else {  
                    return o1.end - o2.end;  
                }  
            }  
        });  
        int nInsert = 1;  
        int nLastEnd = intervals[0].end;  
        for (Interval interval : intervals) {  
            if (interval.start >= nLastEnd) {  
                nLastEnd = interval.end;  
                nInsert++;  
            }  
        }  
        return intervals.length - nInsert;  
    }  

	public static void main(String[] args) {
		NonOverlappingIntervals nai = new NonOverlappingIntervals();
		Interval interval3 = new Interval (1,3);
		Interval interval2 = new Interval (7,10);
		Interval interval1 = new Interval (4,5);
		Interval interval4 = new Interval (2,8);
		
		Interval[] intervals = { interval1, interval2, interval3, interval4 };
		
		int sol = nai.eraseOverlapIntervals(intervals);
		System.out.println(sol);
	}

}
