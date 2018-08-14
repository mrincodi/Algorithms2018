package leetcode;

// https://leetcode.com/problems/container-with-most-water/description/
// I doubt this is the optimal solution, but it passes.
// 2018-07-20
public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int max = 0;
		for ( int i = 1; i < height.length; i++ ){
			for ( int j = 0; j < i; j++ ){
				max = Math.max (max, Math.min (height [ i ], height [ j ])* (i - j));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
