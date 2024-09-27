class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;

        int result = 0;

        int itCount = 0;
        int gasAmount = 0;
        int i = 0;
        int visitedCount = 0;
        while (itCount != N * 2 && visitedCount != N) {
            itCount++;

            gasAmount += gas[i];
            gasAmount -= cost[i];
            if (gasAmount < 0) {
                result = i + 1;

                gasAmount = 0;
                i++;
                if (i == N) {
                    i = 0;
                }
                visitedCount = 0;
                continue;
            }
            i++;
            if (i == N) {
                i = 0;
            }
            visitedCount++;
        }

        if (visitedCount != N) {
            return -1;
        }
        return result;
    }
}
