package leetcode;

import java.util.HashMap;
import java.util.HashSet;

//https://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
//This solutions fails for the case [[0,0],[94911151,94911150],[94911152,94911151]]
//Also, this can be made with less code, and without taking into account the "b" point.
//the trick is to re-create the hash for every starting point.
//See https://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
public class MaxPointOnALine {
	/**
	 * Definition for a point.
	 * class Point {
	 *     int x;
	 *     int y;
	 *     Point() { x = 0; y = 0; }
	 *     Point(int a, int b) { x = a; y = b; }
	 * }
	 */
	public int maxPoints(Point[] points) {
		if ( points.length <= 2) return points.length;

		HashMap <String, Integer> howMany = new HashMap <String, Integer> ();

		for ( Point p: points){
			String pS = p.x +"_" + p.y;
			howMany.put(pS, howMany.getOrDefault(pS,0)+1);
		}

		HashMap <String, HashSet<String>> pointsMap = new HashMap <String, HashSet<String>> ();
		int result = 0;

		for ( int i = 0; i < points.length - 1; i++){
			for ( int j = i + 1; j < points.length; j++){
				Point p1 = points [ i ];
				Point p2 = points [ j ];

				String key = "";
				if ( p1.x == p2.x ) {
					key = "INF_" + p1.x;
				}
				else {
					double m = (double)((double)( p2.y - p1.y)/(double)(p2.x - p1.x));
					double b = (double)((double)p2.y - m*(double)p2.x);
					key = m + "_" + b;
				}

				String p1S = p1.x + "_" + p1.y;
				String p2S = p2.x + "_" + p2.y;

				if ( !pointsMap.containsKey(key)){
					pointsMap.put(key,new HashSet<String>());
				}
				pointsMap.get(key).add(p1S);
				pointsMap.get(key).add(p2S);     

				result = Math.max ( result, countHowMany (pointsMap.get(key), howMany));
			}
		}

		return result;        
	}

	int countHowMany ( HashSet<String> pointsS, HashMap <String, Integer> howMany){
		int result = 0;
		for ( String pS: pointsS){
			result+=howMany.get(pS);
		}
		return result;
	}
	public static void main(String[] args) {
		Point [] points = new Point [ 3 ];
		points [ 0 ] = new Point (0,0);
		points [ 1 ] = new Point (94911151,94911150);
		points [ 2 ] = new Point (94911152,94911151);

		System.out.println(new MaxPointOnALine().maxPoints(points));
	}

}
