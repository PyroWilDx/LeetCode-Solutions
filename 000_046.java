import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        Set<Integer> numsLeft = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        permuteRec(new ArrayList<>(), numsLeft);
        return result;
    }

    public void permuteRec(List<Integer> r, Set<Integer> numsLeft) {
        if (numsLeft.size() == 0) {
            result.add(r);
            return;
        }

        for (int num : numsLeft) {
            List<Integer> newR = new ArrayList<>(r);
            newR.add(num);
            Set<Integer> newNumsLeft = new HashSet<>(numsLeft);
            newNumsLeft.remove(num);
            permuteRec(newR, newNumsLeft);
        }
    }
}
