package interv.g.i1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class InterviewTests {

	ArrayList < Shard > shards = new ArrayList < Shard >();
	ArrayList < Key > keys = new ArrayList < Key >();
	// @beforeAll
	public void init(){
	    System.out.println("Before All init() method called");
	    shards = new ArrayList < Shard >();
		keys = new ArrayList < Key >();
	}
	
	@Test
	public void test1 (){

		shards = new ArrayList < Shard >();
		keys = new ArrayList < Key >();

		shards.add(new Shard (1,9));
		shards.add(new Shard (12,59));
		shards.add(new Shard (100,999));

		keys.add(new Key (2,3));
		keys.add(new Key (6,8));
		keys.add(new Key (11,20));
		keys.add(new Key (200,220));

		//		ranges.add(new Range (2,8));
		//		ranges.add(new Range (12,20));
		//		ranges.add(new Range (200,220));

		List<Range> ranges = new Interview().getRanges(shards, keys);

		assertEquals(ranges.size(), 3);
		
	}
	
}
