import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numsCount = new HashMap<>();
        int result = nums[0];
        int maxCount = 1;
        for (int num : nums) {
            int newCount = numsCount.getOrDefault(num, 0) + 1;
            numsCount.put(num, newCount);

            if (newCount > maxCount) {
                result = num;
                maxCount = newCount;
            }
        }
        return result;
    }
}
