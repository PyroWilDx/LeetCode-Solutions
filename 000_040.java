import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int[] candidates;
    private int target;
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        this.candidates = candidates;
        this.target = target;

        result = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1])
                continue;

            combinationSum2Rec(0, i);
        }
        return result;
    }

    public List<List<Integer>> combinationSum2Rec(int currSum, int index) {
        currSum = currSum + candidates[index];
        if (currSum == target) {
            List<Integer> l = new ArrayList<>();
            l.add(candidates[index]);
            result.add(l);
            List<List<Integer>> r = new ArrayList<>();
            r.add(l);
            return r;
        } else if (currSum > target)
            return null;

        List<List<Integer>> allL = new ArrayList<>();
        for (int i = index + 1; i < candidates.length; i++) {
            if (i != index + 1 && candidates[i] == candidates[i - 1])
                continue;

            List<List<Integer>> r = combinationSum2Rec(currSum, i);
            if (r != null) {
                for (List<Integer> l : r) {
                    l.add(candidates[index]);
                }
                allL.addAll(r);
            }
        }
        return allL;
    }
}
