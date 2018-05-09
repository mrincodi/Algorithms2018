package leetcode;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
// I'm not sure if this can be done in a better way if nums [ start ] == nums [ end ]

public class FindMinimumInRotatedSortedArrayII {

	public int findMin(int[] nums) {
		return findMin (nums, 0, nums.length - 1);
	}

	public int findMin(int[] nums, int start, int end) {
		if ( start == end ) return nums [ end ] ; 
		if ( start == end - 1) return Math.min ( nums [ start ], nums [ end ]);

		if ( nums [ start ] < nums [ end ]) return nums [ start ];

		int mid = ( start + end )/ 2;

		if ( nums [ start ] == nums [ end ]){
			//Not too fast: the number could be in the middle.
//			if ( nums [ start ] < nums [ mid ] )
//				return findMin ( nums, start, mid);
//			else if ( nums [ start ] > nums [ mid] )
//				return findMin ( nums, mid, end );

			return Math.min ( findMin ( nums, start, mid ), findMin (nums, mid, end ));

		}

		if ( nums [ start ] > nums [ mid ]){
			return findMin (nums, start, mid);
		}

		if ( nums [ start ] == nums [ mid ]){
			if ( nums [ mid ] > nums [ end ])
				return findMin ( nums, mid, end);
			return nums [ start ];
		}

		// nums [ start ] < nums [ mid ], so:        
		if ( nums [ mid ] > nums [ end ])
			return findMin (nums, mid, end );

		return nums [ start ];
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArrayII fmirsa2 = new FindMinimumInRotatedSortedArrayII ();
		
		int [] nums = {1,2,2,2,0,1,1};
		
		int res = fmirsa2.findMin(nums);
		
		System.out.println(res);

	}

}
