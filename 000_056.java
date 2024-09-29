import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        List<int[]> resultList = new ArrayList<>();
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (currEnd < intervals[i][0]) {
                resultList.add(new int[] { currStart, currEnd });
                currStart = intervals[i][0];
                currEnd = intervals[i][1];
                continue;
            }

            currStart = Math.min(intervals[i][0], currStart);
            currEnd = Math.max(intervals[i][1], currEnd);
        }

        resultList.add(new int[] { currStart, currEnd });

        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
