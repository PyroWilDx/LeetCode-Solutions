class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[i + j] = nums1[i];
                i++;
            } else {
                nums[i + j] = nums2[j];
                j++;
            }
        }
        for (int k = i; k < m; k++) {
            nums[k + j] = nums1[k];
        }
        for (int k = j; k < n; k++) {
            nums[i + k] = nums2[k];
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = nums[k];
        }
    }
}
