import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;

        LinkedList<Integer> maxQueue = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (left != 0 && nums[left - 1] == maxQueue.peekFirst())
                maxQueue.removeFirst();

            final int addedNumber = nums[right];
            if (!maxQueue.isEmpty() && addedNumber > maxQueue.peekFirst())
                maxQueue.clear();
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < addedNumber)
                maxQueue.removeLast();
            maxQueue.addLast(addedNumber);

            if (right - left + 1 >= k) {
                result[left++] = maxQueue.peekFirst();
            }

            right++;
        }

        return result;
    }
}
