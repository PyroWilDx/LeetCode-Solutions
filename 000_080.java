class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int currNumCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
                currNumCount = 1;
            } else {
                if (currNumCount < 2) {
                    nums[k++] = nums[i];
                    currNumCount++;
                }
            }
        }
        return k;
    }
}
