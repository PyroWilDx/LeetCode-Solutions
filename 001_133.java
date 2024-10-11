class Solution {
    public int largestUniqueNumber(int[] nums) {
        int[] numsCount = new int[1001];
        for (int num : nums) {
            numsCount[num]++;
        }
        int result = -1;
        for (int i = numsCount.length - 1; i >= 0; i--) {
            if (numsCount[i] == 1) {
                result = i;
                break;
            }
        }
        return result;
    }
}
