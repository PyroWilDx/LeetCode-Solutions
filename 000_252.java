import java.util.Arrays;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int lastEnd = -1;
        for (int[] interval : intervals) {
            if (interval[0] < lastEnd) {
                return false;
            }

            lastEnd = interval[1];
        }

        return true;
    }
}

// import java.util.List;

// class Solution {
// public class Interval {
// public int start, end;

// public Interval(int start, int end) {
// this.start = start;
// this.end = end;
// }
// }

// public boolean canAttendMeetings(List<Interval> intervals) {
// if (intervals.size() == 0) {
// return true;
// }

// intervals.sort((a, b) -> {
// return Integer.compare(a.start, b.start);
// });

// int lastEnd = -1;
// for (Interval interval : intervals) {
// if (interval.start < lastEnd) {
// return false;
// }

// lastEnd = interval.end;
// }

// return true;
// }
// }
