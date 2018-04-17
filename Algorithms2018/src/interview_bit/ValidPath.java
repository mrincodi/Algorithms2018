package interview_bit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

//https://www.interviewbit.com/problems/valid-path/
//God, this was tortuous.
//Note: I am only looking at up/down/left/right, not diagonals.
//Despite it, it worked.
// I could have used a matrix and mark the valid/invalid points, but I felt it
//was a waste of space.

public class ValidPath {

	public String solve(int maxX, int maxY, int N, int R, ArrayList<Integer> xCircles, ArrayList<Integer> yCircles) {
		String dest = maxX + "_" + maxY;
		Stack <String> s = new Stack <String>();
		HashSet <String> invalid = new HashSet <String> ();
		s.push ("0_0");
		if ( !isValid ("0_0", R, xCircles, yCircles, invalid)) return "NO";
		while ( ! s.isEmpty ()){
			String pos = s.pop();
			invalid.add(pos);

			if ( pos.equals(dest) ) return "YES";

			String [] parts = pos.split ("_");
			int x = Integer.parseInt (parts[0]);
			int y = Integer.parseInt (parts[1]);

			//Go "right" if possible.
			if ( x < maxX){
				int nextX = x+1;
				String pointToRight = nextX + "_" + y;
				if (isValid (pointToRight, R, xCircles, yCircles, invalid)){
					s.push (pointToRight);
				}
			}

			//Go "up" if possible.
			if ( y < maxY){
				int nextY = y+1;
				String pointToUp = x + "_" + nextY;
				if (isValid (pointToUp, R, xCircles, yCircles, invalid)){
					s.push (pointToUp);
				}
			}

			//Go "left" if possible.
			if ( x > 0 ){
				int nextX = x-1;
				String pointToLeft = nextX + "_" + y;
				if (isValid (pointToLeft, R, xCircles, yCircles, invalid)){
					s.push (pointToLeft);
				}
			}

			//Go "Down" if possible.
			if ( y > 0 ){
				int nextY = y-1;
				String pointToDown = x + "_" + nextY;
				if (isValid (pointToDown, R, xCircles, yCircles, invalid)){
					s.push (pointToDown);
				}
			}

		}
		return "NO";    
	}

	/**
	 * A point is invalid if it is inside a circle or if I have discovered
	 * I cannot get to the end from it.
	 */ 
	public boolean isValid (String point,int R,ArrayList<Integer> xCircles, ArrayList<Integer> yCircles, HashSet <String> invalid){
		if ( invalid.contains(point)) return false;
		String [] parts = point.split ("_");
		int x = Integer.parseInt (parts[0]);
		int y = Integer.parseInt (parts[1]);

		for ( int i = 0; i < xCircles.size(); i++){
			int thisCenterX = xCircles.get(i);
			int thisCenterY = yCircles.get(i);

			double dist = Math.sqrt ( Math.pow ( thisCenterX - x, 2 ) + Math.pow ( thisCenterY - y, 2 ));
			if ( dist <= (double) R){
				invalid.add (point);
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
