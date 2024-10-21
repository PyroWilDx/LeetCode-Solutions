import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        int startNum = nums[0];
        int endNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == endNum) {
                endNum = nums[i];
                continue;
            }

            addInterval(result, startNum, endNum);

            startNum = nums[i];
            endNum = nums[i];
        }

        addInterval(result, startNum, endNum);

        return result;
    }

    public void addInterval(List<String> intervals, int startNum, int endNum) {
        if (startNum == endNum) {
            intervals.add(String.valueOf(endNum));
        } else {
            intervals.add(String.format("%d->%d", startNum, endNum));
        }
    }
}
