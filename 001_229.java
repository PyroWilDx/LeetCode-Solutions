import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] slot1, int[] slot2) {
                return slot1[0] - slot2[0];
            }
        };
        Arrays.sort(slots1, comparator);
        Arrays.sort(slots2, comparator);

        int i = 0;
        int j = 0;
        while (i < slots1.length && j < slots2.length) {
            if (slots1[i][0] < slots2[j][1] && slots2[j][0] < slots1[i][1]) {
                int maxStart = Math.max(slots1[i][0], slots2[j][0]);
                int minEnd = Math.min(slots1[i][1], slots2[j][1]);
                if (minEnd - maxStart >= duration) {
                    return Arrays.asList(maxStart, maxStart + duration);
                }
            }
            if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.asList();
    }
}
