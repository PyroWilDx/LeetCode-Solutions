import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }

        List<int[]> resultList = new ArrayList<>();
        int i = 0;
        int[] interval = intervals[i];
        while (interval[1] < newInterval[0]) {
            resultList.add(interval);
            i++;
            if (i == intervals.length) {
                break;
            }
            interval = intervals[i];
        }

        if (i == intervals.length && interval[1] < newInterval[0]) {
            resultList.add(newInterval);
        } else {
            int mergedStart = Math.min(interval[0], newInterval[0]);
            if (newInterval[1] < interval[0]) {
                resultList.add(newInterval);
            } else {
                i++;
                if (i < intervals.length) {
                    interval = intervals[i];
                    while (newInterval[1] >= interval[0]) {
                        i++;
                        if (i == intervals.length) {
                            break;
                        }
                        interval = intervals[i];
                    }
                }
                int mergedEnd = Math.max(intervals[i - 1][1], newInterval[1]);
                resultList.add(new int[] { mergedStart, mergedEnd });
            }
            while (i < intervals.length) {
                resultList.add(intervals[i]);
                i++;
            }
        }

        int[][] result = new int[resultList.size()][];
        for (i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
