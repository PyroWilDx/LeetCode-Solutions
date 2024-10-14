class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int i = (l + r) / 2;
            if (target == nums[i]) {
                return i;
            }
            if (target < nums[i]) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return l;
    }
}
