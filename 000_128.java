import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        int result = 1;

        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int num : numsSet) {
            if (numsSet.contains(num - 1))
                continue;

            int value = num;
            while (numsSet.contains(++value))
                ;
            int seqLength = value - num;
            if (seqLength > result)
                result = seqLength;
        }

        return result;
    }
}
