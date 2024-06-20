class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return searchRec(nums, target, 0, nums.length);
    }

    public int searchRec(int[] nums, int target, int i, int j) {
        if (i == j) return -1;
        int m = (i + j) / 2;
        if (nums[m] == target) return m;
        if (nums[m] < target) {
            return searchRec(nums, target, m + 1, j);
        }
        return searchRec(nums, target, i, m);    
    }
}
