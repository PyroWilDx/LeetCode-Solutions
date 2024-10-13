import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> seenWords = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(c)) {
                String val = map.get(c);
                if (!word.equals(val)) {
                    return false;
                }
            } else {
                if (seenWords.contains(word)) {
                    return false;
                }
                map.put(c, word);
                seenWords.add(word);
            }
        }
        return true;
    }
}
