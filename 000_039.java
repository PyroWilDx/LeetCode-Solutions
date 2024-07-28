import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] candidates;
    private int target;
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;

        result = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            combinationSumRec(0, i);
        }
        return result;
    }

    public List<List<Integer>> combinationSumRec(int sum, int index) {
        int num = candidates[index];
        sum = sum + num;

        if (sum == target) {
            List<List<Integer>> r = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            l.add(num);
            r.add(l);
            result.add(l);
            return r;
        } else if (sum > target) {
            return null;
        }

        List<List<Integer>> r = new ArrayList<>();
        for (int i = index; i < candidates.length; i++) {
            List<List<Integer>> r1 = combinationSumRec(sum, i);
            if (r1 != null) {
                r.addAll(r1);
            }
        }

        for (List<Integer> l : r) {
            l.add(num);
        }

        return !r.isEmpty() ? r : null;
    }
}
