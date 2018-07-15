package interv.g;

import java.util.ArrayList;
import java.util.List;

// Author: Mario R. Rincon
// 2018-07-13

public class Interview {

	/**
	 * Solution.
	 * Time complexity: O(S+K) (number of shards plus number of keys).
	 * Space complexity: O(1) as I am not creating new structures.
	 * 
	 * Description:
	 * Have a pointer for shards and another one for keys.
	 * For each shard, move the key pointer until we are sure
	 * that no other key is inside this shard,
	 * and increase ranges accordingly.
	 * 
	 * @param shards Shards
	 * @param keys Keys
	 * @return Ranges Ranges
	 */
	public List<Range> getRanges(List<Shard> shards, List<Key> keys){
		
		List<Range> result = new ArrayList < Range > ();

		int shardPointer = 0, keyPointer = 0;

		if ( shards.size() == 0 || keys.size() == 0 ) return result;
		
		// Have a pointer for the shards and another one for the keys.
		// For each shard, evaluate the keys inside the shard.
		// Increase the key pointer as long as the current key doesn't
		// go beyond the current shard.
		
		for ( shardPointer = 0; shardPointer < shards.size(); shardPointer++){
			Shard currentShard = shards.get(shardPointer);
			Key currentKey = keys.get ( keyPointer);
			Range currentRange = null;
		
			while ( keyPointer < keys.size() && currentKey.start <= currentShard.end ){
			
				// Ignore keys that are totally before the shard.
				if ( currentKey.end < currentShard.start ){ 
					keyPointer++;
					if (keyPointer < keys.size()) currentKey = keys.get ( keyPointer);
				}
				else { // For key groups that intersect the shard:
					
					// if I haven't created a range, do so, and initialize the start field.
					if ( currentRange == null ){ 
						currentRange = new Range ();
						currentRange.start = Math.max(currentShard.start, currentKey.start);
					}
					// Always update the end field.
					currentRange.end = Math.min(currentShard.end, currentKey.end);

					// If this key group is totally inside the shard, increase the key pointer.
					if ( currentKey.end <= currentShard.end ) {
						keyPointer++;
						if (keyPointer < keys.size()) currentKey = keys.get ( keyPointer);
					}
					else {
						break; // Get out of this cycle, but don't increase the key pointer,
							   // As this key group still can intersect the next shard.
					}
				}
			}	
			if ( currentRange != null ) result.add(currentRange);
		}

		return result;
	}



	public static void main ( String [] args ){
		/*
		 * 1-9, 12-59, 100-999 <- shards (input)
		 * 2-3, 6-8, 11-20, 200-220 <- keys (input)
		 * 2-8, 12-20, 200-220 <- ranges (output)
		 */

		ArrayList < Shard > shards = new ArrayList < Shard >();
		ArrayList < Key > keys = new ArrayList < Key >();
		
		shards.add(new Shard (1,9));
		shards.add(new Shard (12,59));
		shards.add(new Shard (100,999));

		keys.add(new Key (2,3));
		keys.add(new Key (6,8));
		keys.add(new Key (11,20));
		keys.add(new Key (200,220));
		
		List<Range> ranges = new Interview().getRanges(shards, keys);

		for ( Range r : ranges ){
			System.out.print ( r.start + "-" + r.end + " ");
		}

		
		// Other test cases to consider:
		
		// Shards and keys empty.
		// Shards and keys not intersecting.
		// A long shard that covers several keys.
		// A long key that covers several shards.
		// Shards and keys that start in Integer.MIN_VALUE.
		// Shards and keys that start in Integer.MAX_VALUE.

		
	}

}

class Shard {
	int start;
	int end;

	Shard ( int start, int end){
		this.start = start;
		this.end = end;
	}
}

class Key {
	int start;
	int end;

	Key ( int start, int end){
		this.start = start;
		this.end = end;
	}
}

class Range {
	int start;
	int end;

	Range ( int start, int end){
		this.start = start;
		this.end = end;
	}

	Range (){
		this (-1, -1);
	}
}

