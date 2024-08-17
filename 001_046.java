import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int w : stones) {
            pQueue.add(w);
        }
        while (pQueue.size() > 1) {
            int y = pQueue.poll();
            int x = pQueue.poll();
            if (x != y) {
                pQueue.offer(y - x);
            }
        }
        return pQueue.isEmpty() ? 0 : pQueue.peek();
    }
}
