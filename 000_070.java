class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int lastVal = 1; // n
        int currVal = 1; // n - 1
        int k = n - 2;
        while (k >= 0) {
            int nextLastVal = currVal;
            currVal = currVal + lastVal;
            lastVal = nextLastVal;
            k--;
        }
        return currVal;
    }
}
