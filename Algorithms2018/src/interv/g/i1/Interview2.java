package interv.g.i1;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.glassfish.external.statistics.RangeStatistic;

// This is an O(n^2) solution that could have worked.
//
//class Shard {
//	int start;
//	int end;
//
//	Shard ( int start, int end){
//		this.start = start;
//		this.end = end;
//	}
//}
//
//class Key {
//	int start;
//	int end;
//
//	Key ( int start, int end){
//		this.start = start;
//		this.end = end;
//	}
//}
//
//class Range {
//	int start;
//	int end;
//
//	Range ( int start, int end){
//		this.start = start;
//		this.end = end;
//	}
//
//	Range (){
//		this (-1, -1);
//	}
//}

public class Interview2 {

	/**
	 * Solution.
	 * Time complexity: O(S+K) (number of shards plus number of keys)
	 * @param shards Shards
	 * @param keys Keys
	 * @return Ranges
	 */
	public List<Range> getRanges(List<Shard> shards, List<Key> keys){
		List<Range> result = new ArrayList < Range > ();

		int shardPointer = 0, keyPointer = 0;

		if ( shards.size() == 0 || keys.size() == 0 ) return result;

		// Go over every shard, and move the key pointer as long as we are inside the shard.

		for ( shardPointer = 0; shardPointer < shards.size(); shardPointer++){
			Shard currentShard = shards.get(shardPointer);
			Key currentKey = keys.get ( keyPointer);
			Range currentRange = null;

			while ( keyPointer < keys.size() && currentKey.start <= currentShard.end ){
				if ( currentKey.end < currentShard.start ){
					keyPointer++;
					if (keyPointer < keys.size()) currentKey = keys.get ( keyPointer);
				}
				else { 
					if ( currentRange == null ){
						currentRange = new Range ();
						currentRange.start = Math.max(currentShard.start, currentKey.start);
					}
					currentRange.end = Math.min(currentShard.end, currentKey.end);

					if ( currentKey.end <= currentShard.end ) {
						keyPointer++;
						if (keyPointer < keys.size()) currentKey = keys.get ( keyPointer);
					}
					else {
						break; // Get out of this cycle, but don't move the key pointer:
							   // This key range still can intersect the next shard.
					}
					// else, the key may expand over several shards.
				}
			}	
			if ( currentRange != null ) result.add(currentRange);
		}

		return result;
	}


	/**
	 * This method works in O(S*K) time
	 * (S = number of shard ranges, K = number of key ranges)
	 * @param shards
	 * @param keys
	 * @return
	 */
	public List<Range> getRanges_O_SK(List<Shard> shards, List<Key> keys){
		List<Range> result = new ArrayList < Range > ();

		for ( Shard shard: shards){
			Range r = addRange ( shard, keys);
			if ( r != null ) result.add (r);
		}
		return result;
	}

	/**
	 * TODO: DESCRIBE.
	 * @param shard
	 * @param keys
	 * @return
	 */
	private Range addRange(Shard shard, List<Key> keys) {
		Range result = null;
		int start = shard.start, end = shard.end;
		for ( int i = 0; i < keys.size(); i++){
			Key k = keys.get(i);
			if ( k.start > shard.end ) return result;
			if ( k.end >= shard.start ){
				if ( result == null ){
					result = new Range(); 
					start = Math.max(k.start, shard.start);
				}
				end = Math.min(shard.end, k.end);
				result.start = start;
				result.end = end;
			}
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
		//ArrayList < Range > ranges = new ArrayList < Range >();

//		shards.add(new Shard (1,9));
//		shards.add(new Shard (12,59));
//		shards.add(new Shard (100,999));
//
//		keys.add(new Key (2,3));
//		keys.add(new Key (6,8));
//		keys.add(new Key (11,20));
//		keys.add(new Key (200,220));

		
		
//		shards.add( new Shard (5,100));
//		shards.add( new Shard (120,160));
//		shards.add( new Shard (170,180));
//		shards.add( new Shard (200,305));
//		
//		keys.add(new Key (1,6));
//		keys.add(new Key (9,15));
//		keys.add(new Key (37,300));


//		shards.add( new Shard (200,305));
//		
//		keys.add(new Key (1,6));
//		keys.add(new Key (9,15));
//		keys.add(new Key (37,201));
//		keys.add(new Key (304,400));
		shards.add( new Shard (5,100));
		shards.add( new Shard (120,160));
		shards.add( new Shard (170,180));
		shards.add( new Shard (200,305));
		
		keys.add(new Key (1,6));
		keys.add(new Key (9,15));
		keys.add(new Key (37,300));

		List<Range> ranges = new Interview2().getRanges(shards, keys);

		for ( Range r : ranges ){
			System.out.print ( r.start + "-" + r.end + " ");
		}

	}

}
