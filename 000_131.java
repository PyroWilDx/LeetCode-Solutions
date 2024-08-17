import java.util.ArrayList;
import java.util.List;

class Solution {
    private String s;
    private char[] sArray;
    private int N;
    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.s = s;
        this.sArray = s.toCharArray();
        this.N = s.length();

        result = new ArrayList<>();

        List<String> l = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            partitionRec(0, i + 1, l);
        }

        return result;
    }

    public void partitionRec(int start, int end, List<String> l) {
        if (!isPalindrome(start, end)) {
            return;
        }

        if (end == N) {
            List<String> r = new ArrayList<>(l);
            r.add(s.substring(start, end));
            result.add(r);
            return;
        }

        l.add(s.substring(start, end));
        for (int i = end; i < N; i++) {
            partitionRec(end, i + 1, l);
        }
        l.remove(l.size() - 1);
    }

    private boolean isPalindrome(int start, int end) {
        end--;
        while (start < end) {
            if (sArray[start] != sArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
