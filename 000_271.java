import java.util.ArrayList;
import java.util.List;

class Solution {
    public String encode(List<String> strs) {
        String result = "";
        for (String str : strs) {
            result += str.length() + "#" + str;
        }
        return result;
    }

    public List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<>();
        String currCount = "";
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == '#') {
                int charCount = Integer.valueOf(currCount);
                result.add(str.substring(i + 1, i + 1 + charCount));
                currCount = "";
                i = i + 1 + charCount;
            } else {
                currCount += c;
                i++;
            }
        }
        return result;
    }
}
