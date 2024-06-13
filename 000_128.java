import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public static final int N = 1;

    public int longestConsecutive(int[] nums) {
        if (N == 0) return getSol0(nums);
        return getSol1(nums);
    }

    public int getSol0(int[] nums) {
        HashMap<Integer, Integer> numsSeqMap = new HashMap<>();
        for (int num : nums) {
            if (numsSeqMap.containsKey(num - 1)) numsSeqMap.put(num - 1, num);

            if (numsSeqMap.containsKey(num + 1)) numsSeqMap.put(num, num + 1);
            else numsSeqMap.put(num, null);
        }

        int result = 0;
        HashSet<Integer> checked = new HashSet<>();
        for (int key : numsSeqMap.keySet()) {
            if (checked.contains(key)) continue;

            int seqLength = 1;
            Integer value = numsSeqMap.get(key);
            checked.add(value);
            while (value != null) {
                value = numsSeqMap.get(value);
                checked.add(value);
                seqLength++;
            }
            if (seqLength > result) result = seqLength;
        }

        return result;
    }

    public int getSol1(int[] nums) {
        if (nums.length == 0) return 0;

        int result = 1;
        
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int num : numsSet) {
            if (numsSet.contains(num - 1)) continue;

            int value = num;
            while (numsSet.contains(++value));
            int seqLength = value - num;
            if (seqLength > result) result = seqLength; 
        }

        return result;
    }
}
