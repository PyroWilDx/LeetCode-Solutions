import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> remainings = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (remainings.containsKey(num)) return new int[] {remainings.get(num), i};
            remainings.put(target - num, i);
        }
        return null;
    }
}
