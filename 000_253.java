import java.util.Arrays;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int visitedCount = 0;
        int result = 0;
        while (visitedCount != intervals.length) {
            int lastEnd = -1;
            for (int[] interval : intervals) {
                if (interval[0] == -1 || interval[0] < lastEnd) {
                    continue;
                }

                lastEnd = interval[1];
                interval[0] = -1;
                visitedCount++;
            }
            result++;
        }
        return result;
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

// public int minMeetingRooms(List<Interval> intervals) {
// if (intervals.size() == 0) {
// return 0;
// }

// intervals.sort((a, b) -> {
// return Integer.compare(a.start, b.start);
// });

// int visitedCount = 0;
// int result = 0;
// while (visitedCount != intervals.size()) {
// int lastEnd = -1;
// for (Interval interval : intervals) {
// if (interval.start == -1 || interval.start < lastEnd) {
// continue;
// }

// lastEnd = interval.end;
// interval.start = -1;
// visitedCount++;
// }
// result++;
// }
// return result;
// }
// }
