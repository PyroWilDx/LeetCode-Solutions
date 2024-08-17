import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int target = -nums[i];
            if (target < 0)
                return result;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    int second = nums[j];
                    int third = nums[k];
                    result.add(new ArrayList<>(Arrays.asList(-target, second, third)));
                    int newJ = j;
                    while (nums[newJ] == second) {
                        newJ++;
                        if (newJ >= k)
                            break;
                    }
                    int newK = k;
                    while (nums[newK] == third) {
                        newK--;
                        if (j >= newK)
                            break;
                    }
                    j = newJ;
                    k = newK;
                    continue;
                }
                if (sum < target)
                    j++;
                else
                    k--;
            }
        }

        return result;
    }
}
