class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int N = nums.length;

        int[] preArray = new int[N];
        preArray[0] = nums[0];
        for (int i = 1; i < N; i++) {
            preArray[i] = preArray[i - 1] * nums[i]; 
        }

        int[] postArray = new int[N];
        postArray[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            postArray[i] = postArray[i + 1] * nums[i];
        }

        int[] result = new int[N];
        result[0] = postArray[1];
        result[N - 1] = preArray[N - 2];
        for (int i = 1; i < N - 1; i++) {
            result[i] = preArray[i - 1] * postArray[i + 1];
        }
        
        return result;
    }
}
