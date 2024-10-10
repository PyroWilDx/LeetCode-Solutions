import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numsCounts = new HashMap<>();
        for (int num : arr) {
            numsCounts.put(num, numsCounts.getOrDefault(num, 0) + 1);
        }
        Set<Integer> occurences = new HashSet<>();
        for (int occurence : numsCounts.values()) {
            if (!occurences.add(occurence)) {
                return false;
            }
        }
        return true;
    }
}
