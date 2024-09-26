class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int val = 0;
        for (int num : nums) {
            val = Math.max(0, val);
            val += num;
            result = Math.max(val, result);
        }
        return result;
    }
}
