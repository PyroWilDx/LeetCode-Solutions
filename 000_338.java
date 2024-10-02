class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; i *= 2) {
            int i2 = 0;
            int m = Math.min(i * 2, n + 1);
            for (int k = i; k < m; k++) {
                result[k] = 1 + result[i2];
                i2++;
            }
        }
        return result;
    }
}
