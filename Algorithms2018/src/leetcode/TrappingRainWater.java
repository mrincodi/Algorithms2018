package leetcode;

// https://leetcode.com/problems/trapping-rain-water/description/
// ? I didn't think this was difficult. Am I missing something?
// 2018-07-20
public class TrappingRainWater {

	public int trap(int[] height) {
		int result = 0;
		// First, calculate the maximum height.
		int max = 0;
		for ( int n: height){
			max = Math.max ( max, n );
		}

		for ( int i = 0; i < max; i++ ){
			result += getWater ( i, height );
		}
		return result;
	}

	public int getWater ( int level, int [] height ){
		int result = 0;

		// First locate the initial point.
		int start = 0;
		while ( height[start] <= level && start < height.length ) start++;

		int end = height.length - 1;
		while ( height[end] <=  level && end >= 0  ) end--;

		if ( start >= end ) return 0;

		for ( int i = start + 1; i < end ; i++ ){
			if ( height[i] <= level ){ // Count this section.
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
