package pinos;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxRectangleInHistogram {

	/**
	 * I suppose that all the values of the histogram are non-negative integers.
	 * @param h
	 * @return
	 */
	int getMaxRectangleInHistogram (ArrayList <Integer> h){
		int area = 0;
		int maxArea = 0;
		h.add(0,0); //IMPORTANT: So the minimum value is 0. You can also simulate this logic.
		h.add(0);   //Just not to have to add more logic after the "for".
		java.util.Stack <Integer> s = new java.util.Stack <Integer> ();

		for ( int i = 0; i < h.size(); i++){
			int current = h.get(i);

			if ( s.isEmpty() || h.get(s.peek() ) <= current)
				s.push(i);
			else {
				int top = -1;
				do {
					top = s.pop();
					if ( !s.isEmpty())
						area = h.get(top)*(i-1-s.peek());
					else
						area = h.get(top)*(i-top);

					maxArea = Math.max(area, maxArea);
				}
				while (!s.isEmpty() && h.get(s.peek())>= current);
				s.push(i);
			}

		}
		return maxArea;
	}

	public static void main(String[] args) {
		ArrayList <Integer> list = new ArrayList <Integer> (Arrays.asList(0,2,1,3,1));
		int maxArea = new MaxRectangleInHistogram().getMaxRectangleInHistogram(list);
		System.out.println(maxArea);


	}

}
