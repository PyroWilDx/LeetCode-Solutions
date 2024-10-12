class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        int[] rotatedNums = new int[N];
        for (int i = 0; i < N; i++) {
            rotatedNums[(i + k) % N] = nums[i];
        }
        System.arraycopy(rotatedNums, 0, nums, 0, N);
    }
}
