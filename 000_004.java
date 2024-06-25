class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int N = nums1.length + nums2.length;
        int half = N / 2;

        if (nums1.length > nums2.length) {
            int[] nums = nums1;
            nums1 = nums2;
            nums2 = nums;
        }

        int left = 0;
        int right = nums1.length - 1;
        while (true) {
            int mid = (int) Math.floor((left + right) / 2.0);
            int k = half - (mid + 1) - 1;

            int num1Left = (mid >= 0) ? nums1[mid] : Integer.MIN_VALUE;
            int num1Right = (mid + 1 < nums1.length) ? nums1[mid + 1] : Integer.MAX_VALUE;
            int num2Left = (k >= 0) ? nums2[k] : Integer.MIN_VALUE;
            int num2Right = (k + 1 < nums2.length) ? nums2[k + 1] : Integer.MAX_VALUE;

            if (num1Left <= num2Right && num2Left <= num1Right) {
                if (N % 2 == 0) {
                    int low = Math.max(num1Left, num2Left);
                    int high = Math.min(num1Right, num2Right);
                    return (low + high) / 2.0;
                } else return Math.min(num1Right, num2Right);
            }

            if (num1Left > num2Right) right = mid - 1;
            else left = mid + 1;
        }
    }
}
