class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int result = 1;
        int min = 1;
        int max = nums[0];
        while (max < nums.length - 1) {
            int lastMax = max;
            for (int i = min; i <= lastMax; i++) {
                max = Math.max(i + nums[i], max);
            }
            min = lastMax + 1;
            result++;
        }

        return result;
    }
}
