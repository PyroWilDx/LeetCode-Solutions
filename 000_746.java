class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0 || cost.length == 1) {
            return 0;
        }

        int k = cost.length - 3;
        while (k >= 0) {
            cost[k] = Math.min(cost[k] + cost[k + 1], cost[k] + cost[k + 2]);
            k--;
        }
        return Math.min(cost[0], cost[1]);
    }
}
