import java.util.ArrayList;
import java.util.List;

class Solution {
    private char[][] numsMap = new char[][] {
            {},
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' }
    };

    String digits;
    private List<String> result;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();

        this.digits = digits;

        result = new ArrayList<>();
        StringBuilder l = new StringBuilder();
        letterCombinationsRec(0, l);
        return result;
    }

    public void letterCombinationsRec(int index, StringBuilder l) {
        if (index == digits.length()) {
            result.add(l.toString());
            return;
        }

        char[] chars = numsMap[digits.charAt(index) - '0' - 1];
        for (int i = 0; i < chars.length; i++) {
            l.append(chars[i]);
            letterCombinationsRec(index + 1, l);
            l.deleteCharAt(l.length() - 1);
        }
    }
}
