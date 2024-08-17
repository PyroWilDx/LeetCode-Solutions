import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numsCounts = new HashMap<>();
        int maxValue = 0;
        for (int num : nums) {
            if (!numsCounts.containsKey(num)) {
                numsCounts.put(num, 1);
            }
            int newCount = numsCounts.get(num) + 1;
            numsCounts.put(num, newCount);
            if (newCount > maxValue)
                maxValue = newCount;
        }

        List<List<Integer>> bArray = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : numsCounts.entrySet()) {
            int iCount = pair.getValue();
            if (bArray.get(iCount) == null)
                bArray.set(iCount, new ArrayList<>());
            bArray.get(iCount).add(pair.getKey());
        }

        int[] result = new int[k];
        int i = 0;
        int iCount = maxValue;
        while (k > 0) {
            List<Integer> numbers = bArray.get(iCount);
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
}
