class Solution {
    public static final int N = 1;

    public int trap(int[] height) {
        if (N == 0) return getSol0(height);
        return getSol1(height);
    }

    public int getSol0(int[] height) {
        if (height.length <= 2) return 0;
                
        int lastIndex = height.length - 1;
        while (lastIndex >= 1 && height[lastIndex - 1] >= height[lastIndex]) lastIndex--; 
        if (lastIndex < 2) return 0;

        int firstIndex = 0;
        while (firstIndex < height.length - 1 && height[firstIndex + 1] >= height[firstIndex]) firstIndex++;
        if (firstIndex >= height.length - 2) return 0;

        if (firstIndex >= lastIndex) return 0;

        int result = 0;

        int i = firstIndex;
        while (i < lastIndex) {
            int j = i + 1;
            int currMaxHeightJIndex = j;
            while (j < lastIndex && height[j] < height[i]) {
                j++;
                if (height[j] >= height[currMaxHeightJIndex]) currMaxHeightJIndex = j;
            }
            if (j == lastIndex) j = currMaxHeightJIndex;
            int minHeight = Math.min(height[i], height[j]);
            for (int k = i + 1; k < j; k++) {
                if (minHeight <= height[k]) continue;
                result += minHeight - height[k];
            }
            i = j;
        }

        return result;
    }

    public int getSol1(int[] height) {
        int n = height.length;

        if (n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(left[i], right[i]);
            result += minHeight - height[i];
        }

        return result;
    }
}
