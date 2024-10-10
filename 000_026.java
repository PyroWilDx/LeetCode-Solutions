class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int lastNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastNum) {
                nums[k++] = nums[i];
                lastNum = nums[i];
            }
        }
        return k;
    }
}
