import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int result = 0;
        int currEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < currEnd) {
                result++;
                currEnd = Math.min(intervals[i][1], currEnd);
                continue;
            }

            currEnd = intervals[i][1];
        }
        return result;
    }
}
