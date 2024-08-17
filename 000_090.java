import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int[] nums;
    private List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        this.nums = nums;
        this.result = new ArrayList<>();

        List<Integer> newList = new ArrayList<>();
        result.add(newList);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            subsetsWithDupRec(newList, i);
        }

        return result;
    }

    public void subsetsWithDupRec(List<Integer> lastList, int index) {
        List<Integer> newList = new ArrayList<>(lastList);
        newList.add(nums[index]);
        result.add(newList);
        for (int i = index + 1; i < nums.length; i++) {
            if (i != index + 1 && nums[i] == nums[i - 1])
                continue;

            subsetsWithDupRec(newList, i);
        }
    }
}
