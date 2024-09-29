import java.util.List;

class Solution {
    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return true;
        }

        intervals.sort((a, b) -> {
            return Integer.compare(a.start, b.start);
        });

        int lastEnd = -1;
        for (Interval interval : intervals) {
            if (interval.start < lastEnd) {
                return false;
            }

            lastEnd = interval.end;
        }

        return true;
    }
}
