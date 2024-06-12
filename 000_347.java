import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static final int N = 1;

    public int[] topKFrequent(int[] nums, int k) {
        if (N == 0) return getSol0(nums, k);
        return getSol1(nums, k);
    }

    public int[] getSol0(int[] nums, int k) {
        HashMap<Integer, Integer> numsCounts = new HashMap<>();
        for (int num : nums) {
            if (!numsCounts.containsKey(num)) {
                numsCounts.put(num, 1);
            }
            numsCounts.put(num, numsCounts.get(num) + 1);
        }

        Pair[] pairs = new Pair[numsCounts.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> pair : numsCounts.entrySet()) {
            pairs[i] = new Pair(pair.getKey(), pair.getValue());
            i++;
        }
        Arrays.sort(pairs);
        int[] result = new int[k];
        for (i = 0; i < k; i++) {
            result[i] = pairs[i].x1;
        }
        return result;
    }

    public int[] getSol1(int[] nums, int k) {
        HashMap<Integer, Integer> numsCounts = new HashMap<>();
        int maxValue = 0;
        for (int num : nums) {
            if (!numsCounts.containsKey(num)) {
                numsCounts.put(num, 1);
            }
            int newCount = numsCounts.get(num) + 1;
            numsCounts.put(num, newCount);
            if (newCount > maxValue) maxValue = newCount;
        }
        
        ArrayList<Integer>[] bArray = new ArrayList[maxValue + 1];
        for (Map.Entry<Integer, Integer> pair : numsCounts.entrySet()) {
            int iCount = pair.getValue();
            if (bArray[iCount] == null) bArray[iCount] = new ArrayList<>();
            bArray[iCount].add(pair.getKey());
        }

        int[] result = new int[k];
        int i = 0;
        int iCount = maxValue;
        while (k > 0) {
            ArrayList<Integer> numbers = bArray[iCount];
            if (numbers == null || numbers.isEmpty()) {
                iCount--;
                continue;
            }
            result[i] = numbers.remove(numbers.size() - 1);
            i++;
            k--;
        }

        return result;
    }

    static class Pair implements Comparable<Pair> {
        public int x1;
        public int x2;

        public Pair(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }

        public int compareTo(Pair otherPair) {
            return otherPair.x2 - x2;
        }
    }
}
