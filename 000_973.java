import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int d1 = getDist(o1);
                int d2 = getDist(o2);
                return d2 - d1;
            }
        });

        for (int i = 0; i < k; i++) {
            pQueue.add(points[i]);
        }

        for (int i = k; i < points.length; i++) {
            if (getDist(points[i]) < getDist(pQueue.peek())) {
                pQueue.poll();
                pQueue.add(points[i]);
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pQueue.poll();
        }
        return result;
    }

    public int getDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
