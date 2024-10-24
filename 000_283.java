import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int numberOfZeros = 0;

        int nonZeroIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[nonZeroIndex] = num;
                nonZeroIndex++;
            } else {
                numberOfZeros++;
            }
        }

        Arrays.fill(nums, nums.length - numberOfZeros, nums.length, 0);
    }
}
