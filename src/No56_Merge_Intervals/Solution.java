package No56_Merge_Intervals;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

class Interval {
    int start;
    int end;

    public Interval() {
        this.start = 0;
        this.end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();
        intervals.sort(Comparator.comparingInt(i -> i.start));
        if (intervals.size() == 0) {
            return result;
        }
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval source = result.get(result.size() - 1);
            Interval target = intervals.get(i);
            if (source.end >= target.start && source.end < target.end) {
                source.end = target.end;
            } else if (source.end < target.start) {
                result.add(target);
            }
        }
        return result;
    }

}
