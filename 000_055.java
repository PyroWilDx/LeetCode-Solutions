class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                continue;
            }

            int j = i - 1;
            while (j >= 0) {
                if (j + nums[j] > i) {
                    break;
                }
                j--;
            }
            if (j == -1) {
                return false;
            }
        }
        return true;
    }
}
