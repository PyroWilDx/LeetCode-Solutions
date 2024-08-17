import java.util.ArrayList;
import java.util.List;

class Solution {
    private int N;
    private int targetN;
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        N = n;
        targetN = n * 2;
        result = new ArrayList<>();

        generateParenthesisRec(0, 0, "");

        return result;
    }

    public void generateParenthesisRec(int openCount, int closeCount, String currString) {
        if (currString.length() == targetN) {
            result.add(currString);
            return;
        }

        if (openCount < N)
            generateParenthesisRec(openCount + 1, closeCount, currString + "(");
        if (openCount > closeCount)
            generateParenthesisRec(openCount, closeCount + 1, currString + ")");
    }
}
