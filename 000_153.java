class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) {
            if (nums[0] < nums[1]) return nums[0];
            return nums[1];
        }

        return findMinRec(nums, 0, nums.length);
    }

    public int findMinRec(int[] nums, int i, int j) {
        int m = (i + j) / 2;
        int elBefore = (m != 0) ? nums[m - 1] : nums[nums.length - 1];
        if (elBefore > nums[m]) return nums[m];
        if (i == j) return -6000;
        
        int kSup = (m + 1 + j) / 2;
        if (kSup >= nums.length) return -6000;
        int rSup;
        if (nums[kSup] > nums[m]) rSup = findMinRec(nums, kSup, j);
        else rSup = findMinRec(nums, m + 1, kSup);
        
        int kInf = (i + m + 1) / 2;
        if (kInf < 0) return -6000;
        int rInf;
        if (nums[kInf] > nums[m]) rInf = findMinRec(nums, kInf, m);
        else rInf = findMinRec(nums, i, kInf);

        if (rSup != -6000) return rSup;
        return rInf;
    }
}
