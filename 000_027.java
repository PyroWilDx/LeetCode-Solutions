class Solution {
    public int removeElement(int[] nums, int val) {
        int result = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
                result++;
            }
        }
        return result;
    }
}
