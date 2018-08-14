package leetcode;



// Java O(n) solution for 
// finding smallest subarray 
// with sum greater than x

class GFG 
{

	// Returns length of smallest
	// subarray with sum greater 
	// than x. If there is no 
	// subarray with given sum, 
	// then returns n+1
	static int smallestSubWithSum(int arr[], 
			int n, int x)
	{
		// Initialize current 
		// sum and minimum length
		int curr_sum = 0, min_len = n + 1;

		// Initialize starting
		// and ending indexes
		int start = 0, end = 0;
		while (end < n)
		{
			// Keep adding array 
			// elements while current 
			// sum is smaller than x
			while (curr_sum <= x && end < n)
			{
				// Ignore subarrays with 
				// negative sum if x is
				// positive.
				if (curr_sum <= 0 && x > 0)
				{
					start = end;
					curr_sum = 0;
				}

				curr_sum += arr[end++];
			}

			// If current sum becomes 
			// greater than x.
			while (curr_sum > x && start < n)
			{
				// Update minimum
				// length if needed
				if (end - start < min_len)
					min_len = end - start;

				// remove starting elements
				curr_sum -= arr[start++];
			}
		}
		return min_len;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6};
		int n = 151;
		
		int r = smallestSubWithSum(array, array.length, n);
		System.out.println(r);
	}

}
