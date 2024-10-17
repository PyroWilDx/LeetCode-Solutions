import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public int[] frequencySort(int[] nums) {
        List<TreeSet<Integer>> freqs = new ArrayList<>();
        Map<Integer, Integer> freqsMap = new HashMap<>();
        freqs.add(new TreeSet<>());

        for (int num : nums) {
            if (!freqsMap.containsKey(num)) {
                addFreq(freqs, 1, num);
                freqsMap.put(num, 1);
            } else {
                int newFreq = freqsMap.get(num) + 1;
                addFreq(freqs, newFreq, num);
                freqsMap.put(num, newFreq);
            }
        }

        int[] result = new int[nums.length];
        int currFreq = 0;
        int i = 0;
        for (TreeSet<Integer> numsAtFreq : freqs) {
            for (int num : numsAtFreq) {
                for (int k = 0; k < currFreq; k++) {
                    result[i] = num;
                    i++;
                }
            }
            currFreq++;
        }
        return result;
    }

    public void addFreq(List<TreeSet<Integer>> freqs, int freq, int num) {
        if (freqs.size() <= freq) {
            freqs.add(new TreeSet<>(Collections.reverseOrder()));
        }
        freqs.get(freq - 1).remove(num);
        freqs.get(freq).add(num);
    }
}
