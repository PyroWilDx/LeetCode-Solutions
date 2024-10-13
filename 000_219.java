import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIdxMap.containsKey(nums[i])) {
                int dist = i - numIdxMap.get(nums[i]);
                if (dist <= k) {
                    return true;
                }
            }
            numIdxMap.put(nums[i], i);
        }
        return false;
    }
}
