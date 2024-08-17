import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class KthLargest {
    private int k;
    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        while (queue.size() > k) {
            queue.poll();
        }
    }

    public int add(int val) {
        if (queue.size() < k)
            queue.add(val);
        else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}
