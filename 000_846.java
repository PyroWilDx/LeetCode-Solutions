import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int num : hand) {
            if (!numsMap.containsKey(num)) {
                numsMap.put(num, 0);
            }
            numsMap.put(num, numsMap.get(num) + 1);
        }

        Queue<Integer> numQueue = new PriorityQueue<>(numsMap.keySet());
        while (!numQueue.isEmpty()) {
            int num = numQueue.peek();
            for (int i = 0; i < groupSize; i++) {
                Integer count = numsMap.get(num);
                if (count == null) {
                    return false;
                }
                if (count == 0) {
                    return false;
                }
                if (count == 1) {
                    numQueue.poll();
                }
                numsMap.put(num, count - 1);
                num++;
            }
        }

        return true;
    }
}
