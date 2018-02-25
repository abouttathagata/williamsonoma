import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RangeAssignment {
	
	/**
	 * Compare the ranges
	 * Encapsulation
	 */
	public static class RangeComparator implements Comparator<Range> {

		@Override
		public int compare(Range a, Range b) {
			if(a.start <= b.start) {
				if(a.start == b.start) {
					if(a.end <= b.end) {
						if(a.end < b.end) {
							return -1;
						} else {
							return 0;
						}
					} else {
						return 1;
					}
				}
				return -1;
			}
			return 1;
		}
	}
	
	/**
	 * @param inputRanges
	 * Merges the sorted ranges 
	 */
	public static List<Range> mergeRanges(List<Range> inputRanges) {
		
		List<Range> result = new ArrayList<Range>();
		
		//if(inputRanges == null || inputRanges.size() == 0) return result;
		
		Set<Range> sortedRanges = new TreeSet<Range>(new RangeComparator());		// TreeSet will confirm the uniq ranges and no sorting required
		sortedRanges.addAll(inputRanges);
		/*System.out.println("Sorted Ranges : ");
		for (Range range : sortedRanges) {
			System.out.println(range);
		}*/
		List<Range> ranges = new ArrayList<Range>(sortedRanges);
		Range prev = new Range(ranges.get(0).start, ranges.get(0).end);
		for (int i=0; i<ranges.size(); i++) {
			Range current = ranges.get(i);
			if(current.start <= prev.end) {
				prev.end = Math.max(prev.end, current.end);
			} else {
				result.add(prev);
				prev=current;
			}
		}
		result.add(prev);
		return result;
	}

	public static void main(String[] args) {
		List<Range> ranges = new ArrayList<Range>();
		ranges.add(new Range(920, 935));
		ranges.add(new Range(900, 970));
		ranges.add(new Range(900, 950));
		ranges.add(new Range(900, 925));
		ranges.add(new Range(970, 1025));
		ranges.add(new Range(900, 925));
		ranges.add(new Range(1050, 1100));
		
		System.out.println("Before Merge:");
		for (Range range : ranges) {
			System.out.println(range);
		}
		
		List<Range> mergedRanges = mergeRanges(new ArrayList<Range>(ranges));
		System.out.println("After Merge:");
		for (Range range : mergedRanges) {
			System.out.println(range);
		}
	}

}
