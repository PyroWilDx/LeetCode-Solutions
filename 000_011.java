class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int w = j - i;
            int h = Math.min(height[i], height[j]);
            int square = w * h;
            if (square > result) result = square;

            if (height[i] < height[j]) i++;
            else j--;
        }

        return result;
    }
}
