package pinos;

import java.util.ArrayList;
import java.util.List;

public class PracticeIntervG {

	/*
	 * Have a pointer for shards and another one for keys.
	 * For each shard, move the key pointer until we are sure
	 * that no other key is inside this shard,
	 * and increase ranges accordingly.
	 */
	/*
	 * 1-9, 12-59, 100-999 <- shards (input)
	 * 2-3, 6-8, 11-20, 200-220 <- keys (input)
	 * 2-8, 12-20, 200-220 <- ranges (output)
	 */


	public List<Range> getRanges(List<Shard> shards, List<Key> keys){
		ArrayList < Range > result = new ArrayList < Range > ();

		if ( shards.size() == 0 || keys.size() == 0 ) return result;

		for ( int shardPointer = 0; shardPointer < shards.size(); shardPointer++ ){

			Range r = getRange ( shards.get ( shardPointer ), keys );
			if ( r != null )
				result.add ( r );
		}
		return result;
	}

	public Range  getRange ( Shard shard, List<Key> keys){
		Range range = new Range (0,0);
		// Find start.
		int keyPointer = 0;
		boolean startFound = false;
		Key k = new Key (0,0);
		while ( keyPointer < keys.size() && !startFound){
			k = keys.get ( keyPointer );
			if ( k.end < shard.start )
				keyPointer++;
			else if (k.start < shard.start ){
				range.start = shard.start;
				startFound = true;
				break;
			}
			else if ( k.start >= shard.start && k.start <= shard.end ){
				range.start = k.start;
				startFound = true;
				break;
			}
			else break; // I went beyond.
		}

		if ( !startFound ) return null;

		int prevEnd = k.end;
		keyPointer++;

		while ( keyPointer < keys.size()){
			k = keys.get ( keyPointer );
			if ( k.end < shard.end ) {
				prevEnd = k.end;
				keyPointer++;
			}
			else break;
		}

		range.end = Math.min (prevEnd, shard.end);

		return range;
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

		List<Range> ranges = new PracticeIntervG().getRanges(shards, keys);

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

