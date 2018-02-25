import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RangeAssingnmentTest {
	
	//@Test // Negative Test Case
	public void testForEmptyInput() {
		List<Range> ranges = new ArrayList<Range>();
		
		RangeAssignment x = new RangeAssignment();
		
		@SuppressWarnings("static-access")
		List<Range> mergedRanges = x.mergeRanges(ranges); 
		assertEquals(0, mergedRanges.size());
	}
	
	//@Test // Negative Test Case
	public void testForException() {
		new Range(12, 10);
	}
	
	//@Test
	public void testForCorrectSize() {
		List<Range> ranges = new ArrayList<Range>();
		
		ranges.add(new Range(920, 950));
		ranges.add(new Range(900, 970));
		ranges.add(new Range(900, 950));
		ranges.add(new Range(900, 950));
		ranges.add(new Range(970, 1150));
		
		RangeAssignment x = new RangeAssignment();
		
		@SuppressWarnings("static-access")
		List<Range> mergedRanges = x.mergeRanges(ranges); 
		assertEquals(1, mergedRanges.size());
		assertEquals(ranges.size(), mergedRanges.size());
	}
	//@Test
	public void testForEndRange() {
		List<Range> ranges = new ArrayList<Range>();
		
		ranges.add(new Range(920, 935));
		ranges.add(new Range(900, 970));
		ranges.add(new Range(900, 950));
		ranges.add(new Range(900, 925));
		ranges.add(new Range(970, 1025));
		ranges.add(new Range(900, 925));
		
		RangeAssignment x = new RangeAssignment();
		@SuppressWarnings("static-access")
		List<Range> mergedRanges = x.mergeRanges(ranges);
		assertEquals(1025, mergedRanges.get(0).end);
	}
	@Test
	public void testForStartRange() {
		List<Range> ranges = new ArrayList<Range>();
		
		ranges.add(new Range(920, 935));
		ranges.add(new Range(900, 970));
		ranges.add(new Range(900, 950));
		ranges.add(new Range(900, 925));
		ranges.add(new Range(970, 1025));
		ranges.add(new Range(800, 1225));
		
		RangeAssignment x = new RangeAssignment();
		@SuppressWarnings("static-access")
		List<Range> mergedRanges = x.mergeRanges(ranges);
		assertEquals(800, mergedRanges.get(0).start);
	}
}