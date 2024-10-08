class Solution {
    public int missingNumber(int[] nums) {
        int numsSum = 0;
        for (int num : nums) {
            numsSum += num;
        }
        int n = nums.length;
        return (n * (n + 1)) / 2 - numsSum;
    }
}
