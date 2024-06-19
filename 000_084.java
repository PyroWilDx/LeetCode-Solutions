import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        final int N = heights.length;

        int result = 0;
        
        Deque<int[]> idxHeights = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int start = i;
            int h = heights[i];
            while (!idxHeights.isEmpty() && h < idxHeights.peekLast()[1]) {
                int[] idxHeight = idxHeights.removeLast();
                int area = (i - idxHeight[0]) * idxHeight[1];
                if (area > result) result = area;
                start = idxHeight[0];
            }
            idxHeights.addLast(new int[] { start, heights[i] });
        }

        while (!idxHeights.isEmpty()) {
            int[] idxHeight = idxHeights.removeLast();
            int area = (N - idxHeight[0]) * idxHeight[1];
            if (area > result) result = area;
        }

        return result;
    }
}
