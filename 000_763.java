import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] charLastPosition = new int[256];

        for (int i = 0; i < s.length(); i++) {
            charLastPosition[s.charAt(i)] = i;
        }

        List<Integer> result = new ArrayList<>();
        int startPosition = 0;
        int lastPosition = 0;
        for (int i = 0; i < s.length(); i++) {
            lastPosition = Math.max(charLastPosition[s.charAt(i)], lastPosition);
            if (i == lastPosition) {
                result.add(lastPosition - startPosition + 1);
                startPosition = i + 1;
            }
        }
        return result;
    }
}
