import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Deque<Integer> tIndexStack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!tIndexStack.isEmpty() && temperatures[tIndexStack.peek()] < t) {
                int k = tIndexStack.pop();
                result[k] = i - k;
            }
            tIndexStack.push(i);
        }

        return result;
    }
}
